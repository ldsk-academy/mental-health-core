package br.com.mh.mental_health_core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handleRuntimeException(RuntimeException ex) {
        ApiExceptionDetailsVo apiExceptionDetails = new ApiExceptionDetailsVo(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiExceptionDetails);
    }

    @ExceptionHandler(ConsultaNotFoundException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handleConsultaNotFound(ConsultaNotFoundException ex) {

        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getApiExceptionDetailsVo());
    }

    @ExceptionHandler(DisponibilidadeNotFoundException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handleDisponibilidadeNotFound(DisponibilidadeNotFoundException ex) {
        ApiExceptionDetailsVo apiExceptionDetails = new ApiExceptionDetailsVo(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiExceptionDetails);
    }

    @ExceptionHandler(EspecialidadeNotFoundException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handleEspecialidadeNotFound(EspecialidadeNotFoundException ex) {
        ApiExceptionDetailsVo apiExceptionDetails = new ApiExceptionDetailsVo(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiExceptionDetails);
    }

    @ExceptionHandler(FichaNotFoundException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handleFichaNotFound(FichaNotFoundException ex) {
        ApiExceptionDetailsVo apiExceptionDetails = new ApiExceptionDetailsVo(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiExceptionDetails);
    }

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handlePacienteNotFound(PacienteNotFoundException ex) {
        ApiExceptionDetailsVo apiExceptionDetails = new ApiExceptionDetailsVo(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiExceptionDetails);
    }

    @ExceptionHandler(PsicologoNotFoundException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handlePsicologoNotFound(PsicologoNotFoundException ex) {
        ApiExceptionDetailsVo apiExceptionDetails = new ApiExceptionDetailsVo(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiExceptionDetails);
    }
}
