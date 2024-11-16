package  br.com.mh.mental_health_core.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

<<<<<<< HEAD
=======
import lombok.Builder;
import lombok.Data;

>>>>>>> 47415dbf403402a9057af11e3d82abcd964d2eaa
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
