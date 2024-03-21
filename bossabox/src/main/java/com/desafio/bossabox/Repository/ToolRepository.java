package com.desafio.bossabox.Repository;

import com.desafio.bossabox.Entities.Tool;
import com.desafio.bossabox.Entities.ToolResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool,Long> {

    @Query(value = "SELECT * FROM tools WHERE tags LIKE %:tags%", nativeQuery = true)
    List<Tool> findTagByPath(@Param("tags")String tags);
}
