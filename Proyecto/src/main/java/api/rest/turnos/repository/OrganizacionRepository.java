package api.rest.turnos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import api.rest.turnos.db.mapper.OrganizacionMapperDB;
import api.rest.turnos.exception.EntradaDuplicadaException;
import api.rest.turnos.exception.IdentificacionErroneaException;
import api.rest.turnos.exception.ObjetoNoListadoException;
import api.rest.turnos.model.swagger.Organizacion;
import api.rest.turnos.util.DateUtils;

@Repository
public class OrganizacionRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_ORGANIZACION = "INSERT INTO organizacion(nombre, cuit, direccion, telefono, email, "
			+ "fecha_alta, clave) VALUES(?, ?, ?, ?, ?, ?, PASSWORD(?))";
	private static final String SELECT_IDENTIFICAR_ORGANIZACION = "SELECT nombre, cuit, direccion, telefono, email "
			+ " FROM organizacion WHERE cuit = ? AND clave = PASSWORD(?)";
	private static final String SELECT_ORGANIZACIONES = "SELECT nombre, cuit, direccion, telefono, email "
			+ " FROM organizacion";
	private static final String SELECT_ORGANIZACION_POR_NOMBRE_O_CUIT = "SELECT nombre, cuit, direccion, telefono, email "
			+ " FROM organizacion WHERE cuit = ? OR nombre = ?";
	private static final String UPDATE_ORGANIZACION = "UPDATE organizacion SET nombre = ?, cuit = ?, direccion = ?, "
			+ "telefono = ?, email = ?, clave = PASSWORD(?) WHERE cuit = ?";
	private static final String DELETE_ORGANIZACION = "DELETE FROM organizacion WHERE cuit = ?";
	
	//Operaciones Insert
	public void insertOrganization(Organizacion organization) {
		try {
			jdbcTemplate.update(INSERT_ORGANIZACION, organization.getNombre(), organization.getCuit().toString(), 
					organization.getDireccion(), organization.getTelefono().toString(), organization.getEmail(), 
					DateUtils.getCurrentDate(), organization.getClave());
		} catch(DuplicateKeyException e) {
			throw new EntradaDuplicadaException("La organización ya se encuentra registrada o alguno de los siguientes datos "
					+ "colisiona con otra organización: Email - Direccion - Nombre");
		}
	}
	
	//Operaciones Select
	public Organizacion selectOrganizationWithCredentials(String cuit, String clave) {
		try {
			return jdbcTemplate.queryForObject(SELECT_IDENTIFICAR_ORGANIZACION, new Object[]{cuit, clave}, new OrganizacionMapperDB());
		} catch(EmptyResultDataAccessException e) {
			throw new IdentificacionErroneaException("Las credenciales de acceso a la organización son inválidas");
		}
	}
	public List<Organizacion> selectOrganizations() {
		return jdbcTemplate.query(SELECT_ORGANIZACIONES, new OrganizacionMapperDB());
	}
	public Organizacion selectOrganizationByCuitOrName(String filter) {
		try {
			return jdbcTemplate.queryForObject(SELECT_ORGANIZACION_POR_NOMBRE_O_CUIT, new Object[]{filter, filter}, new OrganizacionMapperDB());
		} catch(EmptyResultDataAccessException e) {
			throw new ObjetoNoListadoException("Organización inexistente");
		}
	}
	
	//Operaciones Update
	public void updateOrganization(String cuit, Organizacion organization) {
		try {
			jdbcTemplate.update(UPDATE_ORGANIZACION, organization.getNombre(), organization.getCuit().toString(), 
					organization.getDireccion(), organization.getTelefono().toString(), organization.getEmail(), 
					organization.getClave(), cuit);
		} catch(DuplicateKeyException e) {
			throw new EntradaDuplicadaException("No pueden actualizarse los datos porque pertenecen a otra organización registrada");
		}
	}
	
	//Operaciones Delete
	public void deleteOrganization(String cuit) {
		jdbcTemplate.update(DELETE_ORGANIZACION, cuit);
	}
}