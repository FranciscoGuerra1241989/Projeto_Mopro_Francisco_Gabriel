package org.example.model;

public class Comentario {
    private Espectador espectador;
    private Recurso recurso;
    private String texto;

    public Comentario(Espectador espectador, Recurso recurso, String texto) throws Exception {
        if (espectador == null) {
            throw new Exception("Espectador inválido");
        }
        if (recurso == null) {
            throw new Exception("Recurso inválido");
        }
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("O texto do comentário não pode estar vazio");
        }
        this.espectador = espectador;
        this.recurso = recurso;
        this.texto = texto;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return espectador.getNome() + " comentou em " + recurso.getTitulo() + ": \"" + texto + "\"";
    }
}