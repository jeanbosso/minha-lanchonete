package br.com.minhalanchonete.service;

import br.com.minhalanchonete.dto.LancheDto;
import br.com.minhalanchonete.exception.DataAlreadyExistsException;
import br.com.minhalanchonete.exception.DataNotExistsException;
import br.com.minhalanchonete.model.Ingrediente;
import br.com.minhalanchonete.model.Lanche;
import br.com.minhalanchonete.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("lancheService")
public class LancheService {

    private final LancheRepository lancheRepository;

    @Autowired
    public LancheService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public LancheDto insertLanche(Lanche lanche) {

        LancheDto lancheDto = new LancheDto();
        try {
            this.lancheRepository.insertLanche(lanche);
        } catch (DataAlreadyExistsException e) {
            lancheDto.setHasError(Boolean.TRUE);
            lancheDto.setMessage(e.getMessage());
        }

        return lancheDto;
    }

    public LancheDto updateLanche(Lanche lanche) {

        LancheDto lancheDto = new LancheDto();
        try {
            this.lancheRepository.updateLanche(lanche);
        } catch (DataNotExistsException e) {
            lancheDto.setHasError(Boolean.TRUE);
            lancheDto.setMessage(e.getMessage());
        }

        return lancheDto;
    }

    public LancheDto findLanche(String nome) {

        LancheDto lancheDto = new LancheDto();
        try {
            Lanche lanche = lancheRepository.findLancheKey(nome);

            lancheDto.setNome(lanche.getNome());
            lancheDto.setIngredientes(lanche.getIngredientes());

        } catch (DataNotExistsException e) {
            lancheDto.setHasError(Boolean.TRUE);
            lancheDto.setMessage(e.getMessage());
        }

        return lancheDto;
    }

    public List<LancheDto> getAllLanches() {

        List<LancheDto> lancheDtos = new ArrayList<>();
        try {
            List<Lanche> lanches = new ArrayList<>(lancheRepository.getAllLanches());
            LancheDto lancheDto;
            for (Lanche lanche : lanches) {
                lancheDto = new LancheDto();
                lancheDto.setNome(lanche.getNome());
                lancheDto.setIngredientes(lanche.getIngredientes());
                lancheDtos.add(lancheDto);
            }

        } catch (DataNotExistsException e) {
            lancheDtos = Arrays.asList();
        }

        return lancheDtos;
    }

    public BigDecimal calculaValorLanche(Lanche lanche) {
        BigDecimal valorLanche = BigDecimal.ZERO;

        for (Ingrediente ingrediente : lanche.getIngredientes()) {
            valorLanche.add(ingrediente.getValor());
        }

        return valorLanche;
    }


}
