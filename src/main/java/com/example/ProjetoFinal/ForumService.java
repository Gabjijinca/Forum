package com.example.ProjetoFinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumService {

    @Autowired
    private ForumRepository forumRepository;


    public List<TopicDTO> findAllTopics() {
        return forumRepository.findAll().stream()
                .map(topic -> new TopicDTO(topic.getId(), topic.getTitulo(), topic.getMensagem(), topic.getDataCriacao()))
                .toList();
    }


    public Optional<DetailedTopicDTO> findTopicById(Long id) {
        return forumRepository.findById(id).map(topic ->
                new DetailedTopicDTO(
                        topic.getId(),
                        topic.getTitulo(),
                        topic.getMensagem(),
                        topic.getDataCriacao(),
                        topic.getNomeAutor(),
                        topic.getStatus(),
                        topic.getRespostas()
                )
        );
    }

    public DetailedTopicDTO createTopic(CreateTopicDTO createTopicDTO) {
        Forum forum = new Forum(
                createTopicDTO.titulo(),
                createTopicDTO.mensagem(),
                "ALUNO",
                "NAO_RESPONDIDO"
        );
        forum = forumRepository.save(forum);
        return new DetailedTopicDTO(
                forum.getId(),
                forum.getTitulo(),
                forum.getMensagem(),
                forum.getDataCriacao(),
                forum.getNomeAutor(),
                forum.getStatus(),
                forum.getRespostas()
        );
    }

    public Optional<DetailedTopicDTO> updateTopic(Long id, UpdateTopicDTO updateTopicDTO) {
        return forumRepository.findById(id).map(existingTopic -> {
            existingTopic.setTitulo(updateTopicDTO.titulo());
            existingTopic.setMensagem(updateTopicDTO.mensagem());
            forumRepository.save(existingTopic);
            return new DetailedTopicDTO(
                    existingTopic.getId(),
                    existingTopic.getTitulo(),
                    existingTopic.getMensagem(),
                    existingTopic.getDataCriacao(),
                    existingTopic.getNomeAutor(),
                    existingTopic.getStatus(),
                    existingTopic.getRespostas()
            );
        });
    }

    public boolean deleteTopic(Long id) {
        if (forumRepository.existsById(id)) {
            forumRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

