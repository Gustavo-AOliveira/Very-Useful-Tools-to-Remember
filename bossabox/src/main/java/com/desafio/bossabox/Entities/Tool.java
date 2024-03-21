package com.desafio.bossabox.Entities;

import com.desafio.bossabox.Dto.ToolRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Tool")
@Table(name = "tools")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link;

    private String description;

    private List<String> tags;

    public Tool(ToolRequestDto data) {
        this.title = data.title();
        this.link = data.link();
        this.description = data.description();
        this.tags = data.tags();
    }
}










