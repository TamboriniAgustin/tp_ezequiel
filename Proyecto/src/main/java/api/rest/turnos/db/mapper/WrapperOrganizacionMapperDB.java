package api.rest.turnos.db.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import api.rest.turnos.model.swagger.Organizacion;
import api.rest.turnos.wrapper.OrganizacionWrapper;

public class WrapperOrganizacionMapperDB implements RowMapper<OrganizacionWrapper> {
	@Override
	public OrganizacionWrapper mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrganizacionWrapper model = new OrganizacionWrapper();
		model.setFechaAlta(rs.getString("fecha_alta"));
		
		Organizacion organizacion = new Organizacion();
		organizacion.setNombre(rs.getString("nombre"));
		organizacion.setCuit(new BigDecimal(rs.getString("cuit")));
		organizacion.setEmail(rs.getString("email"));
		organizacion.setDireccion(rs.getString("direccion"));
		organizacion.setTelefono(new BigDecimal(rs.getString("telefono")));
		model.setOrganizacion(organizacion);
		
		return model;
	}
}