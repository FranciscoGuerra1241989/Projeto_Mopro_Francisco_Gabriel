package org.example.model;

public class Classificacao implements java.io.Serializable {
    private Espectador espectador;
    private Recurso recurso;
    private int nota;

    public Classificacao(Espectador espectador, Recurso recurso, int nota) throws Exception {
        if (espectador == null) {
            throw new Exception("Espectador inválido");
        }
        if (recurso == null) {
            throw new Exception("Recurso inválido");
        }
        if (nota < 1 || nota > 5) {
            throw new Exception("A classificação deve ser entre 1 e 5");
        }
        this.espectador = espectador;
        this.recurso = recurso;
        this.nota = nota;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return recurso.getTitulo() + " -> " + nota + " estrelas (por: " + espectador.getNome() + ")";
    }
}
