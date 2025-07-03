package br.com.itads.conference.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8426535622193409396L;

	public ObjectNotFoundException(String message) {
		super(message);
	}

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(Throwable cause) {
		super(cause);
	}

}
