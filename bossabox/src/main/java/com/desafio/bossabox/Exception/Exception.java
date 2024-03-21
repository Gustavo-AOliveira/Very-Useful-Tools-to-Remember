package com.desafio.bossabox.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex) {
        var errorResponse = new ExResponseDTO(ex.getMessage(), HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body(errorResponse);
    }


}
