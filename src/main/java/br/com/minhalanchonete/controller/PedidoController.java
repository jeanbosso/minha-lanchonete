package br.com.minhalanchonete.controller;

import br.com.minhalanchonete.dto.LancheDto;
import br.com.minhalanchonete.dto.PedidoDto;
import br.com.minhalanchonete.model.Lanche;
import br.com.minhalanchonete.model.Pedido;
import br.com.minhalanchonete.service.LancheService;
import br.com.minhalanchonete.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/findPedido/{identificador}")
    public PedidoDto findPedido(@PathVariable("identificador") Long identificador) {
        return pedidoService.findPedido(identificador);
    }

    @GetMapping("/getAllPedidos")
    public List<PedidoDto> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @PutMapping("/insertPedido")
    public PedidoDto insertPedido(@RequestBody Pedido pedido) {
        return pedidoService.insertPedido(pedido);
    }

    @PutMapping("/updatePedido")
    public PedidoDto updatePedido(@RequestBody Pedido pedido) {
        return pedidoService.updatePedido(pedido);
    }

}
