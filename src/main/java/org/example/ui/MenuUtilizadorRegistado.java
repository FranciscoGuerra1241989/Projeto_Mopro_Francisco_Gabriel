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
            System.out.println("#  8. Pesquisar ator por nome                   #");
            System.out.println("#  9. Marcar filme/série como VISTO             #");
            System.out.println("#  10. Classificar um filme/série (1-5 estrelas)#");
            System.out.println("#  11. Escrever um comentário/crítica           #");
            System.out.println("#                                               #");
            System.out.println("#  0. Voltar (Log-out)                          #");
            System.out.println("#################################################");
            System.out.println();

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case "1":
                    String voltar1;
                    do {
                        System.out.println("\n=== O MEU HISTÓRICO DE VISTOS ===");
                        if (utilizador.getConteudosVistos().isEmpty()) {
                            System.out.println("Ainda não viste nenhum conteúdo.");
                        } else {
                            for (MarcavelComoVisto m : utilizador.getConteudosVistos()) {
                                System.out.println("- " + m);
                            }
                        }
                        voltar1 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar1.equals("0"));
                    break;

                case "2":
                    String voltar2;
                    do {
                        System.out.println("\n=== ALTERAR DADOS DA CONTA ===");
                        System.out.println("1. Alterar Username");
                        System.out.println("2. Alterar Password");
                        System.out.println("0. Voltar atrás");
                        String subOpcao = Utils.readLineFromConsole("Escolha uma opção: ");

                        if (subOpcao.equals("1")) {
                            String novoUser = Utils.readLineFromConsole("Introduza o novo username: ");
                            if (!novoUser.trim().isEmpty() && !novoUser.equalsIgnoreCase("admin")) {
                                utilizador.setUsername(novoUser);
                                System.out.println("Username atualizado com sucesso!");
                            } else {
                                System.out.println("Username inválido.");
                            }
                        } else if (subOpcao.equals("2")) {
                            String novaPass = Utils.readLineFromConsole("Introduza a nova password: ");
                            if (!novaPass.trim().isEmpty()) {
                                utilizador.setPassword(novaPass);
                                System.out.println("Password atualizada com sucesso!");
                            } else {
                                System.out.println("Password inválida.");
                            }
                        }
                        voltar2 = subOpcao.equals("0") ? "0" : Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar2.equals("0"));
                    break;

                case "3":
                    String voltar3;
                    do {
                        System.out.println("\n=== AS MINHAS AVALIAÇÕES E CRÍTICAS ===");
                        System.out.println(imdb.listarClassificacoesDoUtilizador(utilizador));
                        System.out.println(imdb.listarComentariosDoUtilizador(utilizador));
                        voltar3 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar3.equals("0"));
                    break;

                case "4":
                    String voltar4;
                    do {
                        System.out.println(imdb.listarRecursos());
                        voltar4 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar4.equals("0"));
                    break;

                case "5":
                    String voltar5;
                    do {
                        System.out.println(imdb.listarClassificacoes());
                        voltar5 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar5.equals("0"));
                    break;

                case "6":
                    String voltar6;
                    do {
                        System.out.println(imdb.listarComentarios());
                        voltar6 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar6.equals("0"));
                    break;

                case "7":
                    String voltar7;
                    do {
                        System.out.println("\n=== PESQUISAR RECURSO REAIS ===");
                        String termo = Utils.readLineFromConsole("Introduza o título a pesquisar: ");
                        Recurso rec = imdb.getRecursoPorTitulo(termo);
                        if (rec != null) {
                            System.out.println("\nEncontrado: " + rec);
                        } else {
                            System.out.println("Nenhum recurso encontrado com esse título.");
                        }
                        voltar7 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar7.equals("0"));
                    break;

                case "8":
                    String voltar8;
                    do {
                        System.out.println("\n=== PESQUISAR ATOR ===");
                        String nomeAtor = Utils.readLineFromConsole("Introduza o nome do ator a pesquisar: ");
                        Ator ator = imdb.pesquisaAtor(nomeAtor);
                        if (ator != null) {
                            System.out.println("\nEncontrado: " + ator);
                        } else {
                            System.out.println("Nenhum ator encontrado com esse nome.");
                        }
                        voltar8 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar8.equals("0"));
                    break;

                case "9":
                    String voltar9;
                    do {
                        System.out.println(imdb.listarRecursos());
                        String titVisto = Utils.readLineFromConsole("Nome do filme/série a marcar como visto: ");
                        Recurso recVisto = imdb.getRecursoPorTitulo(titVisto);

                        if (recVisto != null) {
                            MarcavelComoVisto alvo = selecionarAlvoInteracao(recVisto);
                            try {
                                alvo.marcarComoVisto(utilizador);
                                System.out.println("Adicionado ao teu histórico com sucesso!");
                            } catch (Exception e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Recurso não encontrado.");
                        }
                        voltar9 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar9.equals("0"));
                    break;

                case "10":
                    String voltar10;
                    do {
                        System.out.println(imdb.listarRecursos());
                        String titClass = Utils.readLineFromConsole("Nome do filme/série a classificar: ");
                        Recurso recClass = imdb.getRecursoPorTitulo(titClass);
                        if (recClass != null) {
                            MarcavelComoVisto alvo = selecionarAlvoInteracao(recClass);
                            try {
                                int nota = Utils.readIntFromConsole("Nota (1 a 5 estrelas): ");
                                imdb.adicionarClassificacao(new Classificacao(utilizador, (Recurso) alvo, nota));
                                System.out.println("Classificação submetida com sucesso!");
                            } catch (Exception e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Recurso não encontrado.");
                        }
                        voltar10 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar10.equals("0"));
                    break;

                case "11":
                    String voltar11;
                    do {
                        System.out.println(imdb.listarRecursos());
                        String titCom = Utils.readLineFromConsole("Nome do filme/série a comentar: ");
                        Recurso recCom = imdb.getRecursoPorTitulo(titCom);
                        if (recCom != null) {
                            MarcavelComoVisto alvo = selecionarAlvoInteracao(recCom);
                            try {
                                String textoCom = Utils.readLineFromConsole("Escreve o teu comentário: ");
                                imdb.adicionarComentario(new Comentario(utilizador, (Recurso) alvo, textoCom));
                                System.out.println("Comentário publicado!");
                            } catch (Exception e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Recurso não encontrado.");
                        }
                        voltar11 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu: ");
                    } while (!voltar11.equals("0"));
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

    private MarcavelComoVisto selecionarAlvoInteracao(Recurso recurso) {
        if (recurso instanceof Filme) {
            return (MarcavelComoVisto) recurso;
        }

        if (recurso instanceof Serie) {
            Serie serie = (Serie) recurso;
            System.out.println("\nEsta é uma Série. O que pretendes selecionar?");
            System.out.println("1. A Série completa");
            System.out.println("2. Uma Temporada específica");
            System.out.println("3. Um Episódio específico");

            String escolha = Utils.readLineFromConsole("Escolha uma opção: ");

            switch (escolha) {
                case "1":
                    return serie;
                case "2":
                    int numTemp = Utils.readIntFromConsole("Introduza o número da temporada: ");
                    Temporada t = serie.getTemporadaPorNumero(numTemp);
                    if (t != null) return t;
                    System.out.println("Temporada não encontrada. A focar na série global.");
                    return serie;
                case "3":
                    int numEp = Utils.readIntFromConsole("Introduza o número do episódio: ");
                    Episodio e = serie.getEpisodioPorNumero(numEp);
                    if (e != null) return e;
                    System.out.println("Episódio não encontrado. A focar na série global.");
                    return serie;
                default:
                    System.out.println("Opção inválida. A focar na série global.");
                    return serie;
            }
        }
        return null;
    }
}
