package com.desafio.bossabox.Exception;

import org.springframework.validation.FieldError;

public record ValidationErrorDto(
        String field,
        String message

) {
    public ValidationErrorDto(FieldError fieldError) {
      this(fieldError.getField(),fieldError.getDefaultMessage());
    }
}
