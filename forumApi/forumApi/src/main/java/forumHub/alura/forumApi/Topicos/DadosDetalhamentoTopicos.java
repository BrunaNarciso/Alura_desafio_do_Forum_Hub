package forumHub.alura.forumApi.Topicos;

import java.util.Date;
import forumHub.alura.forumApi.curso.Curso;

public record DadosDetalhamentoTopicos(Long id, String titulo, String mensagem, String autor, String respostas, Date dataCriacao, Curso curso) {
    public DadosDetalhamentoTopicos(Topicos topicos) {
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), topicos.getAutor(), topicos.getRespostas(), topicos.getDataCriacao(), topicos.getCurso());
    }
}
