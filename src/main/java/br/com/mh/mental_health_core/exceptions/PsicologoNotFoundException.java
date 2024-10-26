package br.com.mh.mental_health_core.exceptions;

public class PsicologoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PsicologoNotFoundException(String message) {
        super(message);
    }
}