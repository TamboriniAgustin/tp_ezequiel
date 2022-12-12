package api.rest.turnos.db.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import api.rest.turnos.model.swagger.Organizacion;

public class OrganizacionMapperDB implements RowMapper<Organizacion> {
	@Override
	public Organizacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Organizacion model = new Organizacion();
		
		model.setNombre(rs.getString("nombre"));
		model.setCuit(new BigDecimal(rs.getString("cuit")));
		model.setEmail(rs.getString("email"));
		model.setDireccion(rs.getString("direccion"));
		model.setTelefono(new BigDecimal(rs.getString("telefono")));
		
		return model;
	}
}