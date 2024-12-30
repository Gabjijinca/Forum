CREATE TABLE forum_respostas (
    forum_id BIGINT NOT NULL,
    respostas VARCHAR(255),
    PRIMARY KEY (forum_id, respostas),
    FOREIGN KEY (forum_id) REFERENCES Forum(id)
);