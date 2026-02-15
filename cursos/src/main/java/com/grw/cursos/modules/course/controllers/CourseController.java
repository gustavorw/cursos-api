package com.grw.cursos.modules.course.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grw.cursos.modules.course.dtos.CourseUpdateDTO;
import com.grw.cursos.modules.course.entities.CourseEntity;
import com.grw.cursos.modules.course.usecases.ActivateCourseUsecase;
import com.grw.cursos.modules.course.usecases.CreateCourseUsecase;
import com.grw.cursos.modules.course.usecases.DeleteCourseUsecase;
import com.grw.cursos.modules.course.usecases.GetCoursesUsecase;
import com.grw.cursos.modules.course.usecases.UpdateCourseUsecase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CreateCourseUsecase createCourseUsecase;
    @Autowired
    private GetCoursesUsecase getCoursesUsecase;
    @Autowired
    private DeleteCourseUsecase deleteCourseUsecase;
    @Autowired
    private ActivateCourseUsecase activateCourseUsecase;
    @Autowired
    private UpdateCourseUsecase updateCourseUsecase;

    @PostMapping("/")
    public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var result = this.createCourseUsecase.execute(courseEntity);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getCourses(@RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {
        try {
            var result = this.getCoursesUsecase.execute(name, category);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatedCourse(@PathVariable String id, @RequestBody CourseUpdateDTO data) {
        try {
            var result = updateCourseUsecase.execute(UUID.fromString(id), data);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Object> activateCourse(@PathVariable String id) {
        try {
            var result = this.activateCourseUsecase.execute(id);
            return ResponseEntity.ok(result);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable String id) {
        try {
            this.deleteCourseUsecase.execute(id);
            return ResponseEntity.ok("Curso excluido");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
