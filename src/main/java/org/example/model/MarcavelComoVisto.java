package org.example.model;

public interface MarcavelComoVisto {
    boolean isVisto(Utilizador utilizador);

    void marcarComoVisto(Utilizador utilizador) throws Exception;
}