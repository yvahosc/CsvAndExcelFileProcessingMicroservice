package org.makaia.fileProcessor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ProcessingException> handleBodyNull(ApiException e){
        System.out.println("entré");
        ProcessingException exception = new ProcessingException(400,
                e.getMessage());
        return new ResponseEntity<ProcessingException>(exception,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ProcessingException> handleBodyNull(HttpMessageNotReadableException e){
        ProcessingException exception = new ProcessingException(400,
                e.getMessage());
        return new ResponseEntity<ProcessingException>(exception,
                HttpStatus.BAD_REQUEST);
    }
}