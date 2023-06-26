package com.virtusa.coursemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.coursemanagement.models.Topic;
import com.virtusa.coursemanagement.services.TopicService;


@RestController
@RequestMapping("/api/topics")
public class TopicController {
    
    @Autowired
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Topic topic = topicService.getTopicById(id);
        if(topic!=null) {
            return new ResponseEntity<Topic>(topic, HttpStatus.OK);
        }
        return new ResponseEntity<Topic>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/module/{moduleid}")
    public ResponseEntity<List<Topic>> getTopicByModuleid(@PathVariable Long moduleid) {
        List<Topic> topics = topicService.getTopicByModuleId(moduleid);
        if(!topics.isEmpty()) {
            return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
        }
        return new ResponseEntity<List<Topic>>(HttpStatus.NOT_FOUND);
    }

    // @PutMapping("/{id}/status")
    // public ResponseEntity<String> updateTopicStatus(@PathVariable Long id, @RequestParam Boolean status) {
    //     if (topicService.markAs(id, status)) {
    //         return ResponseEntity.ok("Topic status updated successfully.");
    //     }
    //     return ResponseEntity.badRequest().body("Failed to update topic status.");
    // }

    @PostMapping
    public Topic create(@RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }

    @PutMapping("/{id}")
    public Topic update(@PathVariable Long id, @RequestBody Topic topic) {
        return topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

}
