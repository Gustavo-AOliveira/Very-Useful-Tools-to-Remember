package com.desafio.bossabox.Exception;

import org.springframework.http.HttpStatus;

public record ExResponseDTO(
        String message,
        HttpStatus status
) {
}
