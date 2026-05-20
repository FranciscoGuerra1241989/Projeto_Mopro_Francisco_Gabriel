package org.example.ui;
import org.example.model.Admin;
import org.example.model.Espectador;
import org.example.model.DB;
import org.example.model.Espectador;
import org.example.model.UtilizadorRegistado;
import org.example.utils.Utils;

public class MenuInicial {
    private DB imdb;
    private String opcao;

    public MenuInicial(DB imdb) {
        this.imdb = imdb;
    }

    public void run() {
        do {
            System.out.println("\n\n");
            System.out.println("#################################################");
            System.out.println("#               SISTEMA STREAMING               #");
            System.out.println("#################################################");
            System.out.println("#                                               #");
            System.out.println("#  1. Entrar sem Login                          #");
            System.out.println("#  2. Fazer Login                               #");
            System.out.println("#  3. Registar Novo Utilizador                  #");
            System.out.println("#                                               #");
            System.out.println("#  0. Sair da Aplicação                         #");
            System.out.println("#                                               #");
            System.out.println("#################################################");
            System.out.println();

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case "1":
                    MenuSemLogin mSemLogin = new MenuSemLogin(imdb);
                    mSemLogin.run();
                    break;

                case "2":
                    String voltar2;
                    do {
                        System.out.println("\n=== LOGIN ===");
                        String user = Utils.readLineFromConsole("Username: ");
                        String pass = Utils.readLineFromConsole("Password: ");

                        UtilizadorRegistado u = imdb.login(user, pass);
                        if (u != null) {
                            if (u.getNome().equals("admin")) {
                                System.out.println("\nLogin efetuado com sucesso como Administrador!");
                                MenuAdministrador mAdmin = new MenuAdministrador(imdb);
                                mAdmin.run();
                                voltar2 = "0";
                            } else if (u instanceof Espectador) {
                                System.out.println("\nLogin efetuado com sucesso! Bem-vindo, " + u.getNome() + ".");
                                MenuUtilizadorRegistado mUser = new MenuUtilizadorRegistado(imdb, (Espectador) u);
                                mUser.run();
                                voltar2 = "0";
                            } else {
                                voltar2 = "0";
                            }
                        } else {
                            System.out.println("Username ou Password incorretos!");
                            System.out.println("1. Tentar novamente");
                            System.out.println("0. Voltar ao menu principal");
                            voltar2 = Utils.readLineFromConsole("Escolha uma opção: ");
                        }
                    } while (!voltar2.equals("0"));
                    break;

                case "3":
                    String voltar3;
                    do {
                        System.out.println("\n=== REGISTAR NOVO UTILIZADOR ===");
                        String novoUser = Utils.readLineFromConsole("Escolha um Username: ");

                        if (novoUser.trim().isEmpty() || novoUser.equalsIgnoreCase("admin")) {
                            System.out.println("Username inválido ou já reservado pelo sistema.");
                        } else {
                            String email = Utils.readLineFromConsole("Introduza o seu Email: ");
                            String password = Utils.readLineFromConsole("Escolha uma Password: ");

                            if (email.trim().isEmpty() || password.trim().isEmpty()) {
                                System.out.println("O email e a password não podem estar vazios.");
                            } else {
                                Espectador novoEspectador = new Espectador(novoUser, email, password);
                                imdb.adicionarUtilizador(novoEspectador);
                                System.out.println("Conta registada com sucesso! Já podes fazer login.");
                            }
                        }
                        voltar3 = Utils.readLineFromConsole("\nDigite 0 para voltar ao menu principal: ");
                    } while (!voltar3.equals("0"));
                    break;

                case "0":
                    System.out.println("Obrigado por usar o nosso sistema. Até à próxima!");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (!opcao.equals("0"));
    }
}
