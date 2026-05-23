package org.example.model;

public class Classificacao implements java.io.Serializable {
    private Espectador espectador;
    private Object conteudo;
    private int nota;

    public Classificacao(Espectador espectador, Object conteudo, int nota) throws Exception {
        if (espectador == null) {
            throw new Exception("Espectador inválido");
        }
        if (conteudo == null) {
            throw new Exception("Conteúdo inválido");
        }
        if (nota < 1 || nota > 5) {
            throw new Exception("A classificação deve ser entre 1 e 5");
        }
        this.espectador = espectador;
        this.conteudo = conteudo;
        this.nota = nota;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public int getNota() {
        return nota;
    }

    public Object getConteudo() {
        return conteudo;
    }

    @Override
    public String toString() {
        String titulo;

        // Truque para descobrir o nome do que foi classificado sem crashar
        if (conteudo instanceof Recurso) {
            titulo = ((Recurso) conteudo).getTitulo();
        } else {
            titulo = conteudo.toString(); // Usa o toString da Temporada/Episódio
        }

        return titulo + " -> " + nota + " estrelas (por: " + espectador.getNome() + ")";
    }
}
