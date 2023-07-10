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

import com.app.barbeariaduze.model.Agendamento;
import com.app.barbeariaduze.model.Cliente;
import com.app.barbeariaduze.model.Servico;
import com.app.barbeariaduze.service.AgendamentoService;
import com.app.barbeariaduze.service.ClienteService;
import com.app.barbeariaduze.service.ServicoService;


@Controller
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/cad_agendamento/agendamento")
	public String getAllPages(Model model) {
		return getOnePage(model, 1);
	}
	
	@GetMapping("/cad_agendamento/agendamento/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		List<Servico> servicos = servicoService.listarServicos();
		model.addAttribute("listarServico", servicos);
		
		List<Cliente> clientes = clienteService.listarClientes();
		model.addAttribute("listarCliente", clientes);
		
		Page<Agendamento> page = agendamentoService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Agendamento> listarAgendamento = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("listarAgendamento", listarAgendamento);
		
		return "/cad_agendamento/agendamento";
	}
	
	@PostMapping("/salvarAgendamento")
	public String salvarAgendamento(Agendamento agendamento, Model model) {
		agendamentoService.salvarAgendamento(agendamento);
		List<Agendamento> agendamentos = agendamentoService.listarAgendamentos();
		model.addAttribute("listarAgendamento", agendamentos);
		
		List<Servico> servicos = servicoService.listarServicos();
		model.addAttribute("listarServico", servicos);
		
		List<Cliente> clientes = clienteService.listarClientes();
		model.addAttribute("listarCliente", clientes);
		
		return getOnePage(model, 1);
	}
	
	public String listarAgendamentos(Model model) {
		List<Agendamento> agendamentos = agendamentoService.listarAgendamentos();
		model.addAttribute("listarAgendamento", agendamentos);
		return "/cad_agendamento/agendamento";
	}
	
	@GetMapping("/buscaragendamento/")
	@ResponseBody
	public Optional<Agendamento> buscarAgendamento(Long id) {
		return agendamentoService.findById(id);
	}
	
	@RequestMapping(value = "/atualizaragendamento", method = {RequestMethod.PUT, RequestMethod.GET})
	public String atualizarAgendamento(Agendamento agendamento, Model model) {
		agendamentoService.atualizarAgendamento(agendamento);
		List<Agendamento> agendamentos = agendamentoService.listarAgendamentos();
		model.addAttribute("listarAgendamento", agendamentos);
		
		List<Servico> servicos = servicoService.listarServicos();
		model.addAttribute("listarServico", servicos);
		
		List<Cliente> clientes = clienteService.listarClientes();
		model.addAttribute("listarCliente", clientes);
		
		return getOnePage(model, 1);
	}
	
	@RequestMapping(value = "/deletaragendamento/", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deletarAgendamento(Long id, Model model) {
		agendamentoService.deletarAgendamento(id);
		List<Agendamento> agendamentos = agendamentoService.listarAgendamentos();
		model.addAttribute("listarAgendamento", agendamentos);
		
		List<Servico> servicos = servicoService.listarServicos();
		model.addAttribute("listarServico", servicos);
		
		List<Cliente> clientes = clienteService.listarClientes();
		model.addAttribute("listarCliente", clientes);
		
		return getOnePage(model, 1);
	}

}
