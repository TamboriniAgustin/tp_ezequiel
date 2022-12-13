package api.rest.turnos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import api.rest.turnos.db.mapper.WrapperEventoMapperDB;
import api.rest.turnos.exception.EntradaDuplicadaException;
import api.rest.turnos.exception.ObjetoNoListadoException;
import api.rest.turnos.model.swagger.Evento;
import api.rest.turnos.util.DateUtils;
import api.rest.turnos.wrapper.EventoWrapper;

@Repository
public class EventoRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_EVENTO = "INSERT INTO evento(cuit_organizacion, nombre, ubicacion, fecha_creacion, "
			+ "fecha_realizacion, tipo) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SELECT_IDENTIFICAR_EVENTO = "SELECT cuit_organizacion, nombre, ubicacion, fecha_creacion, "
			+ " fecha_realizacion, tipo, (fecha_realizacion > NOW()) AS activo FROM evento WHERE cuit_organizacion = ? AND nombre = ?";
	private static final String UPDATE_EVENTO = "UPDATE evento SET nombre = ?, ubicacion = ?, fecha_realizacion = ?, "
			+ "tipo = ? WHERE cuit_organizacion = ? AND nombre = ?";
	private static final String DELETE_EVENTO = "DELETE FROM evento WHERE cuit_organizacion = ? AND nombre = ?";
	
	//Operaciones Insert
	public void insertEvent(String cuit, Evento event) {
		try {
			jdbcTemplate.update(INSERT_EVENTO, cuit, event.getNombre(), event.getUbicacion(), DateUtils.getCurrentDate(), 
					event.getFecha(), event.getTipo().name());
		} catch(DuplicateKeyException e) {
			throw new EntradaDuplicadaException("La organización ya tiene un evento con ese nombre");
		}
	}
	
	//Operaciones Select
	public EventoWrapper selectEvento(String eventName, String cuit) {
		try {
			return jdbcTemplate.queryForObject(SELECT_IDENTIFICAR_EVENTO, new Object[]{cuit, eventName}, new WrapperEventoMapperDB());
		} catch(EmptyResultDataAccessException e) {
			throw new ObjetoNoListadoException("Evento inexistente");
		}
	}
	
	//Operaciones Update
	public void updateEvent(String eventName, String cuit, Evento event) {
		try {
			jdbcTemplate.update(UPDATE_EVENTO, event.getNombre(), event.getUbicacion(), event.getFecha(), event.getTipo().name(), 
					cuit, eventName);
		} catch(DuplicateKeyException e) {
			throw new EntradaDuplicadaException("No pueden actualizarse los datos porque ya existe otro evento con el mismo nombre");
		}
	}
	
	//Operaciones Delete
	public void deleteOrganization(String cuit, String eventName) {
		jdbcTemplate.update(DELETE_EVENTO, cuit, eventName);
	}
}