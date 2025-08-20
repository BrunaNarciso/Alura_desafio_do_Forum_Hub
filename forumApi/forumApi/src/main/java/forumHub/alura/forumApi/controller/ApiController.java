
package forumHub.alura.forumApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import forumHub.alura.forumApi.Topicos.ApiRepository;
import forumHub.alura.forumApi.Topicos.DadosAtualizacaoTopicos;
import forumHub.alura.forumApi.Topicos.DadosCadastroTopicos;
import forumHub.alura.forumApi.Topicos.DadosDetalhamentoTopicos;
import forumHub.alura.forumApi.Topicos.DadosListagemTopicos;
import forumHub.alura.forumApi.Topicos.Topicos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("topicos")
public class ApiController {
    
    @Autowired
    private ApiRepository repository;
    
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopicos> cadastrar(
            @RequestBody @Valid DadosCadastroTopicos dados, 
            UriComponentsBuilder uriBuilder) {
        
        var topico = new Topicos(dados);
        repository.save(topico);
        
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopicos(topico));
    }
    
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(
            @PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopicos> detalhar(@PathVariable Long id) {
        var topico = repository.findById(id).orElseThrow(() -> 
            new RuntimeException("Tópico não encontrado"));
        
        return ResponseEntity.ok(new DadosDetalhamentoTopicos(topico));
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopicos> atualizar(
            @RequestBody @Valid DadosAtualizacaoTopicos dados) {
        
        var topico = repository.findById(dados.id()).orElseThrow(() -> 
            new RuntimeException("Tópico não encontrado"));
        
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopicos(topico));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var topico = repository.findById(id).orElseThrow(() -> 
            new RuntimeException("Tópico não encontrado"));
        
        topico.excluir();
        return ResponseEntity.noContent().build();
    }
}
