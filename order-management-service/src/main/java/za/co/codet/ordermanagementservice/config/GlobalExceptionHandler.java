package za.co.codet.ordermanagementservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import za.co.codet.ordermanagementservice.dto.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleConflict(RuntimeException ex) {
        return new ResponseEntity<>(errorMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private ErrorMessage errorMessage(String msg) {
        return ErrorMessage.builder().message(msg).build();
    }

}