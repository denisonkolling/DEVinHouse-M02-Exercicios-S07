package com.example.veiculosapi.utils;

import com.example.veiculosapi.model.Multa;
import com.example.veiculosapi.repository.MultaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlteracaoMulta {

    @Autowired
    MultaRepository multaRepository;

    @PostConstruct
    public void alterarMulta() {

        if (multaRepository.findById(3).isEmpty()) {
            return;
        }

        Multa multaDb = multaRepository.findById(3).get();

        multaDb.setValor(380F);

        multaRepository.save(multaDb);
    }
}
