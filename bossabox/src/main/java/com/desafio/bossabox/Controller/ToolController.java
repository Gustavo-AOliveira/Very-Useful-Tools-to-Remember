package com.desafio.bossabox.Controller;

import com.desafio.bossabox.Entities.Tool;
import com.desafio.bossabox.Entities.ToolRequestDto;
import com.desafio.bossabox.Entities.ToolResponseDto;
import com.desafio.bossabox.Service.ToolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolController {
    @Autowired
    private ToolService toolService;
    @PostMapping
    public ResponseEntity saveTool(@RequestBody @Valid ToolRequestDto data){
        var tool = new Tool(data);
        toolService.saveTool(tool);
            return ResponseEntity.status(HttpStatus.CREATED).body(tool);
    }

    @GetMapping
    public ResponseEntity getTools(){
        List<ToolResponseDto> toolsList = toolService.getTools();
            return ResponseEntity.ok().body(toolsList);
    }
    @GetMapping("/findByTag")
    public ResponseEntity getToolsByTag(@RequestParam String tags){
        List<ToolResponseDto> tagList = toolService.findByTag(tags);
            return ResponseEntity.ok().body(tagList);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteTool(@PathVariable long id){
        toolService.deleteTool(id);
            return ResponseEntity.noContent().build();
    }

}











