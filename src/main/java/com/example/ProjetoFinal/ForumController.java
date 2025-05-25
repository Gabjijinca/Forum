package com.example.ProjetoFinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;


    @GetMapping
    public ResponseEntity<List<TopicDTO>> getAllTopics() {
        List<TopicDTO> topics = forumService.findAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTopicById(@PathVariable Long id) {
        Optional<DetailedTopicDTO> topic = forumService.findTopicById(id);
        System.out.println("Tópico encontrado: " + topic);
        if (topic.isPresent()) {
            return ResponseEntity.ok(topic.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico não encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<DetailedTopicDTO> createTopic(@RequestBody CreateTopicDTO createTopicDTO) {
        DetailedTopicDTO newTopic = forumService.createTopic(createTopicDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTopic);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Optional<DetailedTopicDTO>> updateTopic(@PathVariable Long id, @RequestBody UpdateTopicDTO updateTopicDTO) {
        Optional<DetailedTopicDTO> updatedTopic = forumService.updateTopic(id, updateTopicDTO);
        if (updatedTopic.isPresent()) {
            return ResponseEntity.ok(updatedTopic);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        boolean deleted = forumService.deleteTopic(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}