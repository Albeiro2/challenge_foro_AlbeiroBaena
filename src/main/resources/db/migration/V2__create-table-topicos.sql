CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje VARCHAR(255) NOT NULL,
    nombre_curso VARCHAR(255) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    id_usuario BIGINT NOT NULL,
    CONSTRAINT fk_topico_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);