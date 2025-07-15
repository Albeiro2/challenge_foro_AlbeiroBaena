package challenge.foro.apiforochallenge.service;

import challenge.foro.apiforochallenge.domain.topico.DatosDetalleTopico;
import challenge.foro.apiforochallenge.domain.topico.DatosListaTopico;
import challenge.foro.apiforochallenge.domain.topico.DatosTopico;
import challenge.foro.apiforochallenge.domain.topico.Topico;
import challenge.foro.apiforochallenge.repository.TopicoRepository;
import challenge.foro.apiforochallenge.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository){
        this.topicoRepository = topicoRepository;
    }

    public ResponseEntity<DatosDetalleTopico> publicarTopico(DatosTopico datos, UriComponentsBuilder uriBuilder){
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var topico = new Topico(null,datos.mensaje(),datos.nombreCurso(),datos.titulo(),usuario);

        topicoRepository.save(topico); // debes tenerlo inyectado en la clase

        var uri = uriBuilder
                .path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(new DatosDetalleTopico(topico));
    }

    public ResponseEntity<Page<DatosListaTopico>> listarTopicos(Pageable paginacion) {
        return ResponseEntity.ok(
                topicoRepository.findAll(paginacion).map(DatosListaTopico::new)
        );
    }

    public ResponseEntity<DatosListaTopico> obtenerTopico(Long id){
        Optional <Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            return ResponseEntity.ok(new DatosListaTopico(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
