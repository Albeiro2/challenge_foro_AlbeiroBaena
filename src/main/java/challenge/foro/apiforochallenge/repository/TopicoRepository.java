package challenge.foro.apiforochallenge.repository;

import challenge.foro.apiforochallenge.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
}
