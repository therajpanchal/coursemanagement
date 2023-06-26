package com.virtusa.coursemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.coursemanagement.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
