package src.exceptions;

public class EmptyListException extends Exception {
	
	public static final String MESSAGE_EMPTY = "No se encuentra ning�n cliente registrado";

	private static final long serialVersionUID = 1L;

	public EmptyListException() {
		super(MESSAGE_EMPTY);
	}
}