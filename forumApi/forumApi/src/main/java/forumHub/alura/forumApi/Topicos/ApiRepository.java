package forumHub.alura.forumApi.Topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Topicos, Long>{
    
    Page<Topicos> findAllByAtivoTrue(Pageable paginacao);

}