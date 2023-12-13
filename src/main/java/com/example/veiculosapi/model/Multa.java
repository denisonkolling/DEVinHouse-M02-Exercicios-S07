package com.example.veiculosapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MULTAS")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String local;

    private String motivo;

    @Override
    public String toString() {
        return "Multa{" +
                "id=" + id +
                ", local='" + local + '\'' +
                ", motivo='" + motivo + '\'' +
                ", valor=" + valor +
                ", veiculo=" + veiculo +
                '}';
    }

    private Float valor;

    @ManyToOne
    @JoinColumn(name = "PLACA", referencedColumnName = "PLACA")
    private Veiculo veiculo;

    public Multa(Veiculo veiculo, String motivo, String local, Float valor) {
        this.veiculo = veiculo;
        this.motivo = motivo;
        this.local = local;
        this.valor = valor;
    }
}
