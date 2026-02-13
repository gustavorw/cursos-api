package com.grw.cursos.modules.course.usecases;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grw.cursos.exceptions.NotFoundCourseException;
import com.grw.cursos.modules.course.repos.CourseRepository;

@Service
public class DeleteCourseUsecase {
    @Autowired
    private CourseRepository courseRepository;

    public void execute(String id) {
        if (!courseRepository.existsById(UUID.fromString(id))) {
            throw new NotFoundCourseException();
        }
        courseRepository.deleteById(UUID.fromString(id));
    }
}
