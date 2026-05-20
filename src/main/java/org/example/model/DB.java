package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class DB implements java.io.Serializable {
    private String url;
    private List<UtilizadorRegistado> lstUtilizadores;
    private List<Ator> lstAtores;
    private List<Recurso> lstRecursos;
    private List<Classificacao> lstClassificacoes;
    private List<Comentario> lstComentarios;

    public DB(String url) {
        this.url = url;
        this.lstAtores = new ArrayList<>();
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

    public String listarClassificacoesDoUtilizador(UtilizadorRegistado u) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAs Minhas Classificações:");
        int cont = 0;
        for (Classificacao c : lstClassificacoes) {
            if (c.getEspectador().equals(u)) {
                sb.append("\n\t- ").append(c);
                cont++;
            }
        }
        if (cont == 0) {
            sb.append(" (Ainda não classificaste nenhum conteúdo)\n");
        }
        return sb.toString();
    }

    public String listarComentariosDoUtilizador(UtilizadorRegistado u) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nOs Meus Comentários:");
        int cont = 0;
        for (Comentario c : lstComentarios) {
            if (c.getEspectador().equals(u)) {
                sb.append("\n\t- ").append(c);
                cont++;
            }
        }
        if (cont == 0) {
            sb.append(" (Ainda não escreveste nenhum comentário)\n");
        }
        return sb.toString();
    }

    public static void gravarDados(DB imdb, String nomeFicheiro) {
        try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream(nomeFicheiro))) {
            oos.writeObject(imdb);
            System.out.println("[Sistema] Dados guardados com sucesso localmente!");
        } catch (java.io.IOException e) {
            System.out.println("[Erro] Não foi possível guardar os dados: " + e.getMessage());
        }
    }

    public static DB carregarDados(String nomeFicheiro) {
        try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(nomeFicheiro))) {
            System.out.println("[Sistema] Dados anteriores carregados com sucesso!");
            return (DB) ois.readObject();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("[Sistema] Nenhum ficheiro de dados encontrado. A iniciar base de dados vazia...");
            return null;
        } catch (Exception e) {
            System.out.println("[Erro] Erro ao carregar dados: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== Estado atual da DB ===\n");
        sb.append("(").append(url).append(")");
        return sb.toString();
    }
}