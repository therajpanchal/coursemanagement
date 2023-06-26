package com.virtusa.coursemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long moduleId;
    private String title;
    private String description;
    private String videoLink;
    private boolean status = true;

    public Topic() {
    }

    public Topic(Long id, Long moduleId, String title, String description, String videoLink, boolean status) {
        this.id = id;
        this.moduleId = moduleId;
        this.title = title;
        this.description = description;
        this.videoLink = videoLink;
        this.status = status;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // GETTERS
    public Long getId() {
        return this.id;
    }

    public Long getModuleId() {
        return this.moduleId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVideoLink() {
        return this.videoLink;
    }

    public boolean getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Topic [id=" + id + ", module id=" + this.moduleId + ", title=" + title + ", description=" + description + ", videoLink=" + videoLink + ", status=" + status + "]";
    }

}
