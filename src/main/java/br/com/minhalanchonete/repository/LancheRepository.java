package br.com.minhalanchonete.repository;

import br.com.minhalanchonete.database.Database;
import br.com.minhalanchonete.exception.DataAlreadyExistsException;
import br.com.minhalanchonete.exception.DataNotExistsException;
import br.com.minhalanchonete.model.Lanche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class LancheRepository {

    private final Database database;

    @Autowired
    public LancheRepository(Database database) {
        this.database = database;
    }


    public void insertLanche(Lanche lanche) throws DataAlreadyExistsException {

        if (database.getLanches().containsKey(lanche.getNome())) {
            throw new DataAlreadyExistsException("Esse lanche já existe e não pode ser cadastrado " +
                    "novamente.");
        }

        database.getLanches().put(lanche.getNome(), lanche);
    }

    public void updateLanche(Lanche lanche) throws DataNotExistsException {


        if (!database.getIngredientes().containsKey(lanche.getNome())) {
            throw new DataNotExistsException("Esse lanche já existe e não pode ser cadastrado " +
                    "novamente.");
        }

        database.getLanches().put(lanche.getNome(), lanche);

    }

    public Lanche findLancheKey(String lancheKey) throws DataNotExistsException {
        return database.getLanches().get(lancheKey);
    }

    public Collection<Lanche> getAllLanches(String lancheKey) throws DataNotExistsException {
        return database.getLanches().values();
    }


}
