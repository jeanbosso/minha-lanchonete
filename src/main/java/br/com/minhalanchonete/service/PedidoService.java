package br.com.minhalanchonete.service;

import br.com.minhalanchonete.dto.PedidoDto;
import br.com.minhalanchonete.exception.DataAlreadyExistsException;
import br.com.minhalanchonete.exception.DataNotExistsException;
import br.com.minhalanchonete.model.Pedido;
import br.com.minhalanchonete.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("pedidoService")
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoDto insertLanche(Pedido pedido) {

        PedidoDto pedidoDto = new PedidoDto();
        try {
            this.pedidoRepository.insertPedido(pedido);
        } catch (DataAlreadyExistsException e) {
            pedidoDto.setHasError(Boolean.TRUE);
            pedidoDto.setMessage(e.getMessage());
        }

        return pedidoDto;
    }

    public PedidoDto updatePedido(Pedido pedido) {

        PedidoDto pedidoDto = new PedidoDto();
        try {
            this.pedidoRepository.updatePedido(pedido);
        } catch (DataNotExistsException e) {
            pedidoDto.setHasError(Boolean.TRUE);
            pedidoDto.setMessage(e.getMessage());
        }

        return pedidoDto;
    }

    public PedidoDto findPedido(Long identificador) {

        PedidoDto pedidoDto = new PedidoDto();
        try {
            Pedido pedido = pedidoRepository.findPedidoByKey(identificador);

            pedidoDto.setIdentificador(pedido.getIdentificador());
            pedidoDto.setLanches(pedido.getLanches());
            pedidoDto.setSolicitante(pedido.getSolicitante());
            pedidoDto.setValorTotal(pedido.getValorTotal());

        } catch (DataNotExistsException e) {
            pedidoDto.setHasError(Boolean.TRUE);
            pedidoDto.setMessage(e.getMessage());
        }

        return pedidoDto;
    }

    public List<PedidoDto> getAllPedidos() {

        List<PedidoDto> pedidoDtos = new ArrayList<>();
        try {
            List<Pedido> pedidos = new ArrayList<>(pedidoRepository.getAllPedidos());
            PedidoDto pedidoDto;
            for (Pedido pedido : pedidos) {
                pedidoDto = new PedidoDto();
                pedidoDto.setIdentificador(pedido.getIdentificador());
                pedidoDto.setLanches(pedido.getLanches());
                pedidoDto.setSolicitante(pedido.getSolicitante());
                pedidoDto.setValorTotal(pedido.getValorTotal());
                pedidoDtos.add(pedidoDto);
            }

        } catch (DataNotExistsException e) {
            pedidoDtos = Arrays.asList();
        }

        return pedidoDtos;
    }


}
