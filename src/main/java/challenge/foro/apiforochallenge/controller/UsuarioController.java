package challenge.foro.apiforochallenge.controller;

import challenge.foro.apiforochallenge.domain.usuario.DatosDetalleUsuario;
import challenge.foro.apiforochallenge.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<DatosDetalleUsuario>> listarUsuarios(){
        var usuarios = usuarioRepository.findAll().stream()
                .map(DatosDetalleUsuario::new).toList();
        return ResponseEntity.ok(usuarios);
    }
}
