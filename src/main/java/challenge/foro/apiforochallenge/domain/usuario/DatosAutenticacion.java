package challenge.foro.apiforochallenge.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacion(
       @NotBlank String login,
       @NotBlank String contrasena
) {
}
