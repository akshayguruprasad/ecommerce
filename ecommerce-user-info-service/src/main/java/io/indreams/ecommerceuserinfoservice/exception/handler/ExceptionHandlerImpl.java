package io.indreams.ecommerceuserinfoservice.exception.handler;

import io.indreams.ecommerceuserinfoservice.exception.UserFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerImpl {

    @ExceptionHandler(value = UserFoundException.class)
    public ResponseEntity<String> handleGenericNotFoundException(UserFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

}
