package edu.gonet.vuelos.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
* Excepciones para informar rechazos por validaciones de las reglas de negocio 
* en los servicios consumidos
*/
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BusinessException extends RuntimeException {
	/**
	 *  Default serial version
	 */
	private static final long serialVersionUID = 1L;
	
	final private Integer code;
	
	private Object[] messageArgs;
	
    /**
     * @param  code   el código de error. El código de error es almacenado para
     *         su posterior obtención por el método {@link #getCode()}.
     * @param  message el mensaje detallado (el cual es alamcenado para su 
     *         posterior obtención por el método {@link #getMessage()}).
     */
    public BusinessException (Integer code, String message) {
        super(message);
        this.code = code;
    }
    
    /**
     * @param  code   el código de error. El código de error es almacenado para
     *         su posterior obtención por el método {@link #getCode()}.
     * @param  message el mensaje detallado (el cual es alamcenado para su 
     *         posterior obtención por el método {@link #getMessage()}).
     * @param args un arreglo de argumentos que serán utilizados en los 
     * parámetros del mensaje (los parámetros se muestran como "{0}", "{1,date}"
     * , "{2,time}" de un mensaje), o {@code null} si no requiere
     */
    public BusinessException (Integer code, String message, Object... args) {
        super(message);
        this.code = code;
        this.messageArgs = args;
    }
    
    /**
     * @param  code   el código de error. El código de error es almacenado para
     *         su posterior obtención por el método {@link #getCode()}.
     * @param  message el mensaje detallado (el cual es alamcenado para su 
     *         posterior obtención por el método {@link #getMessage()}).
     * @param  cause el motivo (el cual es alamcenado para su posterior obtención
     *         por el método {@link #getCause()}).  (Un valor <tt>null</tt>
     *         es permitido, e indidcaque no existe una causa o no es conocida)
     * @see java.lang.RuntimeException#Exception(String message, Throwable cause)
     */
    public BusinessException (Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * @param  code   el código de error. El código de error es almacenado para
     *         su posterior obtención por el método {@link #getCode()}.
     * @param  cause el motivo (el cual es alamcenado para su posterior obtención
     *         por el método {@link #getCause()}).  (Un valor <tt>null</tt>
     *         es permitido, e indidcaque no existe una causa o no es conocida)
     * @see java.lang.RuntimeException#Exception(Throwable cause)
     */
    public BusinessException (Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    /**
     * @return el código de error de la excepción
     */
    public Integer getCode() {
        return code;
    }
    
    /**
     * @return los argumentos para el mensaje
     */
    public Object[] getMessageArgs() {
        return this.messageArgs;
    }
}
