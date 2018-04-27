package br.com.minhalanchonete.controller;

import br.com.minhalanchonete.dto.IngredienteDto;
import br.com.minhalanchonete.model.Ingrediente;
import br.com.minhalanchonete.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @RequestMapping("/")
    public String home() {
        return "Hello World !";
    }

    @GetMapping("/findIngrediente/{ingrediente}")
    public IngredienteDto getIngrediente(@PathVariable("ingrediente") String ingrediente) {
        return ingredienteService.findIngrediente(ingrediente);
    }

    @GetMapping("/getAllIngredientes")
    public List<IngredienteDto> getAllIngredientes() {
        return ingredienteService.getAllIngredientes();
    }

    @PutMapping("/insertIngrediente/{nome}/{valor}")
    public IngredienteDto insertIngrediente(@PathVariable("nome") String nome, @PathVariable("valor") BigDecimal valor) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(nome);
        ingrediente.setValor(valor);
        return ingredienteService.insertIngrediente(ingrediente);
    }

    @PutMapping("/updateIngrediente/{nome}/{valor}")
    public IngredienteDto updateIngrediente(@PathVariable("nome") String nome, @PathVariable("valor") BigDecimal valor) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(nome);
        ingrediente.setValor(valor);
        return ingredienteService.updateIngrediente(ingrediente);
    }

}
