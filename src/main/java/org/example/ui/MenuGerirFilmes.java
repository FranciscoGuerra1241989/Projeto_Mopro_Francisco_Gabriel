package org.example.ui;

import org.example.model.DB;
import org.example.model.Filme;
import org.example.model.Recurso;
import org.example.utils.Utils;

public class MenuGerirFilmes {
    private DB imdb;
    private String opcao;

    public MenuGerirFilmes(DB imdb) {
        this.imdb = imdb;
    }

    public void run() {
        do {
            System.out.println("\n\n");
            System.out.println("#################################################");
            System.out.println("#                 GERIR FILMES                  #");
            System.out.println("#################################################");
            System.out.println("#                                               #");
            System.out.println("#  1. Ver filmes                                #");
            System.out.println("#  2. Adicionar filme                           #");
            System.out.println("#  3. Remover filme                             #");
            System.out.println("#                                               #");
            System.out.println("#  0. Voltar                                    #");
            System.out.println("#################################################");
            System.out.println();

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case "1":
                    System.out.println(imdb.listarRecursos());
                    Utils.readLineFromConsole("\nPressione Enter para continuar...");
                    break;

                case "2":
                    System.out.println("\n=== ADICIONAR NOVO FILME ===");
                    String titulo = Utils.readLineFromConsole("Título do Filme: ");
                    if (!titulo.trim().isEmpty()) {
                        String txtAno = Utils.readLineFromConsole("Ano de Lançamento: ");
                        int ano = Integer.parseInt(txtAno);
                        String txtDuracao = Utils.readLineFromConsole("Duração (em minutos): ");
                        int duracao = Integer.parseInt(txtDuracao);

                        Filme novoFilme = new Filme(titulo, ano, duracao);
                        imdb.adicionarRecurso(novoFilme);
                        System.out.println("Filme adicionado com sucesso!");
                    } else {
                        System.out.println("O título não pode estar vazio.");
                    }
                    break;

                case "3":
                    System.out.println("\n=== REMOVER FILME ===");
                    String titRemover = Utils.readLineFromConsole("Introduza o título do filme a remover: ");
                    Recurso rec = imdb.getRecursoPorTitulo(titRemover);
                    if (rec instanceof Filme) {
                        imdb.removerRecurso(rec);
                        System.out.println("Filme removido com sucesso!");
                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (!opcao.equals("0"));
    }
}
