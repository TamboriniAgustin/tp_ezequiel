package api.rest.turnos.exception;

public class EntradaDuplicadaException extends RuntimeException {
	private static final long serialVersionUID = 7167624120270927478L;

	public EntradaDuplicadaException(String message) {
		super(message);
	}
}