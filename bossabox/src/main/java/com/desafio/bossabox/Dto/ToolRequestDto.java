package com.desafio.bossabox.Dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ToolRequestDto(
        @NotNull
        String title,
        @NotNull
        String link,
        String description,
        @NotNull
        List<String> tags
) {
}
