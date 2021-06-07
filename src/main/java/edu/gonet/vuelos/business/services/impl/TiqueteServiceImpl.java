package edu.gonet.vuelos.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.gonet.vuelos.business.dto.TiqueteDTO;
import edu.gonet.vuelos.business.services.TiqueteService;
import edu.gonet.vuelos.persistence.mapper.TiqueteMapper;

@Service
public class TiqueteServiceImpl implements TiqueteService {
    
	@Autowired
    private TiqueteMapper tiqueteMapper;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TiqueteDTO create(TiqueteDTO datosTiquete) {
    	
    	tiqueteMapper.insert(datosTiquete);
    	
    	return datosTiquete;
    }
    
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TiqueteDTO find(Long id) {
    	
    	return tiqueteMapper.get(id);
    }
    
}
