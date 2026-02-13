package com.grw.cursos.modules.course.usecases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grw.cursos.modules.course.entities.CourseEntity;
import com.grw.cursos.modules.course.repos.CourseRepository;

@Service
public class CreateCourseUsecase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity){

        return this.courseRepository.save(courseEntity);

    }
}
