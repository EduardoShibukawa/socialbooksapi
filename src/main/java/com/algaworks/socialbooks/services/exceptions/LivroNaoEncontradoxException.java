package com.algaworks.socialbooks.services.exceptions;

public class LivroNaoEncontradoxException extends EntidadeNaoEncontradoxException {	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7353911012482767884L;

	public LivroNaoEncontradoxException(String mensagem) {
		super("Livro", mensagem);		
	}
	
	public LivroNaoEncontradoxException(String mensagem, Throwable causa) {
		 super("Livro", mensagem, causa);		
	}	
}
