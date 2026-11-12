package com.uanderleivieira.mini_api_transacoes_bancarias.controller;

import com.uanderleivieira.mini_api_transacoes_bancarias.dto.ContaRequestDTO;
import com.uanderleivieira.mini_api_transacoes_bancarias.dto.ContaResponseDTO;
import com.uanderleivieira.mini_api_transacoes_bancarias.service.ContaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    public ResponseEntity<ContaResponseDTO> abrirConta(
            @RequestBody @Valid ContaRequestDTO dto,
            UriComponentsBuilder uriBuilder) {

        ContaResponseDTO contaCriada = contaService.abrirConta(dto);

        URI uri = uriBuilder.path("/api/v1/contas/{id}")
                .buildAndExpand(contaCriada.id())
                .toUri();

        return ResponseEntity.created(uri).body(contaCriada);
    }
}
