package br.com.minhalanchonete.model;

import java.util.List;

public class Lanche {

    private String nome;
    private List<Ingrediente> ingredientes;

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
