package com.app.barbeariaduze.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.barbeariaduze.model.Servico;
import com.app.barbeariaduze.service.ServicoService;


@Controller
public class ServicoController {
	
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/cad_servico/servico")
	public String Servico(Model model) {
		return getOnePage(model, 1);
	}
	
	@GetMapping("/cad_servico/servico/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Servico> page = servicoService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Servico> listarServico = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("listarServico", listarServico);
		
		return "/cad_servico/servico";
	}
	
	@PostMapping("/salvarServico")
	public String salvarServico(Servico servico, Model model) {
		servicoService.salvarServico(servico);
		List<Servico> servicos = servicoService.listarServicos();
		model.addAttribute("listarServico", servicos);
		return getOnePage(model, 1);
	}
	
	public String listarServicos(Model model) {
		List<Servico> servicos = servicoService.listarServicos();
		model.addAttribute("listarServico", servicos);
		return getOnePage(model, 1);
	}
	
	@GetMapping("/buscarservico/")
	@ResponseBody
	public Optional<Servico> buscarServico(Long id) {
		return servicoService.findById(id);
	}
	
	@RequestMapping(value = "/atualizarservico", method = {RequestMethod.PUT, RequestMethod.GET})
	public String atualizarUsuario(Servico servico, Model model) {
		servicoService.atualizarServico(servico);
		List<Servico> servicos = servicoService.listarServicos();
		model.addAttribute("listarServico", servicos);
		return getOnePage(model, 1);
	}
	
	@RequestMapping(value = "/deletarservico/", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deletarServico(Long id, Model model) {
		servicoService.deletarServico(id);
		List<Servico> servicos = servicoService.listarServicos();
		model.addAttribute("listarServico", servicos);
		return getOnePage(model, 1);
	}

}
