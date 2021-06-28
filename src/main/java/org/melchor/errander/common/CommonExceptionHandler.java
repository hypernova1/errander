package org.melchor.errander.common;

import lombok.extern.slf4j.Slf4j;
import org.melchor.errander.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> appException(AppException exception) {
        log.error(exception.getMessage());

        return ResponseEntity.badRequest().build();
    }

}
