package com.uanderleivieira.mini_api_transacoes_bancarias.service;

import com.uanderleivieira.mini_api_transacoes_bancarias.dto.ClienteRequestDTO;
import com.uanderleivieira.mini_api_transacoes_bancarias.dto.ClienteResponseDTO;
import com.uanderleivieira.mini_api_transacoes_bancarias.model.Cliente;
import com.uanderleivieira.mini_api_transacoes_bancarias.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public ClienteResponseDTO cadastrar(ClienteRequestDTO dto) {

        if(clienteRepository.existsByCpf(dto.cfp())) {
            //IllegalArgumentException usado por enquanto
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este CPF");
        }

        if(clienteRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este e-mail");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setCpf(dto.cfp());
        cliente.setEmail(dto.email());

        Cliente clienteNovo = clienteRepository.save(cliente);

        return new ClienteResponseDTO(
                clienteNovo.getId(),
                clienteNovo.getNome(),
                clienteNovo.getCpf(),
                clienteNovo.getEmail()
        );
    }
}
