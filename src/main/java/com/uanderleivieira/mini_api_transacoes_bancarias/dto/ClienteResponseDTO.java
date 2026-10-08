package com.uanderleivieira.mini_api_transacoes_bancarias.dto;

public record ClienteResponseDTO(

        Long id,
        String nome,
        String cpf,
        String email
) {
}
