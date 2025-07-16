package challenge.foro.apiforochallenge.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
       @NotNull Long id,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
