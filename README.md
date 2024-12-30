Este é um projeto de fórum desenvolvido com Spring Boot e Spring Security. O projeto permite aos usuários realizar login, criar postagens e visualizar tópicos no fórum.

Funcionalidades
Login com autenticação JWT.
Criação de postagens (com título, mensagem e nome do curso).
Visualização de postagens e tópicos do fórum sem necessidade de autenticação.
Endpoints
Autenticação
POST /login - Realiza o login e retorna um token JWT.
Fórum
GET /forum - Lista todas as postagens (público).
POST /forum - Cria uma nova postagem (requer token).
GET /forum/{id} - Exibe detalhes de uma postagem (público).
PUT /forum/{id} - Atualiza uma postagem (requer token).
