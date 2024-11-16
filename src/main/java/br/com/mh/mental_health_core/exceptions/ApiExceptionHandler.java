package br.com.mh.mental_health_core.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MentalHealthException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handleMentalHealthException(MentalHealthException ex) {
        // Retorna a resposta com os detalhes da exceção personalizada
        return new ResponseEntity<>(ex.getApiExceptionDetailsVo(), ex.getHttpStatus());
    }

<<<<<<< HEAD
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionDetailsVo> handleGenericException(Exception ex) {
        // Cria detalhes do erro para uma exceção genérica
        ApiExceptionDetailsVo details = ApiExceptionDetailsVo.builder()
                .message("An unexpected error occurred: " + ex.getMessage())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())  // Usa o valor do HttpStatus
                .timestamp(java.time.LocalDateTime.now())
                .build();
=======
    @ExceptionHandler(ConsultaNotFoundException.class)
    public ResponseEntity<ApiExceptionDetailsVo> handleConsultaNotFound(ConsultaNotFoundException ex) {

        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getApiExceptionDetailsVo());
    }
>>>>>>> 47415dbf403402a9057af11e3d82abcd964d2eaa

        // Retorna a resposta com o erro genérico
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
