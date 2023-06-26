package com.virtusa.coursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.coursemanagement.models.Course;
import com.virtusa.coursemanagement.repositories.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        Optional<Course> courseToUpdate = courseRepository.findById(id);
        if(courseToUpdate.isPresent()) {
            Course existingCourse = courseToUpdate.get();
            // existingCourse.setUserId(course.getUserId());
            existingCourse.setName(course.getName());
            existingCourse.setDescription(course.getDescription());
            return courseRepository.save(existingCourse);
        } 
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

}
