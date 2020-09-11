package com.hg.microservices.services;

import com.hg.microservices.models.Course;
import com.hg.microservices.models.Student;
import com.hg.microservices.repositories.ICourseRepository;
import com.hg.microservices.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private ICourseRepository iCourseRepository;

    public Course saveCourse(Course course){
        return iCourseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return iCourseRepository.findAll();
    }

    public void deleteCourse(Long id)
    {
        iCourseRepository.deleteById(id);
    }
}
