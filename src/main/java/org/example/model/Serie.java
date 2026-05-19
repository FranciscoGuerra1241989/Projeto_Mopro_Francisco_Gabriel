package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Recurso implements MarcavelComoVisto {
    private List<Temporada> temporadas;
    private List<Episodio> episodios;

    public Serie(String titulo, int anoLancamento) {
        super(titulo, anoLancamento);
        this.temporadas = new ArrayList<Temporada>();
        this.episodios = new ArrayList<Episodio>();
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void adicionarTemporada(Temporada temporada) {
        if (temporada != null && !temporadas.contains(temporada)) {
            temporadas.add(temporada);
        }
    }

    public void adicionarEpisodio(Episodio episodio) {
        if (episodio != null && !episodios.contains(episodio)) {
            episodios.add(episodio);
        }
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
        return "[Série] " + super.toString() + " - " + temporadas.size() + " temporadas, " + episodios.size() + " episódios";
    }
}
