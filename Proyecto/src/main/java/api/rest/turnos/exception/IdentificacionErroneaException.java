package api.rest.turnos.exception;

public class IdentificacionErroneaException extends RuntimeException {
	private static final long serialVersionUID = 7781648684337472496L;

	public IdentificacionErroneaException(String message) {
		super(message);
	}
}