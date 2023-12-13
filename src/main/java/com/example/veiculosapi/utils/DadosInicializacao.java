package com.example.veiculosapi.utils;

import com.example.veiculosapi.model.Multa;
import com.example.veiculosapi.model.Veiculo;
import com.example.veiculosapi.repository.MultaRepository;
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

    @Autowired
    MultaRepository multaRepository;

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

    @PostConstruct
    public void criarMultas () {

        if (multaRepository.findAll().isEmpty()) {

            List<Multa> listaMultas = new ArrayList<>();

            Multa multa01 = new Multa(veiculoRepository.findByPlaca("ABC-1234"), "Farol apagado", "Gothan City", 250F);
            Multa multa02 = new Multa(veiculoRepository.findByPlaca("ABC-1234"), "Insulfilm", "Gothan City", 100F);
            Multa multa03 = new Multa(veiculoRepository.findByPlaca("BCA-4321"), "Excesso velocidade", "Hiper-espaço", 400F);

            listaMultas.add(multa01);
            listaMultas.add(multa02);
            listaMultas.add(multa03);

            for (Multa multa : listaMultas) {
                Multa salvarMulta = multaRepository.save(multa);
            }
        }

    }

}
