package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Filme extends Recurso implements MarcavelComoVisto {
    private int duracao;
    private List<Utilizador> vistos;

    public Filme(String titulo, int anoLancamento, int duracao) {
        super(titulo, anoLancamento);
        this.duracao = duracao;
        this.vistos = new ArrayList<Utilizador>();
    }

    @Override
    public boolean isVisto(Utilizador utilizador) {
        return vistos.contains(utilizador);
    }

    @Override
    public void marcarComoVisto(Utilizador utilizador) throws Exception {
        if (utilizador == null) {
            throw new Exception("Utilizador inválido");
        }
        if (!vistos.contains(utilizador)) {
            vistos.add(utilizador);
        }
    }

    @Override
    public String toString() {
        return "[Filme] " + super.toString() + " - Duração: " + duracao + " min";
    }
}