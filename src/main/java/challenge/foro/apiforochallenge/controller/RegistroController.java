package challenge.foro.apiforochallenge.controller;

import challenge.foro.apiforochallenge.domain.ValidacionExcepcion;
import challenge.foro.apiforochallenge.domain.usuario.*;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registrarUsuario(@RequestBody @Valid DatosAutenticacion datos, UriComponentsBuilder uriComponentsBuilder){
        if (usuarioRepository.findByLogin(datos.login()) != null) {
            throw new ValidarUserExcepcion("Ya existe un usuario con el login: " + datos.login());
        }else {
            String pass = passwordEncoder.encode(datos.contrasena());
            var nuevoUsuario = new Usuario(null,datos.login(),pass);
            usuarioRepository.save(nuevoUsuario);
            var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(nuevoUsuario.getId()).toUri();
            return ResponseEntity.created(uri).body(new DatosDetalleUsuario(nuevoUsuario));
        }

    }
}
