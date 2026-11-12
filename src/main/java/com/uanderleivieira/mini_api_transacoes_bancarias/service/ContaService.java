package com.uanderleivieira.mini_api_transacoes_bancarias.service;

import com.uanderleivieira.mini_api_transacoes_bancarias.dto.ContaRequestDTO;
import com.uanderleivieira.mini_api_transacoes_bancarias.dto.ContaResponseDTO;
import com.uanderleivieira.mini_api_transacoes_bancarias.model.Cliente;
import com.uanderleivieira.mini_api_transacoes_bancarias.model.Conta;
import com.uanderleivieira.mini_api_transacoes_bancarias.repository.ClienteRepository;
import com.uanderleivieira.mini_api_transacoes_bancarias.repository.ContaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    @Transactional
    public ContaResponseDTO abrirConta(ContaRequestDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com o ID informado"));

        String numeroConta = gerarNumeroContaUnico();

        Conta conta = new Conta();
        conta.setNumero(numeroConta);
        conta.setSaldo(dto.saldoInicial());
        conta.setCliente(cliente);

        Conta contaSalva = contaRepository.save(conta);

        return new ContaResponseDTO(
                contaSalva.getId(),
                contaSalva.getNumero(),
                contaSalva.getSaldo(),
                cliente.getId(),
                cliente.getNome()
        );

    }

    public String gerarNumeroContaUnico() {
        String numero;
        do {
            numero = String.format("%06d",(int) (Math.random() * 1000000));
        } while (clienteRepository.existsByNumero(numero));

        return numero;
    }
}
