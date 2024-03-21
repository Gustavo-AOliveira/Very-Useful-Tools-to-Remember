package com.desafio.bossabox.Service;

import com.desafio.bossabox.Dto.ToolRequestDto;
import com.desafio.bossabox.Dto.ToolResponseDto;
import com.desafio.bossabox.Entities.Tool;
import com.desafio.bossabox.Repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public ToolResponseDto saveTool(ToolRequestDto data){
        var tool = new Tool(data);
            return new ToolResponseDto(tool);
    }
    public List<ToolResponseDto> getTools(){
        var sort = Sort.by(Sort.Direction.ASC,"title");
        List<ToolResponseDto> tools = toolRepository.findAll(sort)
                .stream().map(ToolResponseDto::new)
                .toList();

        return tools;
    }
    public void deleteTool(Long id){
        toolRepository.deleteById(id);
    }
    public List<ToolResponseDto> findByTag(String tag){
        List<ToolResponseDto> toolList = toolRepository.findByTags(tag)
                .stream().map(ToolResponseDto::new)
                .toList();

        return toolList;
    }

}










