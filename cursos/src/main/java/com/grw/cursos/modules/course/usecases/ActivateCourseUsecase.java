package com.grw.cursos.modules.course.usecases;
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
        var course = this.courseRepository.findById(UUID.fromString(uuid))
                .orElseThrow(() -> new NotFoundCourseException());

        course.setActive(!course.isActive());
        return this.courseRepository.save(course);

    }
}
