package org.example.ui;

import org.example.model.*;

public class Main {
    static void main(String[] args) {
        try {
            DB db = new DB("localhost:3306/streaming_db");

            Espectador espectador = new Espectador("gabriel123", "gabriel@email.com", "pass123");
            db.adicionarUtilizador(espectador);

            Filme filme = new Filme("Interstellar", 2014, 169);
            db.adicionarRecurso(filme);

            Serie serie = new Serie("Breaking Bad", 2008);

            Temporada t1 = new Temporada(1);
            Episodio e1 = new Episodio("Pilot", 58);
            Episodio e2 = new Episodio("Cat's in the Bag...", 48);

            serie.adicionarTemporada(t1);
            serie.adicionarEpisodio(e1);
            serie.adicionarEpisodio(e2);

            db.adicionarRecurso(serie);

            System.out.println("--- Teste de Login ---");
            UtilizadorRegistado userLogado = db.login("gabriel123", "pass123");
            if (userLogado != null) {
                System.out.println("Login efetuado com sucesso! Bem-vindo, " + userLogado.getNome());
            } else {
                System.out.println("Falha no login: credenciais inválidas.");
            }

            System.out.println("\n--- Teste de Conteúdos Vistos ---");
            System.out.println("O Gabriel já viu o filme " + filme.getTitulo() + "? " + (filme.isVisto(espectador) ? "Sim" : "Não"));

            filme.marcarComoVisto(espectador);
            System.out.println("-> Filme marcado como visto.");
            System.out.println("O Gabriel já viu o filme " + filme.getTitulo() + "? " + (filme.isVisto(espectador) ? "Sim" : "Não"));

            System.out.println("\n--- Teste de Interações ---");

            Classificacao notaFilme = new Classificacao(espectador, filme, 5);
            db.adicionarClassificacao(notaFilme);

            Comentario criticaSerie = new Comentario(espectador, serie, "Simplesmente genial, uma das melhores séries de sempre!");
            db.adicionarComentario(criticaSerie);

            System.out.println("\n" + db);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante os testes: " + e.getMessage());
        }
    }
}