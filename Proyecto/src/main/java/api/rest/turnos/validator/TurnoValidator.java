package api.rest.turnos.validator;

import org.springframework.stereotype.Component;

import api.rest.turnos.exception.EntradaInvalidaException;
import api.rest.turnos.model.swagger.Turno;
import api.rest.turnos.util.ValidationUtils;

@Component
public class TurnoValidator {
	//Se validan los datos del turno
	public void validateTurnData(Turno turn) {
		//Fecha
		if(turn.getFecha() != null && !ValidationUtils.stringWithDateTimeFormat(turn.getFecha())) {
			throw new EntradaInvalidaException("La fecha debe tener formato: AAAA-MM-DD HH:MM");
		}
		//Persona
		if(turn.getPersona() == null) {
			throw new EntradaInvalidaException("Los datos de la persona no pueden ser nulos");
		}
	}
}