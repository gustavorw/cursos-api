package com.grw.cursos.modules.course.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grw.cursos.modules.course.entities.CourseEntity;

@RestController
public class CourseController {
    
    public void createCourse(@RequestBody CourseEntity courseEntity){}
    public void getCourses(){}
    public void updatedCourse(@RequestBody CourseEntity courseEntity){}
    public void activateCourse(){}
    public void deleteCourse(){}
}
