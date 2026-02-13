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

    public List<CourseEntity> execute() {
        return this.courseRepository.findAll();
    }

}
