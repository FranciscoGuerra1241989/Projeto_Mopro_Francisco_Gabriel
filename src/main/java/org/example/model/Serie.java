package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Recurso implements MarcavelComoVisto {
    private List<Temporada> listaTemporadas;
    private List<Episodio> listaEpisodios;
    private int qtdTemporadas;
    private int qtdEpisodios;

    public Serie(String titulo, int ano, int qtdTemporadas, int qtdEpisodios) {
        super(titulo, ano);
        this.qtdTemporadas = qtdTemporadas;
        this.qtdEpisodios = qtdEpisodios;
        this.listaTemporadas = new ArrayList<>();
        this.listaEpisodios = new ArrayList<>();

        for (int i = 1; i <= qtdTemporadas; i++) {
            listaTemporadas.add(new Temporada(i));
        }
        for (int i = 1; i <= qtdEpisodios; i++) {
            listaEpisodios.add(new Episodio(i, "Episódio " + i));
        }
    }

    public Temporada getTemporadaPorNumero(int numero) {
        for (Temporada t : listaTemporadas) {
            if (t.getNumero() == numero) return t;
        }
        return null;
    }

    public Episodio getEpisodioPorNumero(int numero) {
        for (Episodio e : listaEpisodios) {
            if (e.getNumero() == numero) return e;
        }
        return null;
    }

    @Override
    public void marcarComoVisto(Espectador espectador) throws Exception {
        espectador.marcarComoVisto(this);
    }

    @Override
    public String toString() {
        return "[Série] " + titulo + " (" + ano + ") - " + qtdTemporadas + " Temps, " + qtdEpisodios + " Eps";
    }
}