package com.app.barbeariaduze.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.barbeariaduze.model.Cliente;
import com.app.barbeariaduze.service.ClienteService;


@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cad_cliente/cliente")
	public String getAllPages(Model model) {
		return getOnePage(model, 1);
	}
	
	@GetMapping("/cad_cliente/cliente/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Cliente> page = clienteService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Cliente> listarCliente = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("listarCliente", listarCliente);
		
		return "/cad_cliente/cliente";
	}
	
	@PostMapping("/salvarCliente")
	public String salvarCliente(Cliente cliente, Model model, Pageable pageable) {
		clienteService.salvarUsuario(cliente);
		return getOnePage(model, 1);
	}
	
	public String listarClientes(Model model) {
		List<Cliente> clientes = clienteService.listarClientes();
		model.addAttribute("listarCliente", clientes);
		return "/cad_cliente/cliente";
	}
	
	@GetMapping("/buscarcliente/")
	@ResponseBody
	public Optional<Cliente> buscarCliente(Long id) {
		return clienteService.findById(id);
	}
	
	@RequestMapping(value = "/atualizarcliente", method = {RequestMethod.PUT, RequestMethod.GET})
	public String atualizarUsuario(Cliente cliente, Model model) {
		clienteService.atualizarCliente(cliente);
		List<Cliente> clientes = clienteService.listarClientes();
		model.addAttribute("listarCliente", clientes);
		return getOnePage(model, 1);
	}
	
	@RequestMapping(value = "/deletarcliente/", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deletarUsuario(Long id, Model model) {
		clienteService.deletarCliente(id);
		List<Cliente> clientes = clienteService.listarClientes();
		model.addAttribute("listarCliente", clientes);
		return getOnePage(model, 1);
	}

}
