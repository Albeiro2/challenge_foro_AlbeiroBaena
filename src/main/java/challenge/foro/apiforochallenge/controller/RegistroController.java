package challenge.foro.apiforochallenge.controller;

import challenge.foro.apiforochallenge.domain.ValidacionExcepcion;
import challenge.foro.apiforochallenge.domain.usuario.*;
import challenge.foro.apiforochallenge.service.RegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity registrarUsuario(@RequestBody @Valid DatosAutenticacion datos, UriComponentsBuilder uriComponentsBuilder ){
       return registroService.registrarUsuario(uriComponentsBuilder, datos);
    }
}
