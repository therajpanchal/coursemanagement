package com.virtusa.coursemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseId;
    private String name;

    public Module() {
    }

    public Module(Long id, Long courseId, String name) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    // GETTERS
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    @Override
    public String toString() {
        return "Module [id=" + this.id + ", course id=" + this.courseId + ", name=" + name + "]";
    }

}
