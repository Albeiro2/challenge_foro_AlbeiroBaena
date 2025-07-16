package challenge.foro.apiforochallenge.repository;

import challenge.foro.apiforochallenge.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    Optional<Topico> findByIdAndUsuarioId(Long idTopico, Long idUsuario);
}
