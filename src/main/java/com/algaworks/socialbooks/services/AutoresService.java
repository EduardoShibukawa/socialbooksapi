package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutoresRepository;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoxException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresrepository;
	
	public List<Autor> listar() {
		return autoresrepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			Autor a = autoresrepository.findOne(autor.getId());
			
			if (a != null) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		
		return autoresrepository.save(autor);
	}

	public Autor buscar(Long id) {
		Autor autor = autoresrepository.findOne(id);
		
		if (autor == null) {
			throw new AutorNaoEncontradoxException("Autor não encontrado!");
		}
					
		return autor;
	}
	
	public void atualizar(Autor autor) {
		verificarExistencia(autor.getId());
		autoresrepository.save(autor);			
	}
	
	public void verificarExistencia(Long id) {
		buscar(id);
	}
	
}
