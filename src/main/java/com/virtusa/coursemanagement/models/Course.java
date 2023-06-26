package com.virtusa.coursemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private Long userId;
    private String name;
    private String description;

    public Course() {
    }

    public Course(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // public Course(Long id, Long userId, String name, String description) {
    //     this.id = id;
    //     this.userId = userId;
    //     this.name = name;
    //     this.description = description;
    // }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    // public void setUserId(Long userId) {
    //     this.userId = userId;
    // }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // GETTERS
    public Long getId() {
        return this.id;
    }

    // public Long getUserId() {
    //     return this.userId;
    // }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }


    @Override
    public String toString() {
        return "Course [id=" + this.id + ", name=" + this.name + ", description=" + this.description + "]";
    }

}
