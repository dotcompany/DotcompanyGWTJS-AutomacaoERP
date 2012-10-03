package br.com.dotcompany.exception;

import org.springframework.dao.DataAccessException;

@SuppressWarnings("serial")
public class NegocioException extends DataAccessException{

	public NegocioException(String msg) {
		super(msg);
	}

}