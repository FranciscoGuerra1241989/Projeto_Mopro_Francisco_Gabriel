package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private String url;

    private List<UtilizadorRegistado> lstUtilizadores;
    private List<Ator> lstAtores;
    private List<Recurso> lstRecursos;
    private List<Classificacao> lstClassificacoes; // Adicionado para gerir as notas
    private List<Comentario> lstComentarios;       // Adicionado para gerir as críticas

    public DB(String url) {
        this.url = url;
        this.lstAtores = new ArrayList<Ator>();
        this.lstUtilizadores = new ArrayList<>();
        this.lstRecursos = new ArrayList<>();
        this.lstClassificacoes = new ArrayList<>(); // Inicializado
        this.lstComentarios = new ArrayList<>();     // Inicializado
    }

    // Métodos para Atores
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

    // Métodos para Utilizadores
    public void adicionarUtilizador(UtilizadorRegistado u) {
        this.lstUtilizadores.add(u);
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

    // Métodos para Recursos (Filmes e Séries)
    public void adicionarRecurso(Recurso r) {
        this.lstRecursos.add(r);
    }

    public void removerRecurso(Recurso recurso) {
        lstRecursos.remove(recurso);
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

    // NOVOS MÉTODOS: Classificações e Comentários
    public void adicionarClassificacao(Classificacao c) {
        this.lstClassificacoes.add(c);
    }

    public void adicionarComentario(Comentario c) {
        this.lstComentarios.add(c);
    }

    // Métodos de Listagem
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
                // Proteção caso a classe Admin mude de nome ou pasta
                boolean isAdmin = u.getClass().getSimpleName().equalsIgnoreCase("Admin");
                sb.append("\n\t- ").append(u).append(isAdmin ? " (admin)" : "");
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
        StringBuilder sb = new StringBuilder("=== Estado atual da DB ===").append("\n");
        sb.append("(").append(url).append(")");
        sb.append(listarUtilizadores());
        sb.append(listarAtores());
        sb.append(listarRecursos());
        sb.append(listarClassificacoes()); // Incluído no estado geral
        sb.append(listarComentarios());    // Incluído no estado geral
        return sb.toString();
    }
}