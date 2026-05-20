package org.example.model;

public abstract class Recurso implements java.io.Serializable {
    protected String titulo;
    protected int ano;

    public Recurso(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Recurso outro = (Recurso) obj;
        return titulo.equalsIgnoreCase(outro.titulo);
    }
}
