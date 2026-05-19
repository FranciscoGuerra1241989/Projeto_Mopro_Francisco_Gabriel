package org.example.model;

public class Episodio implements MarcavelComoVisto {
    private String titulo;
    private int duracao;

    public Episodio(String titulo, int duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public boolean isVisto(Espectador espectador) {
        if (espectador == null) {
            return false;
        }
        return espectador.jaViu(this);
    }

    @Override
    public void marcarComoVisto(Espectador espectador) throws Exception {
        if (espectador == null) {
            throw new Exception("Espectador inválido");
        }
        espectador.marcarComoVisto(this);
    }

    @Override
    public String toString() {
        return titulo + " (" + duracao + " min)";
    }
}
