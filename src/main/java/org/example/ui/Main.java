package org.example.ui;

import org.example.model.*;

public class Main {
    private static final String FICHEIRO_DADOS = "streaming.dat";

    public static void main(String[] args) {
        try {
            DB db = DB.carregarDados(FICHEIRO_DADOS);

            if (db == null) {
                db = new DB("localhost:3306/streaming_db");

                Espectador admin = new Espectador("admin", "admin@streaming.com", "admin");
                db.adicionarUtilizador(admin);

                Filme f1 = new Filme("Interstellar", 2014, 169);
                db.adicionarRecurso(f1);


                System.out.println("[Sistema] Base de dados inicializada apenas com o administrador.");
            }

            MenuInicial menu = new MenuInicial(db);
            menu.run();

            System.out.println("\nA fechar o programa e a guardar alterações...");
            DB.gravarDados(db, FICHEIRO_DADOS);

        } catch (Exception e) {
            System.out.println("Erro crítico na aplicação: " + e.getMessage());
        }
    }
}
