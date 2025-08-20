package forumHub.alura.forumApi.Topicos;

import forumHub.alura.forumApi.curso.DadosCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopicos(
    @NotBlank String titulo,
    @NotBlank String mensagem,
    @NotBlank String autor,
    String respostas,
    @NotNull @Valid DadosCurso curso
) {}