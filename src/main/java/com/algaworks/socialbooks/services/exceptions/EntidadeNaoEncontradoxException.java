package com.algaworks.socialbooks.services.exceptions;

public class EntidadeNaoEncontradoxException extends RuntimeException {	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7353911012482767884L;
	
	private String entidade;
	
	public String getEntidade() {
		return entidade;
	}

	public EntidadeNaoEncontradoxException(String entidade, String mensagem) {
		super(mensagem);
		this.entidade = entidade;
	}
	
	public EntidadeNaoEncontradoxException(String entidade, String mensagem, Throwable causa) {
		 super(mensagem, causa);		
		 this.entidade = entidade;
	}	
}
