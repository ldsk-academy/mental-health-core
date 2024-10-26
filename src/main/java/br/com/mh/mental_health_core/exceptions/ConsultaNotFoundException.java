package br.com.mh.mental_health_core.exceptions;

public class ConsultaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConsultaNotFoundException(String message) {
		super(message);
	}
}
