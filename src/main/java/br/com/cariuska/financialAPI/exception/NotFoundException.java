package br.com.cariuska.financialAPI.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 4824096104816120602L;

	public NotFoundException(String message) {
		super(message);
	}
}
