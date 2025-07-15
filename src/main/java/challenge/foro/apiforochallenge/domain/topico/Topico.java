package challenge.foro.apiforochallenge.domain.topico;

import challenge.foro.apiforochallenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String mensaje;
    String nombreCurso;
    String titulo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
