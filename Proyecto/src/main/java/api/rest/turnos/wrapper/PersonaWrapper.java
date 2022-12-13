package api.rest.turnos.wrapper;

import api.rest.turnos.model.swagger.Persona;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaWrapper {
	private boolean activa;
	private Persona persona;
}