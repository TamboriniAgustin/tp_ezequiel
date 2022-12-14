package api.rest.turnos.wrapper;

import api.rest.turnos.model.swagger.Turno;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TurnoWrapper {
	private boolean activo;
	private Turno turno;
}