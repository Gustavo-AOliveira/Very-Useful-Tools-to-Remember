package com.desafio.bossabox.Repository;

import com.desafio.bossabox.Entities.Tool;
import com.desafio.bossabox.Entities.ToolRequestDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ToolRepositoryTest {

    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Should get tools successfully from db")
    void findTagByPathCase1() {
        List<String> tags = Arrays.asList("Node","Proxy","Nuvem");
        ToolRequestDto data = new ToolRequestDto("Teste","www.teste.com.br","Um cenário de teste", tags);
        var tool = createTool(data);
        String tagParam = "Proxy";
        var listTools = toolRepository.findTagByPath(tagParam);

        assertThat(listTools).contains(tool);
    }

    @Test
    @DisplayName("should get two or more tools when they both have the same tag")
    void findTagByPathCase2() {
        List<String> tags = Arrays.asList("Node","Proxy","Nuvem");

        ToolRequestDto data = new ToolRequestDto("Teste","www.teste.com.br","Um cenário de teste", tags);
        ToolRequestDto data2 = new ToolRequestDto("Teste2","www.teste.com.br","Um cenário de teste", tags);

        var tool = createTool(data);
        var tool2 = createTool(data);

        String tagParam = "Proxy";
        var listTools = toolRepository.findTagByPath(tagParam);

        assertThat(listTools).contains(tool);
        assertThat(listTools).contains(tool2);
    }

    @Test
    @DisplayName("Should return the list is empty")
    void findTagByPathCase3() {

        String tagParam = "Proxy";
        var listTools = toolRepository.findTagByPath(tagParam);

        assertThat(listTools).isEmpty();
    }

    private Tool createTool(ToolRequestDto data){
        Tool newTool = new Tool(data);
        entityManager.persist(newTool);
            return newTool;
    }

}








