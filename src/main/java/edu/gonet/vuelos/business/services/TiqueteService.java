package edu.gonet.vuelos.business.services;

import edu.gonet.vuelos.business.dto.TiqueteDTO;

public interface TiqueteService {

	TiqueteDTO create(TiqueteDTO datosPago) throws Exception;
	
	TiqueteDTO find(Long id) throws Exception;
	
}
