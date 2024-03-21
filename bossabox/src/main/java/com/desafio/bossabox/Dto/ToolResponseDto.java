package com.desafio.bossabox.Dto;

import com.desafio.bossabox.Entities.Tool;

import java.util.List;

public record ToolResponseDto(
        Long id,
        String title,
        String link,
        String description,
        List<String> tags
) {
    public ToolResponseDto(Tool tool) {
        this(tool.getId(), tool.getTitle(), tool.getLink(), tool.getDescription(), tool.getTags());
    }
}
