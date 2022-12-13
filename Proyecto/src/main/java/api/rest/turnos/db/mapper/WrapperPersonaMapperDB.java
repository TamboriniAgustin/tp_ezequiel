package api.rest.turnos.db.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.wrapper.PersonaWrapper;

public class WrapperPersonaMapperDB implements RowMapper<PersonaWrapper> {
	@Override
	public PersonaWrapper mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonaWrapper model = new PersonaWrapper();
		model.setActiva(rs.getBoolean("activo"));
		
		Persona persona = new Persona();
		persona.setNombre(rs.getString("nombre"));
		persona.setApellido(rs.getString("apellido"));
		persona.setDni(new BigDecimal(rs.getString("dni")));
		model.setPersona(persona);
		
		return model;
	}
}