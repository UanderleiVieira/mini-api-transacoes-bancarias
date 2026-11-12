package com.uanderleivieira.mini_api_transacoes_bancarias.dto;

import java.math.BigDecimal;

public record ContaResponseDTO(

        Long id,
        String numero,
        BigDecimal saldo,
        Long clienteId,
        String clienteNome
) {
}
