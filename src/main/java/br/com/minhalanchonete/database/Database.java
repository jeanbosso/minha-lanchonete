package br.com.minhalanchonete.database;

import br.com.minhalanchonete.model.Ingrediente;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Scope(value = "singleton")
@Component
public class Database {

    private HashMap<String, Ingrediente> ingredientes;
    private HashMap<String, List<Ingrediente>> lanches;


    public HashMap<String, Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(HashMap<String, Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public HashMap<String, List<Ingrediente>> getLanches() {
        return lanches;
    }

    public void setLanches(HashMap<String, List<Ingrediente>> lanches) {
        this.lanches = lanches;
    }
}
