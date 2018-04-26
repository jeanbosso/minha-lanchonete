package br.com.minhalanchonete.dto;

import br.com.minhalanchonete.dto.generic.GenericDto;

import java.math.BigDecimal;

public class IngredienteDto extends GenericDto {

    private String nome;
    private BigDecimal valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
