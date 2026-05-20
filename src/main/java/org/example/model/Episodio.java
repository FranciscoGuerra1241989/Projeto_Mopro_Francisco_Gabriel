package org.example.model;

public class Episodio implements MarcavelComoVisto {
    private int numero;
    private String titulo;

    public Episodio(int numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
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
        return "Episódio " + numero + ": " + titulo;
    }
}