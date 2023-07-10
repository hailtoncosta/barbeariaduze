package com.app.barbeariaduze.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.barbeariaduze.model.Cliente;
import com.app.barbeariaduze.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	// Salvar cliente
	public Cliente salvarUsuario(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	// Listar com paginação
	public Page<Cliente> findPage(int pageNumber) {
		return clienteRepository.findAll(PageRequest.of(pageNumber - 1, 7, Sort.by("nome")));
	}

	// Listar todos os clientes
	public List<Cliente> listarClientes() {
		return (List<Cliente>) clienteRepository.findAll(Sort.by("nome"));
	}

	// Listar cliente por id
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	// Deletar cliente
	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	// Atualizar cliente
	public Cliente atualizarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
