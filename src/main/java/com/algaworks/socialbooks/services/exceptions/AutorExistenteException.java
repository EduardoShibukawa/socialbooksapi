package com.algaworks.socialbooks.services.exceptions;

public class AutorExistenteException extends EntidadeExistenteException {		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1767749817939741532L;

	public AutorExistenteException(String mensagem) {
		super("Livro", mensagem);		
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		 super("Livro", mensagem, causa);		
	}	
}
