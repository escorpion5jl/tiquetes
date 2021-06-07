package edu.gonet.vuelos.persistence.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import edu.gonet.vuelos.business.dto.TiqueteDTO;

@Mapper
public interface TiqueteMapper {
    
	@Insert("INSERT INTO TIQUETE (fecha_hora_salida, fecha_hora_llegada, ciudad_origen, ciudad_destino, nombre_pasajero" + 
			"                        , edad_pasajero, tiene_bodega_equipaje, precio)" + 
			"   VALUES (#{fechaHoraSalida}, #{fechaHoraLlegada}, #{ciudadOrigen}, #{ciudadDestino}, #{nombrePasajero}" + 
			"                        , #{edadPasajero}, #{tieneBodegaEquipaje}, #{precio})")
	@SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    Integer insert(TiqueteDTO tiqueteDTO);
    
    @Select("SELECT id_tiquete \"id\",  fecha_hora_salida \"fechaHoraSalida\", fecha_hora_llegada \"fechaHoraLlegada\", ciudad_origen \"ciudadOrigen\"" + 
    		"        , ciudad_destino \"ciudadDestino\", nombre_pasajero \"nombrePasajero\", edad_pasajero \"edadPasajero\", tiene_bodega_equipaje \"tieneBodegaEquipaje\"" + 
    		"        , precio \"precio\"" + 
    		"    FROM TIQUETE" + 
    		"    WHERE id_tiquete = #{id}")
    TiqueteDTO get(Long id);
}