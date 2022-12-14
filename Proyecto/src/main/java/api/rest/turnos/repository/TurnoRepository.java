package api.rest.turnos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import api.rest.turnos.db.mapper.WrapperTurnoMapperDB;
import api.rest.turnos.exception.EntradaDuplicadaException;
import api.rest.turnos.exception.ObjetoNoListadoException;
import api.rest.turnos.model.swagger.Turno;
import api.rest.turnos.wrapper.TurnoWrapper;

@Repository
public class TurnoRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_TURNO = "INSERT INTO turno(id, evento_organizacion, evento_nombre, fecha, dni_persona, "
			+ "nombre_persona, apellido_persona) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_TURNOS = "SELECT id, IFNULL(fecha, e.fecha_realizacion) AS fecha, dni_persona, "
			+ "nombre_persona, apellido_persona, (IFNULL(fecha, e.fecha_realizacion) > NOW()) AS activo FROM turno "
			+ "JOIN evento e ON e.nombre = evento_nombre AND e.cuit_organizacion = evento_organizacion "
			+ "WHERE evento_organizacion = ? AND evento_nombre = ?";
	
	//Operaciones Insert
	public void insertTurno(String id, String organizationCuit, String eventName, Turno turn) {
		try {
			jdbcTemplate.update(INSERT_TURNO, id, organizationCuit, eventName, turn.getFecha(), turn.getPersona().getDni(), 
					turn.getPersona().getNombre(), turn.getPersona().getApellido());
		} catch(DuplicateKeyException e) {
			throw new EntradaDuplicadaException("Ya hay un turno asignado en ese horario");
		}
	}
	
	//Operaciones Select
	public List<TurnoWrapper> selectEventTurns(String eventName, String cuit) {
		try {
			return jdbcTemplate.query(SELECT_TURNOS, new Object[]{cuit, eventName}, new WrapperTurnoMapperDB());
		} catch(EmptyResultDataAccessException e) {
			throw new ObjetoNoListadoException("No hay turnos registrados para el evento");
		}
	}
}