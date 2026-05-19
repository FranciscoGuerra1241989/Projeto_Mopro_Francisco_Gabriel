package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private String url;

    private List<UtilizadorRegistado> lstUtilizadores;
    private List<Ator> lstAtores;
    private List<Recurso> lstRecursos; // Armazena Filmes e Séries de forma polimórfica

    public DB(String url) {
        this.url = url;
        this.lstAtores = new ArrayList<Ator>();
        this.lstUtilizadores = new ArrayList<>();
        this.lstRecursos = new ArrayList<>();
    }

    public void adicionarAtor(Ator a) {
        this.lstAtores.add(a);
    }

    public void adicionarUtilizador(UtilizadorRegistado u) {
        this.lstUtilizadores.add(u);
    }

    public void adicionarRecurso(Recurso r) {
        this.lstRecursos.add(r);
    }

    public void removerAtor(Ator ator) {
        lstAtores.remove(ator);
    }

    public void removerRecurso(Recurso recurso) {
        lstRecursos.remove(recurso);
    }

    public UtilizadorRegistado pesquisaUtilizador(String username) {
        for (UtilizadorRegistado u : lstUtilizadores) {
            if (u.temNome(username)) {
                return u;
            }
        }
        return null;
    }

    public UtilizadorRegistado login(String username, String password) {
        UtilizadorRegistado ur = pesquisaUtilizador(username);
        if (ur != null && ur.temPassord(password))
            return ur;
        return null;
    }

    public Ator pesquisaAtor(String nome) {
        for (Ator a : lstAtores) {
            if (a.temNome(nome)) {
                return a;
            }
        }
        return null;
    }

    public Recurso pesquisaRecurso(String titulo) {
        for (Recurso r : lstRecursos) {
            if (r.getTitulo().equalsIgnoreCase(titulo)) {
                return r;
            }
        }
        return null;
    }


    public List<Recurso> pesquisarRecursosPorTexto(String texto) {
        List<Recurso> resultados = new ArrayList<>();
        for (Recurso r : lstRecursos) {
            if (r.correspondePesquisa(texto)) {
                resultados.add(r);
            }
        }
        return resultados;
    }

    public String listarRecursos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de Recursos (Filmes e Séries):");
        if (lstRecursos.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Recurso r : lstRecursos) {
                sb.append("\n\t- ").append(r);
            }
        }
        return sb.toString();
    }

    public String listarUtilizadores() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de Utilizadores:");
        if (lstUtilizadores.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (UtilizadorRegistado u : lstUtilizadores) {
                sb.append("\n\t- ").append(u).append(u instanceof Admin ? " (admin)" : "");
            }
        }
        return sb.toString();
    }

    public String listarAtores() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de Atores:");
        if (lstAtores.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Ator ator : lstAtores) {
                sb.append("\n\t- ").append(ator);
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== Estado atual da DB ===").append("\n");
        sb.append("(").append(url).append(")");
        sb.append(listarUtilizadores());
        sb.append(listarAtores());
        sb.append(listarRecursos());
        return sb.toString();
    }
}