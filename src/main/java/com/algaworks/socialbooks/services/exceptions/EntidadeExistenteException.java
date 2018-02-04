package com.algaworks.socialbooks.services.exceptions;

public class EntidadeExistenteException extends RuntimeException {		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1767749817939741532L;
	
	private String entidade;
	
	public String getEntidade() {
		return entidade;
	}

	public EntidadeExistenteException(String entidade, String mensagem) {
		super(mensagem);
		this.entidade = entidade;				
	}
	
	public EntidadeExistenteException(String entidade, String mensagem, Throwable causa) {
		super(mensagem, causa);
		this.entidade = entidade;			
	}	
}
