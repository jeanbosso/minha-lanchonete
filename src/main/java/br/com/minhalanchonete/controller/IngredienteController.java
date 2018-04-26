package br.com.minhalanchonete.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredienteController {

    @RequestMapping("/")
    public String home() {
        return "Hello World !";
    }
}
