package org.example.model;

public class Temporada implements MarcavelComoVisto {
    private int numero;

    public Temporada(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
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
        return "Temporada " + numero;
    }
}