package com.algaworks.socialbooks.services.exceptions;

public class LivroExistenteException extends EntidadeExistenteException {		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1767749817939741532L;

	public LivroExistenteException(String mensagem) {
		super("Livro", mensagem);		
	}
	
	public LivroExistenteException(String mensagem, Throwable causa) {
		 super("Livro", mensagem, causa);		
	}	
}
