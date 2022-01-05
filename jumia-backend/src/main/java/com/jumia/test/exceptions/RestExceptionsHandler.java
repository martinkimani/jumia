package com.jumia.test.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author martin
 */
@ControllerAdvice
public class RestExceptionsHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity handle(Exception ex, 
                HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity("Error occured processing your request. Try again",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
