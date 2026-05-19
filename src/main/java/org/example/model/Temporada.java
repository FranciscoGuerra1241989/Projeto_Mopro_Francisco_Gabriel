package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Temporada implements MarcavelComoVisto {
    private int numero;
    private List<Episodio> episodios;

    public Temporada(int numero) {
        this.numero = numero;
        this.episodios = new ArrayList<Episodio>();
    }

    public int getNumero() {
        return numero;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void adicionarEpisodio(Episodio episodio) {
        if (!episodios.contains(episodio)) {
            episodios.add(episodio);
        }
    }

    @Override
    public boolean isVisto(Utilizador utilizador) {
        if (episodios.isEmpty()) {
            return false;
        }
        for (Episodio e : episodios) {
            if (!e.isVisto(utilizador)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void marcarComoVisto(Utilizador utilizador) throws Exception {
        if (utilizador == null) {
            throw new Exception("Utilizador inválido");
        }
        for (Episodio e : episodios) {
            e.marcarComoVisto(utilizador);
        }
    }

    @Override
    public String toString() {
        return "Temporada " + numero + " (" + episodios.size() + " episódios)";
    }
}