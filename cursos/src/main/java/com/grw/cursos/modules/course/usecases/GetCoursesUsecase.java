package com.grw.cursos.modules.course.usecases;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grw.cursos.modules.course.entities.CourseEntity;
import com.grw.cursos.modules.course.repos.CourseRepository;

@Service
public class GetCoursesUsecase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(String name, String category) {
        if (category != null || name != null) {
            return this.courseRepository.findAllByNameContainingOrCategoryContaining(name, category);
        }
        return this.courseRepository.findAll();
    }

}
