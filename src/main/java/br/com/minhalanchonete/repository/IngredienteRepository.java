package br.com.minhalanchonete.repository;

import br.com.minhalanchonete.database.Database;
import br.com.minhalanchonete.exception.DataAlreadyExistsException;
import br.com.minhalanchonete.exception.DataNotExistsException;
import br.com.minhalanchonete.model.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class IngredienteRepository {

    private final Database database;


    @Autowired
    public IngredienteRepository(Database database) {
        this.database = database;
    }


    public void insertIngrediente(Ingrediente ingrediente) throws DataAlreadyExistsException {

        if (database.getIngredientes().containsKey(ingrediente.getNome())) {
            throw new DataAlreadyExistsException("Esse ingrediente já existe e não pode ser cadastrado " +
                    "novamente.");
        }

        database.getIngredientes().put(ingrediente.getNome(), ingrediente);
    }

    public void updateIngrediente(Ingrediente ingrediente) throws DataNotExistsException {


        if (!database.getIngredientes().containsKey(ingrediente.getNome())) {
            throw new DataNotExistsException("Esse ingrediente já existe e não pode ser cadastrado " +
                    "novamente.");
        }

        database.getIngredientes().put(ingrediente.getNome(), ingrediente);

    }

    public Ingrediente findIngredienteByKey(String ingredienteKey) throws DataNotExistsException {
        return database.getIngredientes().get(ingredienteKey);
    }

    public Collection<Ingrediente> getAllIngredientes() throws DataNotExistsException {
        return database.getIngredientes().values();
    }

}
