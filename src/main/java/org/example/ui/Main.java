//package org.example.ui;
//
//import org.example.model.*;
//
//public class Main {
//    private static final String FICHEIRO_DADOS = "streaming.dat";
//
//    public static void main(String[] args) {
//        try {
//            DB db = DB.carregarDados(FICHEIRO_DADOS);
//
//            if (db == null) {
//                db = new DB("localhost:3306/streaming_db");
//                Espectador admin = new Espectador("admin", "admin@streaming.com", "admin");
//                db.adicionarUtilizador(admin);
//
//                Filme f1 = new Filme("Interstellar", 2014, 169);
//                db.adicionarRecurso(f1);
//
//
//                System.out.println("[Sistema] Base de dados inicializada apenas com o administrador.");
//            }
//
//            MenuInicial menu = new MenuInicial(db);
//            menu.run();
//
//            System.out.println("\nA fechar o programa e a guardar alterações...");
//            DB.gravarDados(db, FICHEIRO_DADOS);
//
//        } catch (Exception e) {
//            System.out.println("Erro crítico na aplicação: " + e.getMessage());
//        }
//    }
//}
package org.example.ui;

import org.example.model.*;
import org.example.utils.Data;

public class Main {
    private static final String FICHEIRO_DADOS = "streaming.dat";

    public static void main(String[] args) {
        try {
            DB db = DB.carregarDados(FICHEIRO_DADOS);

            if (db == null) {
                db = new DB("localhost:3306/streaming_db");

                Espectador admin = new Espectador("admin", "admin@streaming.com", "admin");
                db.adicionarUtilizador(admin);

                Espectador ana = new Espectador("ana", "ana@email.com", "abc");
                Espectador pedro = new Espectador("pedro", "pedro@email.com", "peter");
                Espectador goncalo = new Espectador("goncalo", "goncalo@email.com", "1234");
                db.adicionarUtilizador(ana);
                db.adicionarUtilizador(pedro);
                db.adicionarUtilizador(goncalo);

                Filme f1 = new Filme("Interstellar", 2014, 169);
                Filme f2 = new Filme("Rapunzel", 2010, 100);
                db.adicionarRecurso(f1);
                db.adicionarRecurso(f2);

                Serie s1 = new Serie("Bones", 2005, 12, 246);
                Serie s2 = new Serie("Mandalorian", 2019, 3, 24);
                db.adicionarRecurso(s1);
                db.adicionarRecurso(s2);

                Ator a1 = new Ator("Brad Pitt", new Data(18, 12, 1963));
                Ator a2 = new Ator("Morgan Freeman", new Data(1, 6, 1937));
                db.adicionarAtor(a1);
                db.adicionarAtor(a2);

                System.out.println("[Sistema] Base de dados inicializada com os dados solicitados.");
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