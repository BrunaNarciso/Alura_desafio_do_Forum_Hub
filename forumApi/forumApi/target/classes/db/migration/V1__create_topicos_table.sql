CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT NOT NULL,
    autor VARCHAR(100) NOT NULL,
    respostas TEXT,
    data_criacao DATETIME NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT true,
    curso_nome VARCHAR(100) NOT NULL,
    curso_categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);