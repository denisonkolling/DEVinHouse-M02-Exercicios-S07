package com.example.veiculosapi;

import com.example.veiculosapi.model.Veiculo;
import com.example.veiculosapi.repository.MultaRepository;
import com.example.veiculosapi.repository.VeiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VeiculosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeiculosApiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(VeiculoRepository veiculoRepo, MultaRepository multaRepo) {
		return args -> {

			List<Veiculo> veiculos = veiculoRepo.findAll();

			for(Veiculo veiculo : veiculos) {
				System.out.println(veiculo.getNome());
			}

		};
	}

}
