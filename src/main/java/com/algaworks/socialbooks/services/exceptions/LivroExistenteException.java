package com.algaworks.socialbooks.services.exceptions;

public class LivroExistenteException extends RuntimeException {		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1767749817939741532L;

	public LivroExistenteException(String mensagem) {
		super(mensagem);		
	}
	
	public LivroExistenteException(String mensagem, Throwable causa) {
		 super(mensagem, causa);		
	}	
}
