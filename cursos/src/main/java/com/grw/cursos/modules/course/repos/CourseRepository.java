package com.grw.cursos.modules.course.repos;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grw.cursos.modules.course.entities.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    List<CourseEntity> findAllByNameContainingOrCategoryContaining(String name, String category);
}
