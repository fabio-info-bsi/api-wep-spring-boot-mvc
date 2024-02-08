package br.com.fabex.api.web.handler.exceptions;

import br.com.fabex.api.web.exceptions.BaseException;
import br.com.fabex.api.web.exceptions.dto.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDetails> exceptionBaseHandler(BaseException baseException) {
        return ResponseEntity.badRequest().body(baseException.getErrorDetails());
    }
}
