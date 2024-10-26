package br.com.mh.mental_health_core.exceptions;

public class PacienteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PacienteNotFoundException(String message) {
        super(message);
    }
}