package edu.gonet.vuelos.presentation.controller;

import java.util.Objects;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;

import edu.gonet.vuelos.business.dto.GenericResponse;
import edu.gonet.vuelos.business.exception.BusinessException;
import edu.gonet.vuelos.business.exception.InternalServerException;
import edu.gonet.vuelos.business.exception.InvalidReceivedDataException;
import edu.gonet.vuelos.business.util.Business.Constants.ErrorCode;
import edu.gonet.vuelos.persistence.entities.GenericEntity;
import edu.gonet.vuelos.presentation.util.Constants.Message;

public abstract class GenericController {
    
    private static final Logger LOGGER = LogManager.getLogger(GenericController.class);
    
    MessageSource messageSource;
    
    public GenericController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    protected String getMessage(String code, String defaultMessage) {
        return messageSource.getMessage(code, null, defaultMessage, LocaleContextHolder.getLocale());
    }
    
    protected String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
    
    protected String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
    
    protected void setCommonMessageForData(GenericResponse<? extends Object> genericResponse) {
        if (Objects.isNull(genericResponse.getData())) {
            
            throw new BusinessException(ErrorCode.NOT_FOUND_DATA,Message.COMMON_NOT_FOUND_DATA);
        } else {
            genericResponse.setResponseCode(ErrorCode.SUCCESS);
            genericResponse.setMessage(getMessage(Message.COMMON_SUCCESS_DATA));
        }
    }
    
    protected void setCommonMessageForCreate(GenericResponse<? extends GenericEntity> genericResponse) {
        if (Objects.isNull(genericResponse.getData()) || Objects.isNull(genericResponse.getData().getId())) {
        	throw new InvalidReceivedDataException(getMessage(Message.COMMON_NOT_FOUND_DATA));
        } else {
            genericResponse.setResponseCode(ErrorCode.SUCCESS);
            genericResponse.setMessage(getMessage(Message.COMMON_SUCCESS_CREATE));
        }
    }
    
    protected void manageCommonException(Exception e, GenericResponse<?> response) {
        
        if (e instanceof MyBatisSystemException) {
            
            response.setResponseCode(ErrorCode.DB_ERROR);
            response.setMessage(getMessage(Message.COMMON_DB_CONNECTION_ERROR));
            
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(response.getMessage(), e);
            } else if (LOGGER.isInfoEnabled()) {
                LOGGER.info(response.getMessage());
            } else if (LOGGER.isErrorEnabled()) {
                LOGGER.error(response.getMessage(), e);
            }
            
            throw new InternalServerException(response.getMessage(), e);
              
        } else if (e instanceof DuplicateKeyException) {
        
	        response.setResponseCode(ErrorCode.DB_ERROR);
	        response.setMessage(getMessage(Message.COMMON_ERROR));
	        
	        if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug(response.getMessage(), e);
	        } else if (LOGGER.isInfoEnabled()) {
	            LOGGER.info(response.getMessage());
	        }
	        
	        throw new InvalidReceivedDataException(response.getMessage(), e);
        
        } else if (e instanceof PersistenceException || e instanceof BadSqlGrammarException
                    || e instanceof DataAccessException) {
            
            response.setResponseCode(ErrorCode.DB_ERROR);
            response.setMessage(getMessage(Message.COMMON_DB_ERROR));
            
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(response.getMessage(), e);
            } else if (LOGGER.isInfoEnabled()) {
                LOGGER.info(response.getMessage());
            }
            
            throw new InternalServerException(response.getMessage(), e);
            
        } else if (e instanceof BusinessException) {
            
            response.setResponseCode(((BusinessException) e).getCode());
            response.setMessage(getMessage(e.getMessage(), ((BusinessException) e).getMessageArgs()));
            
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(response.getMessage(), e);
            } else if (LOGGER.isInfoEnabled()) {
                LOGGER.info(response.getMessage());
            }
            
            throw new BusinessException(response.getResponseCode(), response.getMessage());
            
        } else if (e instanceof InvalidReceivedDataException) {
            
            response.setResponseCode(ErrorCode.INVALID_RECEIVED_DATA);
            response.setMessage(getMessage(Message.COMMON_INVALID_RECEIVED_DATA, new Object[]{Objects.isNull(e.getMessage())?"":"'".concat(e.getMessage()).concat("'")}));
            
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(response.getMessage(), e);
            }
            
            throw new InvalidReceivedDataException(response.getMessage(), e);
            
        } else {
            
            response.setResponseCode(ErrorCode.UNKNOWN_ERROR);
            response.setMessage(getMessage(Message.COMMON_UNKNOWN_ERROR));
            
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error(getMessage(Message.COMMON_UNKNOWN_ERROR, Message.COMMON_UNKNOWN_ERROR), e);
            }
            
            throw new InternalServerException(response.getMessage(), e);
            
        }

    }

}