package com.algaworks.socialbooks.services.exceptions;

public class AutorNaoEncontradoxException extends RuntimeException {	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7353911012482767884L;

	public AutorNaoEncontradoxException(String mensagem) {
		super(mensagem);		
	}
	
	public AutorNaoEncontradoxException(String mensagem, Throwable causa) {
		 super(mensagem, causa);		
	}	
}
