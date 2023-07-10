package com.app.barbeariaduze.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.barbeariaduze.model.Servico;
import com.app.barbeariaduze.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	// Salvar serviço
	public Servico salvarServico(Servico servico) {
		return servicoRepository.save(servico);
	}

	// Listar com paginação
	public Page<Servico> findPage(int pageNumber) {
		return servicoRepository.findAll(PageRequest.of(pageNumber - 1, 7, Sort.by("descricao")));
	}

	// Listar todos os serviços
	public List<Servico> listarServicos() {
		return (List<Servico>) servicoRepository.findAll(Sort.by("descricao"));
	}

	// Listar serviço por id
	public Optional<Servico> findById(Long id) {
		return servicoRepository.findById(id);
	}

	// Deletar serviço
	public void deletarServico(Long id) {
		servicoRepository.deleteById(id);
	}

	// Atualizar serviço
	public void atualizarServico(Servico servico) {
		servicoRepository.save(servico);
	}

}
