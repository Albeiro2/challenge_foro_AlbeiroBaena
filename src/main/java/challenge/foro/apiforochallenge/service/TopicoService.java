package challenge.foro.apiforochallenge.service;

import challenge.foro.apiforochallenge.domain.topico.DatosDetalleTopico;
import challenge.foro.apiforochallenge.domain.topico.DatosTopico;
import challenge.foro.apiforochallenge.domain.topico.Topico;
import challenge.foro.apiforochallenge.domain.topico.TopicoRepository;
import challenge.foro.apiforochallenge.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TopicoService {

    TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository){
        this.topicoRepository = topicoRepository;
    }

    public ResponseEntity publicarTopico(DatosTopico datos, UriComponentsBuilder uriBuilder){
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
}
