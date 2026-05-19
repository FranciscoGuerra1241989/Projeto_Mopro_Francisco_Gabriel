package org.example.model;

public interface MarcavelComoVisto {
    boolean isVisto(Expectador utilizador);

    void marcarComoVisto(Expectador utilizador) throws Exception;
}