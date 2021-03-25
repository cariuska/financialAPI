package br.com.cariuska.financialAPI.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 6265140259363437180L;

	public BusinessException(String message) {
		super(message);
	}
}
