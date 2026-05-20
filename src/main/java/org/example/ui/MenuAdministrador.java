package org.example.ui;

import org.example.model.DB;
import org.example.model.Filme;
import org.example.model.Serie;
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
            System.out.println("#  1. Adicionar Filme                           #");
            System.out.println("#  2. Adicionar Série                           #");
            System.out.println("#  3. Gerir Atores                              #");
            System.out.println("#                                               #");
            System.out.println("#  0. Voltar (Log-out)                          #");
            System.out.println("#################################################");
            System.out.println();

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case "1":
                    String voltar1;
                    do {
                        System.out.println("\n=== ADICIONAR NOVO FILME ===");
                        String titulo = Utils.readLineFromConsole("Título do Filme: ");
                        if (titulo.trim().isEmpty()) {
                            System.out.println("O título não pode estar vazio.");
                        } else {
                            try {
                                int ano = Utils.readIntFromConsole("Ano de Lançamento: ");
                                int duracao = Utils.readIntFromConsole("Duração (em minutos): ");

                                Filme novoFilme = new Filme(titulo, ano, duracao);
                                imdb.adicionarRecurso(novoFilme);
                                System.out.println("Filme adicionado com sucesso ao catálogo!");
                            } catch (Exception e) {
                                System.out.println("Erro ao introduzir dados: " + e.getMessage());
                            }
                        }
                        voltar1 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar1.equals("0"));
                    break;

                case "2":
                    String voltar2;
                    do {
                        System.out.println("\n=== ADICIONAR NOVA SÉRIE ===");
                        String titulo = Utils.readLineFromConsole("Título da Série: ");
                        if (titulo.trim().isEmpty()) {
                            System.out.println("O título não pode estar vazio.");
                        } else {
                            try {
                                int ano = Utils.readIntFromConsole("Ano de Lançamento: ");
                                int temporadas = Utils.readIntFromConsole("Quantidade de Temporadas: ");
                                int episodios = Utils.readIntFromConsole("Quantidade de Episódios: ");

                                Serie novaSerie = new Serie(titulo, ano, temporadas, episodios);
                                imdb.adicionarRecurso(novaSerie);
                                System.out.println("Série adicionada com sucesso ao catálogo!");
                            } catch (Exception e) {
                                System.out.println("Erro ao introduzir dados: " + e.getMessage());
                            }
                        }
                        voltar2 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar2.equals("0"));
                    break;

                case "3":
                    System.out.println("\nRedirecionando para o menu de gestão de atores...");
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
        }
        while (!opcao.equals("0"));
    }
}
