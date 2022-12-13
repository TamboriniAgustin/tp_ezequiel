package api.rest.turnos.wrapper;

import api.rest.turnos.model.swagger.Evento;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventoWrapper {
	private String fecha_creacion;
	private boolean activo;
	private Evento evento;
}