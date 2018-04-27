package br.com.minhalanchonete.controller;

import br.com.minhalanchonete.dto.IngredienteDto;
import br.com.minhalanchonete.dto.LancheDto;
import br.com.minhalanchonete.model.Ingrediente;
import br.com.minhalanchonete.model.Lanche;
import br.com.minhalanchonete.service.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LancheController {

    @Autowired
    private LancheService lancheService;

    @GetMapping("/findLanche/{lanche}")
    public LancheDto findLanche(@PathVariable("lanche") String lanche) {
        return lancheService.findLanche(lanche);
    }

    @GetMapping("/getAllLanches")
    public List<LancheDto> getAllLanches() {
        return lancheService.getAllLanches();
    }

    @PutMapping("/insertLanche")
    public LancheDto insertLanche(@RequestBody Lanche lanche) {
        return lancheService.insertLanche(lanche);
    }

    @PutMapping("/updateLanche")
    public LancheDto updateLanche(@RequestBody Lanche lanche) {
        return lancheService.updateLanche(lanche);
    }

}
