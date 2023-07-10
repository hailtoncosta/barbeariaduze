package com.app.barbeariaduze.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.barbeariaduze.model.Usuario;
import com.app.barbeariaduze.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.userFindByLogin(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		
		return usuario;
	}

}
