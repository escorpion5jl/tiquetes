package edu.gonet.vuelos.presentation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.gonet.vuelos.business.dto.GenericResponse;
import edu.gonet.vuelos.business.dto.TiqueteDTO;
import edu.gonet.vuelos.business.exception.InvalidReceivedDataException;
import edu.gonet.vuelos.business.services.TiqueteService;

@RestController
@RequestMapping("tiquetes")
public class TiquetesApi extends GenericController {
    
    @Autowired
    TiqueteService tiqueteService;
    
    @Autowired
    public TiquetesApi(MessageSource messageSource) {
        super(messageSource);
    }
    
    @PostMapping("")
    public GenericResponse<TiqueteDTO> create(@RequestBody TiqueteDTO tiqueteDTO) {
        
        GenericResponse<TiqueteDTO> response = new GenericResponse<>();
        
        try {
            
            Optional.ofNullable(tiqueteDTO.getFechaHoraSalida()).orElseThrow(() -> new InvalidReceivedDataException("fechaHoraSalida"));
            Optional.ofNullable(tiqueteDTO.getFechaHoraLlegada()).orElseThrow(() -> new InvalidReceivedDataException("fechaHoraLlegada"));
            Optional.ofNullable(tiqueteDTO.getCiudadOrigen()).orElseThrow(() -> new InvalidReceivedDataException("ciudadOrigen"));
            Optional.ofNullable(tiqueteDTO.getCiudadDestino()).orElseThrow(() -> new InvalidReceivedDataException("ciudadDestino"));
            Optional.ofNullable(tiqueteDTO.getNombrePasajero()).orElseThrow(() -> new InvalidReceivedDataException("nombrePasajero"));
            Optional.ofNullable(tiqueteDTO.getEdadPasajero()).orElseThrow(() -> new InvalidReceivedDataException("edadPasajero"));
            Optional.ofNullable(tiqueteDTO.getTieneBodegaEquipaje()).orElseThrow(() -> new InvalidReceivedDataException("tieneBodegaEquipaje"));
            Optional.ofNullable(tiqueteDTO.getPrecio()).orElseThrow(() -> new InvalidReceivedDataException("precio"));
            
            tiqueteService.create(tiqueteDTO);
            
            response.setData(tiqueteDTO);
            setCommonMessageForCreate(response);
        
        } catch (Exception e) {
            
            this.manageCommonException(e, response);
        }
        
        return response;
    }
    
    @GetMapping("/{id}")
    public GenericResponse<TiqueteDTO> get(@PathVariable long id) {
        
        GenericResponse<TiqueteDTO> response = new GenericResponse<>();
        
        try {
            
            response.setData(tiqueteService.find(id));
            setCommonMessageForData(response);
        
        } catch (Exception e) {
            
            this.manageCommonException(e, response);
        }
        
        return response;
    }

}