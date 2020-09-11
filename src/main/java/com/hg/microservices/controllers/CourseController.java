package com.hg.microservices.controllers;

import com.hg.microservices.models.Course;
import com.hg.microservices.models.Student;
import com.hg.microservices.services.CourseService;
import com.hg.microservices.services.PersonService;
import com.hg.microservices.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private PersonService personService;

    @PostMapping("/curso")
    public Course createCourse(@Validated @RequestBody Course course)
    {
        return courseService.saveCourse(course);
    }

    @GetMapping("/cursos")
    public List<Course> readCourses(){
        return courseService.getAllCourses();
    }

    @PutMapping("/curso/{id}")
    public Course updateCourse(@PathVariable String id, @Validated @RequestBody Course course)
    {
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/curso/{id}")
    public void deleteCourse(@PathVariable Long id)
    {
        courseService.deleteCourse(id);
    }
}
