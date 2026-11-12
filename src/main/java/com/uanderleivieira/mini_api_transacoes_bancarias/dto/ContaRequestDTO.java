package com.uanderleivieira.mini_api_transacoes_bancarias.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ContaRequestDTO(

        @NotNull(message = "O ID do cliente é obrigatório")
        Long clienteId,

        @NotNull(message = "O saldo inicial é obrigatório")
        @PositiveOrZero(message = "O saldo inicial não pode ser nagativo")
        BigDecimal saldoInicial


) {
}
