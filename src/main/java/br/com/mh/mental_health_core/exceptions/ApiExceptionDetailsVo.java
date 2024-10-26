package br.com.mh.mental_health_core.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiExceptionDetailsVo {
	private String message;
    private int httpStatus;
    private LocalDateTime timestamp;

    public ApiExceptionDetailsVo(String message, int httpStatus, LocalDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
