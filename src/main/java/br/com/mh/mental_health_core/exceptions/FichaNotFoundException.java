package br.com.mh.mental_health_core.exceptions;

public class FichaNotFoundException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	public FichaNotFoundException(String message) {
        super(message);
    }
}