package com.hg.microservices.controllers;

import com.hg.microservices.models.Student;
import com.hg.microservices.services.PersonService;
import com.hg.microservices.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PersonService personService;

    @PostMapping("/estudiante")
    public Student createStudent(@Validated @RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @GetMapping("/estudiantes")
    public List<Student> readStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/estudiante/{id}")
    public Student updateStudent(@PathVariable String id,@Validated @RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/estudiante/{id}")
    public void deleteStudent(@PathVariable String id)
    {
        personService.deletePerson(id);
    }


}
