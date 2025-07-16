package challenge.foro.apiforochallenge.controller;

import challenge.foro.apiforochallenge.domain.topico.DatosActualizacionTopico;
import challenge.foro.apiforochallenge.domain.topico.DatosDetalleTopico;
import challenge.foro.apiforochallenge.domain.topico.DatosListaTopico;
import challenge.foro.apiforochallenge.domain.topico.DatosTopico;
import challenge.foro.apiforochallenge.domain.usuario.Usuario;
import challenge.foro.apiforochallenge.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    TopicoService topicoService;

    public TopicoController(TopicoService topicoService){
        this.topicoService = topicoService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<DatosDetalleTopico> publicarTopico(@RequestBody @Valid DatosTopico datos, UriComponentsBuilder uriBuilder){
        return topicoService.publicarTopico(datos, uriBuilder);
    }

    @GetMapping
    public ResponseEntity <Page<DatosListaTopico>> listarTopicos(Pageable paginacion){
        return topicoService.listarTopicos(paginacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListaTopico> obtenerTopico(@PathVariable Long id){
        return topicoService.obtenerTopico(id);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DatosListaTopico> actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datos){
        return topicoService.actualizarTopico(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id){
        return topicoService.eliminarTopico(id);
    }

}
