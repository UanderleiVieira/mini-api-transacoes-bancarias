package com.uanderleivieira.mini_api_transacoes_bancarias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contas")
//Conta (Número, Saldo, Status Ativa/Inativa, Relacionamento ManyToOne com Cliente)
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta", nullable = false, unique = true)
    private String numero;

    @Column(name = "saldo_disponivel", nullable = false)
    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_conta", nullable = false)
    private StatusConta status;

    public enum StatusConta {
        ATIVA, INATIVA
    }

}
