package org.example.ui;

import org.example.model.DB;
import org.example.utils.Utils;

public class MenuAdministrador {
    private DB imdb;
    private String opcao;

    public MenuAdministrador(DB imdb) {
        this.imdb = imdb;
    }

    public void run() {
        do {
            System.out.println("\n\n");
            System.out.println("#################################################");
            System.out.println("#               MENU ADMINISTRADOR              #");
            System.out.println("#################################################");
            System.out.println("#                                               #");
            System.out.println("#  1. Gerir Filmes                              #");
            System.out.println("#  2. Gerir Séries                              #");
            System.out.println("#  3. Gerir Atores                              #");
            System.out.println("#                                               #");
            System.out.println("#  0. Voltar (Log-out)                          #");
            System.out.println("#################################################");
            System.out.println();

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case "1":
                    MenuGerirFilmes menuFilmes = new MenuGerirFilmes(imdb);
                    menuFilmes.run();
                    break;

                case "2":
                    MenuGerirSeries menuSeries = new MenuGerirSeries(imdb);
                    menuSeries.run();
                    break;

                case "3":
                    MenuGerirAtores menuAtores = new MenuGerirAtores(imdb);
                    menuAtores.run();
                    break;

                case "0":
                    System.out.println("A sair do perfil de Administrador...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (!opcao.equals("0"));
    }
}
