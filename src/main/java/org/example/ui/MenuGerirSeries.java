package org.example.ui;

import org.example.model.DB;
import org.example.model.Serie;
import org.example.model.Recurso;
import org.example.utils.Utils;

public class MenuGerirSeries {
    private DB imdb;
    private String opcao;

    public MenuGerirSeries(DB imdb) {
        this.imdb = imdb;
    }

    public void run() {
        do {
            System.out.println("\n\n");
            System.out.println("#################################################");
            System.out.println("#                 GERIR SÉRIES                  #");
            System.out.println("#################################################");
            System.out.println("#                                               #");
            System.out.println("#  1. Ver séries                                #");
            System.out.println("#  2. Adicionar série                           #");
            System.out.println("#  3. Remover série                             #");
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
                    System.out.println("\n=== ADICIONAR NOVA SÉRIE ===");
                    String titulo = Utils.readLineFromConsole("Título da Série: ");
                    if (!titulo.trim().isEmpty()) {
                        String txtAno = Utils.readLineFromConsole("Ano de Lançamento: ");
                        int ano = Integer.parseInt(txtAno);
                        String txtTemp = Utils.readLineFromConsole("Quantidade de Temporadas: ");
                        int temporadas = Integer.parseInt(txtTemp);
                        String txtEp = Utils.readLineFromConsole("Quantidade de Episódios: ");
                        int episodios = Integer.parseInt(txtEp);

                        Serie novaSerie = new Serie(titulo, ano, temporadas, episodios);
                        imdb.adicionarRecurso(novaSerie);
                        System.out.println("Série adicionada com sucesso!");
                    } else {
                        System.out.println("O título não pode estar vazio.");
                    }
                    break;

                case "3":
                    System.out.println("\n=== REMOVER SÉRIE ===");
                    String titRemover = Utils.readLineFromConsole("Introduza o título da série a remover: ");
                    Recurso rec = imdb.getRecursoPorTitulo(titRemover);
                    if (rec instanceof Serie) {
                        imdb.removerRecurso(rec);
                        System.out.println("Série removido com sucesso!");
                    } else {
                        System.out.println("Série não encontrada.");
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
