package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.services.exceptions.EntidadeExistenteException;
import com.algaworks.socialbooks.services.exceptions.EntidadeNaoEncontradoxException;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntidadeNaoEncontradoxException.class)
	public ResponseEntity<DetalhesErro> handleEntidadeNaoEncontradoException(
			EntidadeNaoEncontradoxException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo(String.format("O %s não pôde ser encontrado!", e.getEntidade()));
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);		
	}
	
	@ExceptionHandler(EntidadeExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteException(
			EntidadeExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(409l);
		erro.setTitulo(String.format("%s já existente", e.getEntidade()));
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);		
	}
}
