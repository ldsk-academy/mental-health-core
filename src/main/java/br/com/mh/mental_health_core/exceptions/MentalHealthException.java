package  br.com.mh.mental_health_core.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class MentalHealthException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    private final ApiExceptionDetailsVo apiExceptionDetailsVo;

    public MentalHealthException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.apiExceptionDetailsVo = new ApiExceptionDetailsVo(
                message,
                httpStatus.value(),
                LocalDateTime.now()
        );
    }
}
