package com.example.veiculosapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VEICULOS")
public class Veiculo {

    @Id
    private String placa;

    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;

    private String nome;

    private Integer anoFabricacao;

    private String cor;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "veiculo")
    private List<Multa> multas;


    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", tipo=" + tipo +
                ", nome='" + nome + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", cor='" + cor + '\'' +
                ", multas=" + multas +
                '}';
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }

}
