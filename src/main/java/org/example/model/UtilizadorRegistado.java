package org.example.model;

public abstract class UtilizadorRegistado {
    private String username;
    private String email;
    private String password;

    public UtilizadorRegistado(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getNome() {
        return username;
    }

    public boolean temPassord(String pass){
        return password.equals(pass);
    }

    @Override
    public String toString() {
        return username + " <" + email + ">";
    }

    public boolean temNome(String nome) {
        return nome.equals(username);
    }
}