package org.example.ui;

import org.example.model.*;

public class Main {
    static void main(String[] args) {
        try {
            DB db = new DB("localhost:3306/streaming_db");

            Espectador ana = new Espectador("ana", "ana@email.com", "abc");
            Espectador pedro = new Espectador("pedro", "pedro@email.com", "qwerty");
            db.adicionarUtilizador(ana);
            db.adicionarUtilizador(pedro);

            Filme f1 = new Filme("Interstellar", 2014, 169);
            db.adicionarRecurso(f1);

            MenuInicial menu = new MenuInicial(db);
            menu.run();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}