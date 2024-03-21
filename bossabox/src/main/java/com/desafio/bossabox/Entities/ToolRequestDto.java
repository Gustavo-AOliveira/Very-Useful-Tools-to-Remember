package com.desafio.bossabox.Entities;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ToolRequestDto(
        @NotBlank(message = "Title cannot be blank")
        String title,
        @NotBlank(message = "Link cannot be blank")
        String link,
        String description,
        @NotBlank(message = "Tags are required")
        List<String> tags
) {
}
