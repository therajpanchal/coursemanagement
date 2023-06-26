package com.virtusa.coursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.coursemanagement.models.Topic;
import com.virtusa.coursemanagement.repositories.TopicRepository;

@Service
public class TopicService {
    
    @Autowired
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.orElse(null);
    }

    public List<Topic> getTopicByModuleId(Long id) {
        //topicRepository.getByModule(id);
        List<Topic> topics = topicRepository.findByModuleId(id);
        return topics;
    }

    // public boolean markAs(Long id, boolean markAs) {
    //     Optional<Topic> optionalTopic = topicRepository.findById(id);
    //     if (optionalTopic.isPresent()) {
    //         Topic topic = optionalTopic.get();
    //         topic.setMarkAsComplete(markAs);
    //         topicRepository.save(topic);
    //         return true;
    //     }
    //     return false;
    // }

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long id, Topic topic) {
        // return topicRepository.update(id, existingTopic);
        Optional<Topic> topicToUpdate = topicRepository.findById(id);
        if(topicToUpdate.isPresent()) {
            Topic existingTopic = topicToUpdate.get();
            existingTopic.setModuleId(topic.getModuleId());
            existingTopic.setTitle(topic.getTitle());
            existingTopic.setDescription(topic.getDescription());
            existingTopic.setVideoLink(topic.getVideoLink());
            existingTopic.setStatus(topic.getStatus());
            return topicRepository.save(existingTopic);
        } 
        return null;
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

}
