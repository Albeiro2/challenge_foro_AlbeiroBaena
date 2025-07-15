package challenge.foro.apiforochallenge.domain.topico;

public record DatosListaTopico(

        Long id,
        String mensaje,
        String nombreCurso,
        String titulo,
        String usuario
) {
    public DatosListaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getMensaje(),
                topico.getNombreCurso(),
                topico.getTitulo(),
                topico.getUsuario().getLogin()
        );
    }
}