package br.com.minhalanchonete.repository;

import br.com.minhalanchonete.database.Database;
import br.com.minhalanchonete.exception.DataAlreadyExistsException;
import br.com.minhalanchonete.exception.DataNotExistsException;
import br.com.minhalanchonete.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class PedidoRepository {

    private final Database database;

    @Autowired
    public PedidoRepository(Database database) {
        this.database = database;
    }


    public void insertPedido(Pedido pedido) throws DataAlreadyExistsException {

        if (database.getPedidos().containsKey(pedido.getIdentificador())) {
            throw new DataAlreadyExistsException("Esse pedido já existe e não pode ser cadastrado " +
                    "novamente.");
        }

        database.getPedidos().put(pedido.getIdentificador(), pedido);
    }

    public void updatePedido(Pedido pedido) throws DataNotExistsException {

        if (!database.getIngredientes().containsKey(pedido.getIdentificador())) {
            throw new DataNotExistsException("Esse pedido não existe e não pode ser atualizado");
        }

        database.getPedidos().put(pedido.getIdentificador(), pedido);

    }

    public Pedido findPedidoByKey(Long pedidoKey) throws DataNotExistsException {
        return database.getPedidos().get(pedidoKey);
    }

    public Collection<Pedido> getAllPedidos() throws DataNotExistsException {
        return database.getPedidos().values();
    }


}
