package com.uanderleivieira.mini_api_transacoes_bancarias.controller;

import com.uanderleivieira.mini_api_transacoes_bancarias.dto.ClienteRequestDTO;
import com.uanderleivieira.mini_api_transacoes_bancarias.dto.ClienteResponseDTO;
import com.uanderleivieira.mini_api_transacoes_bancarias.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrar(
            @RequestBody @Valid ClienteRequestDTO dto, UriComponentsBuilder uriBilder) {

        ClienteResponseDTO clienteCadastrado = clienteService.cadastrar(dto);

        URI uri = uriBilder.path("/api/v1/clientes/{id}")
                .buildAndExpand(clienteCadastrado.id())
                .toUri();

        return ResponseEntity.created(uri).body(clienteCadastrado);
    }
}
