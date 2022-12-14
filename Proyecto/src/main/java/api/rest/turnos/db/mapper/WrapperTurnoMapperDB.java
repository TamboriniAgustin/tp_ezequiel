package api.rest.turnos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import api.rest.turnos.model.swagger.Turno;
import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.wrapper.TurnoWrapper;

public class WrapperTurnoMapperDB implements RowMapper<TurnoWrapper> {
	@Override
	public TurnoWrapper mapRow(ResultSet rs, int rowNum) throws SQLException {
		TurnoWrapper model = new TurnoWrapper();
		model.setActivo(rs.getBoolean("activo"));
		
		Turno turno = new Turno();
		turno.setFecha(rs.getString("fecha"));
		
		Persona persona = new Persona();
		persona.setNombre(rs.getString("nombre_persona"));
		persona.setApellido(rs.getString("apellido_persona"));
		persona.setDni(rs.getBigDecimal("dni_persona"));
		turno.setPersona(persona);
		
		model.setTurno(turno);
		return model;
	}
}