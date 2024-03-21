package com.desafio.bossabox.Entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;


public record ToolRequestDto(
        @NotBlank(message = "Title cannot be blank")
        String title,
        @NotBlank(message = "Link cannot be blank")
        String link,
        String description,
        @NotEmpty(message = "A lista de tags não pode estar vazia")
        List<String> tags


) {
}
