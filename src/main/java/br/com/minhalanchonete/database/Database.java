package br.com.minhalanchonete.database;

import br.com.minhalanchonete.model.Ingrediente;
import br.com.minhalanchonete.model.Lanche;
import br.com.minhalanchonete.model.Pedido;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Scope(value = "singleton")
@Component
public class Database {

    private HashMap<String, Ingrediente> ingredientes;
    private HashMap<String, Lanche> lanches;
    private HashMap<Long, Pedido> pedidos;

    public HashMap<Long, Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(HashMap<Long, Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public HashMap<String, Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(HashMap<String, Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public HashMap<String, Lanche> getLanches() {
        return lanches;
    }

    public void setLanches(HashMap<String, Lanche> lanches) {
        this.lanches = lanches;
    }
}
