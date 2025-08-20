package forumHub.alura.forumApi.curso;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private String nome;
    private String categoria;

    public Curso(DadosCurso dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void atualizarInformacoes(DadosCurso dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
    }

	public Curso() {
	}

	public Curso(String nome, String categoria) {
		// TODO Auto-generated constructor stub
	}
    
    
}