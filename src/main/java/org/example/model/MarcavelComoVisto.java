package org.example.model;

public interface MarcavelComoVisto {
    boolean isVisto(Espectador utilizador);

    void marcarComoVisto(Espectador utilizador) throws Exception;
}