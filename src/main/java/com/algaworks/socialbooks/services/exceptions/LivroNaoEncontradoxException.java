package com.algaworks.socialbooks.services.exceptions;

public class LivroNaoEncontradoxException extends RuntimeException {	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7353911012482767884L;

	public LivroNaoEncontradoxException(String mensagem) {
		super(mensagem);		
	}
	
	public LivroNaoEncontradoxException(String mensagem, Throwable causa) {
		 super(mensagem, causa);		
	}	
}
