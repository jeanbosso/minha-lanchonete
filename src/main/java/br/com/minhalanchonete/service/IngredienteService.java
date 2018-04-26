package br.com.minhalanchonete.service;

import br.com.minhalanchonete.dto.IngredienteDto;
import br.com.minhalanchonete.exception.DataAlreadyExistsException;
import br.com.minhalanchonete.exception.DataNotExistsException;
import br.com.minhalanchonete.model.Ingrediente;
import br.com.minhalanchonete.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("ingredienteService")
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public IngredienteDto insertIngrediente(Ingrediente ingrediente) {

        IngredienteDto ingredienteDto = new IngredienteDto();
        try {
            this.ingredienteRepository.insertIngrediente(ingrediente);
        } catch (DataAlreadyExistsException e) {
            ingredienteDto.setHasError(Boolean.TRUE);
            ingredienteDto.setMessage(e.getMessage());
        }

        return ingredienteDto;
    }

    public IngredienteDto updateIngrediente(Ingrediente ingrediente) {

        IngredienteDto ingredienteDto = new IngredienteDto();
        try {
            this.ingredienteRepository.updateIngrediente(ingrediente);
        } catch (DataNotExistsException e) {
            ingredienteDto.setHasError(Boolean.TRUE);
            ingredienteDto.setMessage(e.getMessage());
        }

        return ingredienteDto;
    }

    public IngredienteDto findIngrediente(String nome) {

        IngredienteDto ingredienteDto = new IngredienteDto();
        try {
            Ingrediente ingrediente = ingredienteRepository.findIngredienteByKey(nome);

            ingredienteDto.setNome(ingrediente.getNome());
            ingredienteDto.setValor(ingrediente.getValor());

        } catch (DataNotExistsException e) {
            ingredienteDto.setHasError(Boolean.TRUE);
            ingredienteDto.setMessage(e.getMessage());
        }

        return ingredienteDto;
    }

    public List<IngredienteDto> getAllIngredientes() {

        List<IngredienteDto> ingredientesDto = new ArrayList<>();
        try {
            List<Ingrediente> ingredientes = new ArrayList<>(ingredienteRepository.getAllIngredientes());
            IngredienteDto ingredienteDto;
            for (Ingrediente ingrediente : ingredientes) {
                ingredienteDto = new IngredienteDto();
                ingredienteDto.setNome(ingrediente.getNome());
                ingredienteDto.setValor(ingrediente.getValor());
                ingredientesDto.add(ingredienteDto);
            }

        } catch (DataNotExistsException e) {
            ingredientesDto = Arrays.asList();
        }

        return ingredientesDto;
    }


}
