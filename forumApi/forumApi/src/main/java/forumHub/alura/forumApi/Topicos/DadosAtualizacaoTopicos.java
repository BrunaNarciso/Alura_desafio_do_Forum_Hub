package forumHub.alura.forumApi.Topicos;

import forumHub.alura.forumApi.curso.DadosCurso;
import jakarta.validation.Valid;

public record DadosAtualizacaoTopicos(
    Long id,
    String titulo,
    String mensagem,
    String autor,
    String respostas,
    @Valid DadosCurso curso
) {}