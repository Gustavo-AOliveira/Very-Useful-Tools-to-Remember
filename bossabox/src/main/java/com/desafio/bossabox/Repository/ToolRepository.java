package com.desafio.bossabox.Repository;

import com.desafio.bossabox.Entities.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool,Long> {
    List<Tool> findByTags(String tag);
}
