package api.rest.turnos.exception;

public class ObjetoNoListadoException extends RuntimeException {
	private static final long serialVersionUID = 1304267792141218857L;

	public ObjetoNoListadoException(String message) {
		super(message);
	}
}