package com.algaworks.socialbooks.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.LivrosServices;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoxException;

@RestController
@RequestMapping("/livros")
public class LivrosResources {
	@Autowired
	private LivrosServices livrosservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.ok(livrosservice.listar()); 			
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livro = livrosservice.salvar(livro);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}").buildAndExpand(livro.getId())
					.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
		livro.setId(id);
		try {
			livrosservice.atualizar(livro);			
		} catch (LivroNaoEncontradoxException e) {
			return ResponseEntity.notFound().build();
		}		
		
		return ResponseEntity.noContent().build();						
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> buscar(@PathVariable("id") Long id) {
		Livro livro;
		
		try {
			livro =  livrosservice.buscar(id);	
		} catch (LivroNaoEncontradoxException e) {					
			return ResponseEntity.notFound().build();			
		}
			
		return ResponseEntity.ok(livro); 		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		try {
			livrosservice.deletar(id);
		} catch (LivroNaoEncontradoxException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();				
	}	
}