package main.exceptions;

public class InsufficientCardException extends RuntimeException {

	private static final long serialVersionUID = 7443117472944848815L;

	public InsufficientCardException(String message){
		super(message);
	}
}
