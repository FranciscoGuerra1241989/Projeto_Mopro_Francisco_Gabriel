package org.example.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Recurso implements Pesquisavel {
    private String titulo;
    private int anoLancamento;
    private List<Ator> elenco;

    public Recurso(String titulo, int anoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.elenco = new ArrayList<Ator>();
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void adicionarAtor(Ator ator) {
        if (!elenco.contains(ator)) {
            elenco.add(ator);
        }
    }

    @Override
    public boolean correspondePesquisa(String texto) {
        return titulo.toLowerCase().contains(texto.toLowerCase());
    }

    @Override
    public String toString() {
        return titulo + " (" + anoLancamento + ")";
    }
}
