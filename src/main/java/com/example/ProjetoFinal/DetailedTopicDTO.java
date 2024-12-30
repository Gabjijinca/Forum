package com.example.ProjetoFinal;

import java.time.LocalDateTime;
import java.util.List;

public record DetailedTopicDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String nomeAutor, String status, List<String> respostas) {
}
