package api.rest.turnos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import api.rest.turnos.db.mapper.WrapperPersonaMapperDB;
import api.rest.turnos.exception.EntradaDuplicadaException;
import api.rest.turnos.exception.IdentificacionErroneaException;
import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.model.swagger.PersonaConClave;
import api.rest.turnos.util.ValidationUtils;
import api.rest.turnos.wrapper.PersonaWrapper;

@Repository
public class PersonaRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_PERSONA = "INSERT INTO usuario(nombre, apellido, dni, clave) VALUES(?, ?, ?, PASSWORD(?))";
	private static final String SELECT_PERSONA = "SELECT nombre, apellido, dni, activo FROM usuario WHERE dni = ?";
	private static final String SELECT_PERSONA_IDENTIFICACION = "SELECT nombre, apellido, dni, activo FROM usuario WHERE dni = ? AND clave = PASSWORD(?)";
	private static final String SELECT_PERSONAS = "SELECT nombre, apellido, dni, activo FROM usuario WHERE activo = 1";
	private static final String SELECT_PERSONAS_POR_APELLIDO = "SELECT nombre, apellido, dni, activo FROM usuario WHERE activo = 1 AND apellido LIKE ?";
	private static final String SELECT_PERSONAS_POR_DNI = "SELECT nombre, apellido, dni, activo FROM usuario WHERE activo = 1 AND dni = ?";
	private static final String UPDATE_PERSONA = "UPDATE usuario SET nombre = ?, apellido = ?, dni = ?, clave = PASSWORD(?), activo = ? "
			+ "WHERE dni = ?";
	private static final String UPDATE_STATUS_PERSONA = "UPDATE usuario SET activo = ? WHERE dni = ?";
	
	//Operaciones Insert
	public void insertPerson(String clave, Persona person) {
		try {
			jdbcTemplate.update(INSERT_PERSONA, person.getNombre(), person.getApellido(), person.getDni().toString(), clave);
		} catch(DuplicateKeyException e) {
			PersonaWrapper personWrapper = selectPerson(person.getDni().toString());
			if(personWrapper.isActiva()) {
				throw new EntradaDuplicadaException("La persona ya está registrada");
			} else {
				//Si la cuenta está desactivada, se reactiva con los nuevos datos ingresados
				PersonaConClave personWithPassword = new PersonaConClave();
				personWithPassword.setNombre(person.getNombre());
				personWithPassword.setApellido(person.getApellido());
				personWithPassword.setDni(person.getDni());
				personWithPassword.setClave(clave);
				
				updatePerson(person.getDni().toString(), personWithPassword);
			}
			
		}
	}
	
	//Operaciones Select
	public PersonaWrapper selectPerson(String dni) {
		try {
			return jdbcTemplate.queryForObject(SELECT_PERSONA, new Object[]{dni}, new WrapperPersonaMapperDB());
		} catch(EmptyResultDataAccessException e) {
			throw new IdentificacionErroneaException("La persona no se encuentra registrada");
		}
	}
	public PersonaWrapper selectPersonWithPassword(String dni, String clave) {
		try {
			return jdbcTemplate.queryForObject(SELECT_PERSONA_IDENTIFICACION, new Object[]{dni, clave}, new WrapperPersonaMapperDB());
		} catch(EmptyResultDataAccessException e) {
			throw new IdentificacionErroneaException("Las credenciales de identificación son erróneas");
		}
	}
	public List<PersonaWrapper> selectPersons(String apellido) {
		try {
			if(ValidationUtils.stringEmptyOrNull(apellido)) {
				return jdbcTemplate.query(SELECT_PERSONAS, new WrapperPersonaMapperDB());
			} else {
				return jdbcTemplate.query(SELECT_PERSONAS_POR_APELLIDO, new Object[]{"%" + apellido + "%"}, new WrapperPersonaMapperDB());
			}
		} catch(EmptyResultDataAccessException e) {
			throw new IdentificacionErroneaException("No hay usuarios activos registrados");
		}
	}
	public PersonaWrapper selectPersonByDNI(String dni) {
		try {
			return jdbcTemplate.queryForObject(SELECT_PERSONAS_POR_DNI, new Object[]{dni}, new WrapperPersonaMapperDB());
		} catch(EmptyResultDataAccessException e) {
			throw new IdentificacionErroneaException("No existe un usuario con el DNI ingresado");
		}
	}
	
	//Operaciones Update
	public void updatePerson(String dni, PersonaConClave person) {
		try {
			jdbcTemplate.update(UPDATE_PERSONA, person.getNombre(), person.getApellido(), person.getDni().toString(), person.getClave(), "1", dni);
		} catch(DuplicateKeyException e) {
			throw new EntradaDuplicadaException("No puede actualizarse la información de la persona porque los nuevos datos pertenecen a otra persona");
		}
	}
	public void updatePersonStatus(String dni, String status) {
		jdbcTemplate.update(UPDATE_STATUS_PERSONA, status, dni);
	}
}