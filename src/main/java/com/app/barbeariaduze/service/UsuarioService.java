package com.app.barbeariaduze.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.barbeariaduze.model.Usuario;
import com.app.barbeariaduze.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Salvar usuário
	public void salvarUsuario(Usuario usuario) {
		usuario.encryptPassword();
		usuarioRepository.save(usuario);
	}
	
	//Listar com paginação
	public Page<Usuario> findPage(int pageNumber) {
		return usuarioRepository.findAll(PageRequest.of(pageNumber - 1, 7, Sort.by("nome")));
	}
	
	//Listar usuário por id
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}
	
	//Deletar usuário
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	//Atualizar usuário
	public void atualizarUsuario(Usuario usuario) {
		usuario.encryptPassword();
		usuarioRepository.save(usuario);
	}
	
}
