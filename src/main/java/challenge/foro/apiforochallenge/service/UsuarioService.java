package challenge.foro.apiforochallenge.service;

import challenge.foro.apiforochallenge.domain.usuario.DatosDetalleUsuario;
import challenge.foro.apiforochallenge.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<List<DatosDetalleUsuario>> listarUsuarios(){
        var usuarios = usuarioRepository.findAll().stream()
                .map(DatosDetalleUsuario::new)
                .toList();

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarios);
    }
}
