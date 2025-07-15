package challenge.foro.apiforochallenge.infra.exceptions;

public class ValidarUserExcepcion extends RuntimeException {
    public ValidarUserExcepcion (String mensaje) {
        super(mensaje);
    }
}
