package com.example.ProjetoFinal;

import java.time.LocalDateTime;

public record TopicDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {
}

