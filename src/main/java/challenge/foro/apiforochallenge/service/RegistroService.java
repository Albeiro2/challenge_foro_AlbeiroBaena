package challenge.foro.apiforochallenge.service;

import challenge.foro.apiforochallenge.domain.usuario.*;
import challenge.foro.apiforochallenge.infra.exceptions.ValidarUserExcepcion;
import challenge.foro.apiforochallenge.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RegistroService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistroService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity registrarUsuario(UriComponentsBuilder uriComponentsBuilder, DatosAutenticacion datos){

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
