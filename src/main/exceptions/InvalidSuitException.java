package main.exceptions;

public class InvalidSuitException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidSuitException(String errorMessage) {
		super(errorMessage);
	}
}
