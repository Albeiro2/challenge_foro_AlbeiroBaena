package challenge.foro.apiforochallenge.controller;

import challenge.foro.apiforochallenge.domain.topico.DatosTopico;
import challenge.foro.apiforochallenge.domain.usuario.Usuario;
import challenge.foro.apiforochallenge.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity publicarTopico(@RequestBody @Valid DatosTopico datos, UriComponentsBuilder uriBuilder){
        return topicoService.publicarTopico(datos, uriBuilder);
    }


}
