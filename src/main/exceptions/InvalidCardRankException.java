package main.exceptions;

public class InvalidCardRankException extends IllegalArgumentException {

	private static final long serialVersionUID = -4253596447385202783L;

	public InvalidCardRankException(String errorMessage, Throwable error){
		super(errorMessage, error);
	}
	
	public InvalidCardRankException(String errorMessage){
		super(errorMessage);
	}
}
