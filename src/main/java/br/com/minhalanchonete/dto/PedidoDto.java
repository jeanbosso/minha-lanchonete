package br.com.minhalanchonete.dto;

import br.com.minhalanchonete.dto.generic.GenericDto;
import br.com.minhalanchonete.model.Lanche;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDto extends GenericDto {

    private Long identificador;
    private String solicitante;
    private BigDecimal valorTotal;
    private List<Lanche> lanches;

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Lanche> getLanches() {
        return lanches;
    }

    public void setLanches(List<Lanche> lanches) {
        this.lanches = lanches;
    }
}
