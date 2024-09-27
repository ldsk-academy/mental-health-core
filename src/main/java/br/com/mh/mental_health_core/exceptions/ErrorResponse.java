package br.com.mh.mental_health_core.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {

	// Formata a resposta de erro para enviar informações consistentes ao cliente.
	
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorResponse(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
    
}
