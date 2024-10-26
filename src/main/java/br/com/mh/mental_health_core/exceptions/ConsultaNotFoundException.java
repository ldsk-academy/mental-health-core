package br.com.mh.mental_health_core.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ConsultaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;

	private final ApiExceptionDetailsVo apiExceptionDetailsVo;

	public ConsultaNotFoundException(HttpStatus httpStatus, String message) {
		super(message);

		this.httpStatus = httpStatus;

		this.apiExceptionDetailsVo = ApiExceptionDetailsVo.builder()
					.message(message)
					.httpStatus(httpStatus.value())
					.timestamp(LocalDateTime.now())
				.build();
	}
}
