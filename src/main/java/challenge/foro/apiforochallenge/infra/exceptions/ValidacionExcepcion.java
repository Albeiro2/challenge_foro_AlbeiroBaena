package challenge.foro.apiforochallenge.infra.exceptions;

public class ValidacionExcepcion extends RuntimeException {
    public ValidacionExcepcion(String mensaje) {
        super(mensaje);
    }
}
