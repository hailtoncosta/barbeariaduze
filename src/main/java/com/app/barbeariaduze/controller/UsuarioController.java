package com.app.barbeariaduze.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.barbeariaduze.model.Usuario;
import com.app.barbeariaduze.repository.UsuarioRepository;
import com.app.barbeariaduze.service.UsuarioService;


@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/index")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/cad_usuario/usuario")
	public String getAllPages(Model model) {
		return getOnePage(model, 1);
	}
	
	@GetMapping("/cad_usuario/usuario/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Usuario> page = usuarioService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Usuario> listarUsuario = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("listarUsuario", listarUsuario);
		
		return "/cad_usuario/usuario";
	}
	
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(Usuario usuario, Model model, Pageable pageable) {
		usuarioService.salvarUsuario(usuario);
		return getOnePage(model, 1);
	}
	
	@GetMapping("/buscarusuario/")
	@ResponseBody
	public Optional<Usuario> buscarUsuario(Long id) {
		return usuarioService.findById(id);
	}
	
	@RequestMapping(value = "/atualizarusuario", method = {RequestMethod.PUT, RequestMethod.GET})
	public String atualizarUsuario(Usuario usuario, Model model) {
		usuarioService.atualizarUsuario(usuario);
		return getOnePage(model, 1);
	}
	
	@RequestMapping(value = "/deletarusuario/", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deletarUsuario(Long id, Model model) {
		usuarioService.deletarUsuario(id);
		return getOnePage(model, 1);
	}
	
	@PostMapping("/pesquisarusuario")
	public String pesquisarConsulta(@RequestParam("usuariopesquisa") String usuariopesquisa, 
			@PageableDefault(size=7, sort= {"nome"}) Pageable pageable, Model model) {
		
		Page<Usuario> listarUsuario = null;
		
		listarUsuario = usuarioRepository.findUsuariosByNamePage(usuariopesquisa, pageable);
		
		model.addAttribute("listarUsuario", listarUsuario);
		model.addAttribute("usuariopesquisa", usuariopesquisa);
		
		return getOnePage(model, 1);
	}

	
	
}
