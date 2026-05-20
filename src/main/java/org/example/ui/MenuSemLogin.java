package org.example.ui;

import org.example.model.DB;
import org.example.utils.Utils;

public class MenuSemLogin {
    private DB imdb;
    private String opcao;

    public MenuSemLogin(DB imdb) {
        this.imdb = imdb;
    }

    public void run() {
        do {
            System.out.println("\n\n");
            System.out.println("#################################################");
            System.out.println("#                MENU SEM LOGIN                 #");
            System.out.println("#################################################");
            System.out.println("#                                               #");
            System.out.println("#  1. Ver atores                                #");
            System.out.println("#  2. Ver filmes e séries                       #");
            System.out.println("#  3. Ver classificações                        #");
            System.out.println("#                                               #");
            System.out.println("#  0. Voltar                                    #");
            System.out.println("#                                               #");
            System.out.println("#################################################");
            System.out.println();

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case "1":
                    String voltar1;
                    do {
                        System.out.println(imdb.listarAtores());
                        voltar1 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar1.equals("0"));
                    break;

                case "2":
                    String voltar2;
                    do {
                        System.out.println(imdb.listarRecursos());
                        voltar2 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar2.equals("0"));
                    break;

                case "3":
                    String voltar3;
                    do {
                        System.out.println(imdb.listarClassificacoes());
                        voltar3 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar3.equals("0"));
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        while (!opcao.equals("0"));
    }
}

