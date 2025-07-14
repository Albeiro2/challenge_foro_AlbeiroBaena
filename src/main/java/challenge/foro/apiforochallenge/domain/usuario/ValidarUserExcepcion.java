package challenge.foro.apiforochallenge.domain.usuario;

public class ValidarUserExcepcion extends RuntimeException {
    public ValidarUserExcepcion (String mensaje) {
        super(mensaje);
    }
}
