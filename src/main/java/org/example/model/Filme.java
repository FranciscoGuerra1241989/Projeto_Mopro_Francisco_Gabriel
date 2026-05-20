package org.example.model;

public class Filme extends Recurso implements MarcavelComoVisto {
    private int duracao;

    public Filme(String titulo, int ano, int duracao) {
        super(titulo, ano);
        this.duracao = duracao;
    }

    @Override
    public void marcarComoVisto(Espectador espectador) throws Exception {
        espectador.marcarComoVisto(this);
    }

    @Override
    public String toString() {
        return "[Filme] " + titulo + " (" + ano + ") - " + duracao + " min";
    }
}
