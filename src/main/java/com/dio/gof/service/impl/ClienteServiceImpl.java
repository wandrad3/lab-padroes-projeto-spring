package com.dio.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.gof.model.Cliente;
import com.dio.gof.model.ClienteRepository;
import com.dio.gof.model.Endereco;
import com.dio.gof.model.EnderecoRepository;
import com.dio.gof.service.ClienteService;
import com.dio.gof.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService{

	//Singleton: injetar os componentes do Spring com @Autowired
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService cepService;
	
	//Stragegy: Implementar os métodos definidos na interface;
	//Facade: Abstrair integrações com subsistemas, provendo uma interface simples
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id).get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarlienteComCep(cliente);
		
	}

	

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarlienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
	
	private void salvarlienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = cepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
