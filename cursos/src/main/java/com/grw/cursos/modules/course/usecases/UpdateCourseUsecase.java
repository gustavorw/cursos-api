package com.grw.cursos.modules.course.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grw.cursos.exceptions.NotFoundCourseException;
import com.grw.cursos.modules.course.dtos.CourseUpdateDTO;
import com.grw.cursos.modules.course.entities.CourseEntity;
import com.grw.cursos.modules.course.repos.CourseRepository;

@Service
public class UpdateCourseUsecase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id, CourseUpdateDTO data) {
        var course = this.courseRepository.findById(id).orElseThrow(() -> new NotFoundCourseException());
        if (data.name() != null)
            course.setName(data.name());
        if (data.category() != null)
            course.setCategory(data.category());
        if (data.teacher() != null)
            course.setTeacher(data.teacher());
        return this.courseRepository.save(course);

    }
}
