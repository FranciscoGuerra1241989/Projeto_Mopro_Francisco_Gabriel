package org.example.ui;

import org.example.model.*;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        try {
            DB db = new DB("localhost:3306/streaming_db");
            Scanner teclado = new Scanner(System.in);

            // Deixamos dados guardados na DB para tu poderes testar o login
            Espectador espectador = new Espectador("gabriel123", "gabriel@email.com", "pass123");
            db.adicionarUtilizador(espectador);

            Filme filme = new Filme("Interstellar", 2014, 169);
            db.adicionarRecurso(filme);

            System.out.println("=== BEM-VINDO À PLATAFORMA ===");
            System.out.print("Introduza o seu username: ");
            String usernameIntroduzido = teclado.nextLine();

            System.out.print("Introduza a sua password: ");
            String passwordIntroduzida = teclado.nextLine();

            System.out.println("\nA autenticar...");
            UtilizadorRegistado userLogado = db.login(usernameIntroduzido, passwordIntroduzida);

            if (userLogado != null) {
                System.out.println("Login efetuado com sucesso! Bem-vindo, " + userLogado.getNome());

                // Agora podes interagir com o filme
                System.out.println("\n[1] Marcar filme 'Interstellar' como visto");
                System.out.println("[2] Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = teclado.nextInt();

                if (opcao == 1) {
                    filme.marcarComoVisto((Espectador) userLogado);
                    System.out.println("Sucesso! O filme foi adicionado à sua lista de vistos.");
                } else {
                    System.out.println("A sair do sistema...");
                }

            } else {
                System.out.println("Falha no login: Username ou password incorretos.");
            }

            System.out.println("\n" + db);
            teclado.close();

        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}