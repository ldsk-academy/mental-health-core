package br.com.mh.mental_health_core.exceptions;

public class EspecialidadeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EspecialidadeNotFoundException(String message) {
        super(message);
    }
}