package challenge.foro.apiforochallenge.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosDetalleTopico(
         Long id,
         String mensaje,
         String nombreCurso,
         String titulo,
         Long id_usuario
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo(),topico.getUsuario().getId());
    }
}
