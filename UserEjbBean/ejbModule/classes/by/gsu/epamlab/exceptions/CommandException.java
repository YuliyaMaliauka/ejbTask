package classes.by.gsu.epamlab.exceptions;

public class CommandException extends Exception {

	private static final long serialVersionUID = 5878343481546003965L;
	
	public CommandException() {
		super();
	}

	public CommandException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandException(String message) {
		super(message);
	}

	public CommandException(Throwable cause) {
		super(cause);
	}

}
