package api.rest.turnos.validator;

import org.springframework.stereotype.Component;

import api.rest.turnos.exception.EntradaInvalidaException;
import api.rest.turnos.model.swagger.Persona;
import api.rest.turnos.model.swagger.PersonaConClave;
import api.rest.turnos.util.ValidationUtils;

@Component
public class PersonaValidator {
	//Valida la información ingresada de una persona
	public void validatePersonData(Persona person) {
		//Nombre
		if(ValidationUtils.stringEmptyOrNull(person.getNombre())) {
			throw new EntradaInvalidaException("El nombre no puede ser vacío o nulo");
		}
		//Apellido
		if(ValidationUtils.stringEmptyOrNull(person.getApellido())) {
			throw new EntradaInvalidaException("El apellido no puede ser vacío o nulo");
		}
		//DNI
		if(person.getDni() == null) {
			throw new EntradaInvalidaException("El DNI no puede ser nulo");
		} else if(person.getDni().toString().length() != 8) {
			throw new EntradaInvalidaException("El DNI debe tener 8 caracteres");
		}
	}
	
	//Valida la información ingresada de una persona con clave
	public void validatePersonData(PersonaConClave person) {
		//Nombre
		if(ValidationUtils.stringEmptyOrNull(person.getNombre())) {
			throw new EntradaInvalidaException("El nombre no puede ser vacío o nulo");
		}
		//Apellido
		if(ValidationUtils.stringEmptyOrNull(person.getApellido())) {
			throw new EntradaInvalidaException("El apellido no puede ser vacío o nulo");
		}
		//DNI
		if(person.getDni() == null) {
			throw new EntradaInvalidaException("El DNI no puede ser nulo");
		} else if(person.getDni().toString().length() != 8) {
			throw new EntradaInvalidaException("El DNI debe tener 8 caracteres");
		}
		//Clave
		if(ValidationUtils.stringEmptyOrNull(person.getClave())) {
			throw new EntradaInvalidaException("La clave no puede ser vacía o nula");
		}
	}
	
	//Valida la información ingresada de una persona con clave
	public void validatePersonData(String dni, String clave) {
		//DNI
		if(ValidationUtils.stringEmptyOrNull(dni)) {
			throw new EntradaInvalidaException("El DNI no puede ser vacío o nulo");
		}
		//Clave
		if(ValidationUtils.stringEmptyOrNull(clave)) {
			throw new EntradaInvalidaException("La clave no puede ser vacía o nula");
		}
	}
}