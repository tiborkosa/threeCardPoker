package main.exceptions;

public class TooManyCardsException extends RuntimeException {

	private static final long serialVersionUID = 7977301943801426321L;

	public TooManyCardsException(String message) {
		super(message);
	}
}
