package br.com.dotcompany.exception;

import org.springframework.dao.DataAccessException;

/**
 * <b>Projeto:</b> entity <br>
 * <b>Pacote:</b> br.com.entity.exception <br>
 * <b>Título:</b> DaoException.java <br>
 * <b>Descrição:</b> <br>
 * 
 * <b>Autor:</b> danylomacelai
 * <b>Email:</b> danylomacelai@gmail.com
 * <b>Criação:</b> 23/01/2011, 15:59:56
 */
@SuppressWarnings("serial")
public class DaoException extends DataAccessException {

	/**
	 * Construtor da classe DaoException.java
	 * @param msg - {@link String}
	 */
	public DaoException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor da classe DaoException.java
	 * @param msg - {@link String}
	 * @param ex - {@link Exception}
	 */
	public DaoException(String msg, Exception ex) {
		super(msg, ex);
	}
}