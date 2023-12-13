package com.example.veiculosapi.repository;

import com.example.veiculosapi.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
