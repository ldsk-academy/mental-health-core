package br.com.mh.mental_health_core.exceptions;

public class ResourceNotFoundException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	// Permite lançar e identificar exceções específicas quando um recurso não é encontrado.
	
	public ResourceNotFoundException(String message) {
        super(message);
    }
}
