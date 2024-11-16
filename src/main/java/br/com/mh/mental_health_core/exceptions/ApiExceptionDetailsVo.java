package  br.com.mh.mental_health_core.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiExceptionDetailsVo {
    private String message;
    private int httpStatus;
    private LocalDateTime timestamp;
    
    public ApiExceptionDetailsVo() {
    }

    public ApiExceptionDetailsVo(String message, int httpStatus, LocalDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
