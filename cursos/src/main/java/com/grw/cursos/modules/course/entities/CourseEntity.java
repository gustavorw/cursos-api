package com.grw.cursos.modules.course.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class CourseEntity {

    private UUID id;
    private String name;
    private String category;
    private boolean active;
    private String teacher;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
