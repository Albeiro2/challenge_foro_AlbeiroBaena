package challenge.foro.apiforochallenge.controller;

import challenge.foro.apiforochallenge.domain.usuario.DatosDetalleUsuario;
import challenge.foro.apiforochallenge.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<DatosDetalleUsuario>> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }
}
