API Fórum
Este projeto é uma API RESTful desenvolvida em Java utilizando o framework Spring Boot. Ela fornece funcionalidades para gerenciar postagens em um fórum, com a implementação de operações CRUD (Criar, Ler, Atualizar, Deletar) completas. A API também conta com autenticação e autorização de usuários, implementadas usando JWT e Spring Security.

Tecnologias utilizadas
Java 17
Spring Boot
Spring Security
JWT (JSON Web Token)
MySQL
JPA (Hibernate)
Maven
Funcionalidades
Autenticação e Autorização: Autenticação de usuários com e geração de JWT para controlar o acesso a rotas.
CRUD de Postagens: A API permite criar, ler, atualizar e excluir postagens de fórum.
Proteção de Rotas: Somente usuários autenticados podem acessar a maioria dos endpoints, com exceção do login.
Permissões: Configuração de permissões de acesso específicas para diferentes rotas.
Endpoints
POST /login: Autenticação de usuários. Retorna um token JWT.
GET /forum: Retorna todas as postagens do fórum.
POST /forum: Criação de uma nova postagem (requer autenticação).
GET /forum/{id}: Retorna os detalhes de uma postagem específica.
PUT /forum/{id}: Atualiza uma postagem existente (requer autenticação).
DELETE /forum/{id}: Deleta uma postagem (requer autenticação).
