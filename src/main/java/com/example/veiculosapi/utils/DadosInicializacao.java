package com.example.veiculosapi.utils;

import com.example.veiculosapi.model.Veiculo;
import com.example.veiculosapi.repository.VeiculoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.veiculosapi.model.TipoVeiculo.AUTOMOVEL;
import static com.example.veiculosapi.model.TipoVeiculo.ONIBUS;

@Component
public class DadosInicializacao {

    @Autowired
    VeiculoRepository veiculoRepository;

    @PostConstruct
    public void criarVeiculos() {

        if (veiculoRepository.findAll().isEmpty()) {

            List<Veiculo> listaVeiculos = new ArrayList<>();

            Veiculo veiculo01 = new Veiculo("ABC-1234", AUTOMOVEL, "Bat-Movel", 2022, "Preto", null);
            Veiculo veiculo02 = new Veiculo("BCA-4321", ONIBUS, "Enterprise", 1960, "Prata", null);

            listaVeiculos.add(veiculo01);
            listaVeiculos.add(veiculo02);

            for (Veiculo veiculo : listaVeiculos) {
                Veiculo salvarVeiculo = veiculoRepository.save(veiculo);
            }
        }

    }
}
