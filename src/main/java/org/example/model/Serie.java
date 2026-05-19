package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Recurso implements MarcavelComoVisto {
    private List<Temporada> temporadas;

    public Serie(String titulo, int anoLancamento) {
        super(titulo, anoLancamento);
        this.temporadas = new ArrayList<>();
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void adicionarTemporada(Temporada temporada) {
        if (!temporadas.contains(temporada)) {
            temporadas.add(temporada);
        }
    }

    @Override
    public boolean isVisto(Expectador utilizador) {
        if (temporadas.isEmpty()) {
            return false;
        }
        for (Temporada t : temporadas) {
            if (!t.isVisto(utilizador)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void marcarComoVisto(Expectador utilizador) throws Exception {
        if (utilizador == null) {
            throw new Exception("Utilizador inválido");
        }
        for (Temporada t : temporadas) {
            t.marcarComoVisto(utilizador);
        }
    }

    @Override
    public String toString() {
        return "[Série] " + super.toString() + " - Temporadas: " + temporadas.size();
    }
}
