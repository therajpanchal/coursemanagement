package com.virtusa.coursemanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.coursemanagement.models.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{
    
    List<Topic> findByModuleId(Long id);

    // List<Topic> getAll();
    // Topic getById(Long id);
    // Topic getByModule(Long moduleId);
    // Topic save(Topic topic);
    // Topic update(Long id, Topic topic);
    // boolean delete(Long id);

}
