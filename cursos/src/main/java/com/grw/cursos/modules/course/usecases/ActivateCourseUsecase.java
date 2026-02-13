package com.grw.cursos.modules.course.usecases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grw.cursos.exceptions.NotFoundCourseException;
import com.grw.cursos.modules.course.entities.CourseEntity;
import com.grw.cursos.modules.course.repos.CourseRepository;

@Service
public class ActivateCourseUsecase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(String uuid) {
        Optional<CourseEntity> optionalCourse = this.courseRepository.findById(UUID.fromString(uuid));
        if (!optionalCourse.isPresent()) {
            throw new NotFoundCourseException();
        }

        CourseEntity course = optionalCourse.get();
        course.setActive(!course.isActive());
        this.courseRepository.save(course);
        return course;
    }
}
