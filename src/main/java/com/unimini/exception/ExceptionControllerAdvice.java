package com.unimini.exception;

import lombok.extern.log4j.Log4j2;
import netscape.security.ForbiddenTargetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/*@RestControllerAdvice
@Log4j2*/
public class ExceptionControllerAdvice {

    // 400
    /*@ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<Object> BadRequestException(final RuntimeException ex) {
        log.warn("400 error", ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // 401
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity handleAccessDeniedException(final AccessDeniedException ex) {
        log.warn("401 error", ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    // 403
    @ExceptionHandler({ ForbiddenTargetException.class })
    public ResponseEntity ForbiddenTargetException(final ForbiddenTargetException ex) {
        log.warn("403 error", ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    // 500
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(final Exception ex) {
        log.info(ex.getClass().getName());
        log.error("500 error", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}
