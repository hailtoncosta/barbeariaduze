package com.app.barbeariaduze.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.barbeariaduze.model.Agendamento;
import com.app.barbeariaduze.model.Cliente;
import com.app.barbeariaduze.model.Servico;
import com.app.barbeariaduze.repository.AgendamentoRepository;
import com.app.barbeariaduze.repository.ClienteRepository;
import com.app.barbeariaduze.repository.ServicoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	// Salvar agendamento
	public Agendamento salvarAgendamento(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}

	// Listar com paginação
	public Page<Agendamento> findPage(int pageNumber) {
		return agendamentoRepository.findAll(PageRequest.of(pageNumber - 1, 7, Sort.by("clientes")));
	}

	// Listar todos os agendamentos
	public List<Agendamento> listarAgendamentos() {
		return (List<Agendamento>) agendamentoRepository.findAll();
	}

	// Listar todos os serviços
	public List<Servico> listarServicos() {
		return (List<Servico>) servicoRepository.findAll();
	}

	// Listar todos os clientes
	public List<Cliente> listarClientes() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	// Listar agendamento por id
	public Optional<Agendamento> findById(Long id) {
		return agendamentoRepository.findById(id);
	}

	// Deletar agendamento
	public void deletarAgendamento(Long id) {
		agendamentoRepository.deleteById(id);
	}

	// Atualizar agendamento
	public void atualizarAgendamento(Agendamento agendamento) {
		agendamentoRepository.save(agendamento);
	}

}
