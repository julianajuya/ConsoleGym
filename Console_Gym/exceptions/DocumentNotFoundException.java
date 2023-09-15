package exceptions;

public class DocumentNotFoundException extends Exception {
	
	public static final String MESSAGE_NOT_FOUND = "El n�mero de documento ingresado no fue encontrado";

	private static final long serialVersionUID = 1L;

	public DocumentNotFoundException() {
		super(MESSAGE_NOT_FOUND);
	}
}