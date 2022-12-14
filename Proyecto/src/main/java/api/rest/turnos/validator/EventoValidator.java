package api.rest.turnos.validator;

import org.springframework.stereotype.Component;

import api.rest.turnos.exception.EntradaInvalidaException;
import api.rest.turnos.model.swagger.Evento;
import api.rest.turnos.util.ValidationUtils;

@Component
public class EventoValidator {
	//Valida la información para la creación/modificación de un evento
	public void validateEventData(Evento event) {
		//Nombre
		if(ValidationUtils.stringEmptyOrNull(event.getNombre())) {
			throw new EntradaInvalidaException("El nombre no puede ser vacío o nulo");
		}
		//Ubicación
		if(ValidationUtils.stringEmptyOrNull(event.getUbicacion())) {
			throw new EntradaInvalidaException("La ubicación no puede ser vacía o nula");
		}
		//Tipo
		if(event.getTipo() == null) {
			throw new EntradaInvalidaException("El tipo debe ser UNICO o RECURRENTE");
		}
		//Fecha
		if(ValidationUtils.stringEmptyOrNull(event.getFecha())) {
			throw new EntradaInvalidaException("La fecha no puede ser vacía o nula");
		} else if(!ValidationUtils.stringWithDateTimeFormat(event.getFecha())) {
			throw new EntradaInvalidaException("El formato de la fecha debe ser: AAAA-MM-DD HH:MM");
		}
	}
	
	//Valida que se haya ingresado un nombre de evento
	public void validateEventName(String eventName) {
		//Nombre
		if(ValidationUtils.stringEmptyOrNull(eventName)) {
			throw new EntradaInvalidaException("El nombre no puede ser vacío o nulo");
		}
	}
	
	//Valida que se haya ingresado un nombre de evento y un cuit para identificarlo
	public void validateEventData(String organizationCuit, String eventName) {
		//CUIT
		if(ValidationUtils.stringEmptyOrNull(organizationCuit)) {
			throw new EntradaInvalidaException("El CUIT no puede ser vacío o nulo");
		}
		//Nombre
		if(ValidationUtils.stringEmptyOrNull(eventName)) {
			throw new EntradaInvalidaException("El nombre no puede ser vacío o nulo");
		}
	}
}