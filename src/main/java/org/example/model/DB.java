package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private String url;
    private List<UtilizadorRegistado> lstUtilizadores;
    private List<Ator> lstAtores;
    private List<Recurso> lstRecursos;
    private List<Classificacao> lstClassificacoes;
    private List<Comentario> lstComentarios;

    public DB(String url) {
        this.url = url;
        this.lstAtores = new ArrayList<Ator>();
        this.lstUtilizadores = new ArrayList<>();
        this.lstRecursos = new ArrayList<>();
        this.lstClassificacoes = new ArrayList<>();
        this.lstComentarios = new ArrayList<>();
    }

    public void adicionarAtor(Ator a) {
        this.lstAtores.add(a);
    }

    public void removerAtor(Ator ator) {
        lstAtores.remove(ator);
    }

    public Ator pesquisaAtor(String nome) {
        for (Ator a : lstAtores) {
            if (a.temNome(nome)) {
                return a;
            }
        }
        return null;
    }

    public void adicionarUtilizador(UtilizadorRegistado u) {
        this.lstUtilizadores.add(u);
    }

    public void adicionarRecurso(Recurso r) {
        this.lstRecursos.add(r);
    }

    public void adicionarClassificacao(Classificacao c) {
        this.lstClassificacoes.add(c);
    }

    public void adicionarComentario(Comentario c) {
        this.lstComentarios.add(c);
    }

    public Recurso getRecursoPorTitulo(String titulo) {
        for (Recurso r : lstRecursos) {
            if (r.getTitulo().equalsIgnoreCase(titulo)) {
                return r;
            }
        }
        return null;
    }

    public UtilizadorRegistado login(String username, String password) {
        for (UtilizadorRegistado u : lstUtilizadores) {
            if (u.temNome(username) && u.temPassord(password)) {
                return u;
            }
        }
        return null;
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

    public String listarRecursos() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de Recursos:");
        if (lstRecursos.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Recurso r : lstRecursos) {
                sb.append("\n\t- ").append(r);
            }
        }
        return sb.toString();
    }

    public String listarClassificacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de Classificações:");
        if (lstClassificacoes.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Classificacao c : lstClassificacoes) {
                sb.append("\n\t- ").append(c);
            }
        }
        return sb.toString();
    }

    public String listarComentarios() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de Comentários:");
        if (lstComentarios.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Comentario c : lstComentarios) {
                sb.append("\n\t- ").append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== Estado atual da DB ===\n");
        sb.append("(").append(url).append(")");
        return sb.toString();
    }
}