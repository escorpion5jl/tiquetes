package edu.gonet.vuelos.business.dto;

import java.io.Serializable;
import java.util.Date;

import edu.gonet.vuelos.persistence.entities.GenericEntity;

public class TiqueteDTO implements GenericEntity, Serializable {
    
    /**
     * Generated serial version
     */
	private static final long serialVersionUID = 844182294305526916L;
    
	private Long id;
	
	private Integer edadPasajero;
	
	private Date fechaHoraSalida;
	private Date fechaHoraLlegada;
	
    private String ciudadOrigen;
    private String ciudadDestino;
    private String nombrePasajero;
    
    private Boolean tieneBodegaEquipaje;
    private Float precio;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getEdadPasajero() {
		return edadPasajero;
	}
	public void setEdadPasajero(Integer edadPasajero) {
		this.edadPasajero = edadPasajero;
	}
	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}
	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
	public Date getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}
	public void setFechaHoraLlegada(Date fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}
	public String getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public String getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public String getNombrePasajero() {
		return nombrePasajero;
	}
	public void setNombrePasajero(String nombrePasajero) {
		this.nombrePasajero = nombrePasajero;
	}
	public Boolean getTieneBodegaEquipaje() {
		return tieneBodegaEquipaje;
	}
	public void setTieneBodegaEuipaje(Boolean tieneBodegaEquipaje) {
		this.tieneBodegaEquipaje = tieneBodegaEquipaje;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
    
}