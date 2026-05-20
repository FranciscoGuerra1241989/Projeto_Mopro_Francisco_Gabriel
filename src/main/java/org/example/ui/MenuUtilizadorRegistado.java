package org.example.ui;

import org.example.model.*;
import org.example.utils.Utils;

public class MenuUtilizadorRegistado {
    private DB imdb;
    private Espectador utilizador;
    private String opcao;

    public MenuUtilizadorRegistado(DB imdb, Espectador utilizador) {
        this.utilizador = utilizador;
        this.imdb = imdb;
    }

    public void run() {
        do {
            System.out.println("\n\n");
            System.out.println("#################################################");
            System.out.println("#           MENU UTILIZADOR REGISTADO           #");
            System.out.println("#################################################");
            System.out.println("#  Olá, " + utilizador.getNome());
            System.out.println("#################################################");
            System.out.println("#  [ ÁREA PESSOAL ]                             #");
            System.out.println("#  1. Ver o meu Histórico de conteúdos vistos   #");
            System.out.println("#  2. Mudar Password / Username                 #");
            System.out.println("#  3. Ver os meus Comentários e Avaliações      #");
            System.out.println("#                                               #");
            System.out.println("#  [ PESQUISA E EXPLORAÇÃO GLOBAIS ]            #");
            System.out.println("#  4. Listar Filmes e Séries disponíveis        #");
            System.out.println("#  5. Ver todas as classificações globais       #");
            System.out.println("#  6. Ver todos os comentários globais          #");
            System.out.println("#                                               #");
            System.out.println("#  [ INTERAÇÃO COM CONTEÚDOS ]                 #");
            System.out.println("#  7. Pesquisar recurso por título              #");
            System.out.println("#  8. Marcar filme/série como VISTO             #");
            System.out.println("#  9. Classificar um filme/série (1-5 estrelas) #");
            System.out.println("# 10. Escrever um comentário/crítica            #");
            System.out.println("#                                               #");
            System.out.println("#  0. Voltar (Log-out)                          #");
            System.out.println("#################################################");
            System.out.println();

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case "1":
                    System.out.println("\n=== O MEU HISTÓRICO DE VISTOS ===");
                    if (utilizador.getConteudosVistos().isEmpty()) {
                        System.out.println("Ainda não viste nenhum conteúdo.");
                    } else {
                        for (MarcavelComoVisto m : utilizador.getConteudosVistos()) {
                            System.out.println("- " + m);
                        }
                    }
                    break;

                case "2":
                    System.out.println("\n=== ALTERAR DADOS DA CONTA ===");
                    String novoUser = Utils.readLineFromConsole("Introduza o novo username (ou Enter para manter): ");
                    String novaPass = Utils.readLineFromConsole("Introduza a nova password (ou Enter para manter): ");
                    System.out.println("Dados registados temporariamente na sessão!");
                    break;

                case "3":
                    System.out.println("\n=== AS MINHAS AVALIAÇÕES E CRÍTICAS ===");
                    System.out.println("--- Minhas Classificações ---");
                    System.out.println(imdb.listarClassificacoes());
                    break;

                case "4":
                    System.out.println(imdb.listarRecursos());
                    break;

                case "5":
                    System.out.println(imdb.listarClassificacoes());
                    break;

                case "6":
                    System.out.println(imdb.listarComentarios());
                    break;

                case "7":
                    String termo = Utils.readLineFromConsole("Introduza o título a pesquisar: ");
                    Recurso rec = imdb.getRecursoPorTitulo(termo);
                    if (rec != null) {
                        System.out.println("\nEncontrado: " + rec);
                    } else {
                        System.out.println("Nenhum recurso encontrado com esse título.");
                    }
                    break;

                case "8":
                    System.out.println(imdb.listarRecursos());
                    String titVisto = Utils.readLineFromConsole("Nome do filme/série a marcar como visto: ");
                    Recurso recVisto = imdb.getRecursoPorTitulo(titVisto);
                    if (recVisto != null && recVisto instanceof MarcavelComoVisto) {
                        try {
                            ((MarcavelComoVisto) recVisto).marcarComoVisto(utilizador);
                            System.out.println("Conteúdo adicionado ao teu histórico!");
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Recurso não encontrado ou inválido.");
                    }
                    break;

                case "9":
                    System.out.println(imdb.listarRecursos());
                    String titClass = Utils.readLineFromConsole("Nome do filme/série a classificar: ");
                    Recurso recClass = imdb.getRecursoPorTitulo(titClass);
                    if (recClass != null) {
                        try {
                            int nota = Utils.readIntFromConsole("Nota (1 a 5 estrelas): ");
                            imdb.adicionarClassificacao(new Classificacao(utilizador, recClass, nota));
                            System.out.println("Classificação submetida com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Recurso não encontrado.");
                    }
                    break;

                case "10":
                    System.out.println(imdb.listarRecursos());
                    String titCom = Utils.readLineFromConsole("Nome do filme/série a comentar: ");
                    Recurso recCom = imdb.getRecursoPorTitulo(titCom);
                    if (recCom != null) {
                        try {
                            String textoCom = Utils.readLineFromConsole("Escreve o teu comentário: ");
                            imdb.adicionarComentario(new Comentario(utilizador, recCom, textoCom));
                            System.out.println("Comentário publicado!");
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Recurso não encontrado.");
                    }
                    break;

                case "0":
                    System.out.println("A terminar sessão...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (!opcao.equals("0"));
    }
}

