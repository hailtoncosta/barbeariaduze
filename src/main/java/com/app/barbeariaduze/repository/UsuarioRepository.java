package com.app.barbeariaduze.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.barbeariaduze.model.Usuario;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.nome = ?1")
	Usuario userFindByLogin(String nome);

	@Query("select u from Usuario u where u.nome like %?1%")
	List<Usuario> buscarUsuarioPorNome(String nome);
	
	default Page<Usuario> findUsuariosByNamePage(String nome, Pageable pageable) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		
		//Estamos configurando a pesquisa para consultar por partes do nome no banco de dados, igual ao Like do SQL
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("nome", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		
		//Une o objeto com o valor e a configuração para consultar
		Example<Usuario> example = Example.of(usuario, exampleMatcher);
		
		Page<Usuario> usuarios = findAll(example, pageable);
		
		return usuarios;
	}
	
}
