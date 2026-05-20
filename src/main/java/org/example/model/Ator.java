package org.example.model;

import org.example.utils.Data;

public class Ator implements java.io.Serializable {
    private String nome;
    private Data dataNascimento;

    public Ator(String nome, Data dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public boolean temNome(String nome) {
        return this.nome.equalsIgnoreCase(nome);
    }

    @Override
    public String toString() {
        return nome + " (Nascido a: " + dataNascimento + ")";
    }
}
