package api.rest.turnos.validator;

import org.springframework.stereotype.Component;

import api.rest.turnos.exception.EntradaInvalidaException;
import api.rest.turnos.model.swagger.Organizacion;
import api.rest.turnos.util.ValidationUtils;

@Component
public class OrganizacionValidator {
	public void validateOrganizationData(Organizacion organization) {
		//Nombre
		if(ValidationUtils.stringEmptyOrNull(organization.getNombre())) {
			throw new EntradaInvalidaException("El nombre no puede ser vacío o nulo");
		}
		//CUIT
		if(organization.getCuit() == null) {
			throw new EntradaInvalidaException("El CUIT no puede ser nulo");
		} else if(organization.getCuit().toString().length() != 11) {
			throw new EntradaInvalidaException("El CUIT debe tener 11 caracteres numéricos");
		}
		//Email
		if(ValidationUtils.stringEmptyOrNull(organization.getEmail())) {
			throw new EntradaInvalidaException("El email no puede ser vacío o nulo");
		} else if(!ValidationUtils.stringWithEmailFormat(organization.getEmail())) {
			throw new EntradaInvalidaException("El formato del correo electrónico es incorrecto");
		}
		//Dirección
		if(ValidationUtils.stringEmptyOrNull(organization.getDireccion())) {
			throw new EntradaInvalidaException("La dirección no puede ser vacía o nula");
		}
		//Teléfono
		if(organization.getTelefono() == null) {
			throw new EntradaInvalidaException("El teléfono no puede ser nulo");
		}
		//Clave
		if(organization.getClave() == null || !ValidationUtils.stringWithPasswordFormat(organization.getClave())) {
			throw new EntradaInvalidaException("La clave debe ser alfanumerica de entre 20 y 40 caracteres");
		}
	}
}