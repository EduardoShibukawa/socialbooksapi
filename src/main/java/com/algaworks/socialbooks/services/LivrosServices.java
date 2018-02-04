package com.algaworks.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Comentario;
import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.ComentariosRepository;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoxException;

@Service
public class LivrosServices {
	@Autowired
	private LivrosRepository livrosrepository;
	
	@Autowired
	private ComentariosRepository comentariosrepository;
					
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
		if (livro.getId() != null) {
			Livro a = livrosrepository.findOne(livro.getId());
			
			if (a != null) {
				throw new AutorExistenteException("Livro existente!");		
			}			
		}
			
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
	
	public Comentario salvarComentario(Long livroid, Comentario comentario) {
		Livro livro = buscar(livroid);
		
		if (livro == null) {
			throw new LivroNaoEncontradoxException("Livro não encontrado!");
		}
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosrepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(long livroId) {
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();			
	}
}