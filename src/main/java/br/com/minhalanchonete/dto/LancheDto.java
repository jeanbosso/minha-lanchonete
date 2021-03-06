package br.com.minhalanchonete.dto;

import br.com.minhalanchonete.dto.generic.GenericDto;
import br.com.minhalanchonete.model.Ingrediente;

import java.util.List;

public class LancheDto extends GenericDto {

    private String nome;
    private List<Ingrediente> ingredientes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
