package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoxException;

@Service
public class LivrosServices {
	@Autowired
	private LivrosRepository livrosrepository;
			
	public List<Livro> listar(){
		return livrosrepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livrosrepository.findOne(id);
		
		if (livro == null){
			throw new LivroNaoEncontradoxException("O livro não pôde ser encontrado!");			
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);		
		return livrosrepository.save(livro);	
	}
	
	public void deletar(Long id) {
		try {
			livrosrepository.delete(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoxException("O livro não pôde ser encontrado!");  
		}
		
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro.getId());
		livrosrepository.save(livro);			
	}
	
	public void verificarExistencia(Long id) {
		buscar(id);
	}
}
