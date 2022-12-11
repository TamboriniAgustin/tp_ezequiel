package api.rest.turnos.exception;

public class EntradaInvalidaException extends RuntimeException {
	private static final long serialVersionUID = -8554071184487105717L;
	
	public EntradaInvalidaException(String message) {
		super(message);
	}
}