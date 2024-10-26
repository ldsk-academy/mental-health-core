package br.com.mh.mental_health_core.exceptions;

public class DisponibilidadeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DisponibilidadeNotFoundException(String message) {
        super(message);
    }
}