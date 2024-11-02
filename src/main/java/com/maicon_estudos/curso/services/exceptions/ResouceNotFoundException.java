package com.maicon_estudos.curso.services.exceptions;

public class ResouceNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ResouceNotFoundException(Object id) {
		super("Recurso não Encontrado. id= " + id);
	}
}
