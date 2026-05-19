package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Espectador extends UtilizadorRegistado {
    private List<MarcavelComoVisto> conteudosVistos;

    public Espectador(String username, String email, String password) {
        super(username, email, password);
        this.conteudosVistos = new ArrayList<MarcavelComoVisto>();
    }

    public void marcarComoVisto(MarcavelComoVisto conteudo) throws Exception {
        if (conteudo == null) {
            throw new Exception("Conteúdo inválido");
        }
        if (!conteudosVistos.contains(conteudo)) {
            conteudosVistos.add(conteudo);
        }
    }

    public boolean jaViu(MarcavelComoVisto conteudo) {
        return conteudosVistos.contains(conteudo);
    }

    public List<MarcavelComoVisto> getConteudosVistos() {
        return conteudosVistos;
    }
}