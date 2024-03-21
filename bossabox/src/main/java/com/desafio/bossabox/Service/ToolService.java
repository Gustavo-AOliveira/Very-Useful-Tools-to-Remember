package com.desafio.bossabox.Service;

import com.desafio.bossabox.Entities.ToolRequestDto;
import com.desafio.bossabox.Entities.ToolResponseDto;
import com.desafio.bossabox.Entities.Tool;
import com.desafio.bossabox.Exception.ToolException;
import com.desafio.bossabox.Repository.ToolRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public ToolResponseDto saveTool(Tool tool){
        toolRepository.save(tool);
            return new ToolResponseDto(tool);
    }
    public List<ToolResponseDto> getTools(){
        var sort = Sort.by(Sort.Direction.ASC,"title");

        List<ToolResponseDto> tools = toolRepository.findAll(sort)
                .stream().map(ToolResponseDto::new)
                .toList();

        if(tools.isEmpty()){
            throw new ToolException("The tools list is empty");
        }

        return tools;
    }
    public void deleteTool(Long id){
        toolRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tool not found with id" + id));

       toolRepository.deleteById(id);
    }
    public List<ToolResponseDto> findByTag(String tags){
        List<ToolResponseDto> toolList = toolRepository.findTagByPath(tags)
                .stream().map(ToolResponseDto::new).toList();

        if(toolList.isEmpty()){
            throw new ToolException("There is no tool with this tag");
        }

        return toolList;
    }

}










