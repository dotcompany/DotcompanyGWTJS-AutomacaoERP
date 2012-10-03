package br.com.automacao.server.core;

public class LoaderException extends RuntimeException {
	private static final long serialVersionUID = -3447166742990415155L;
	
	public LoaderException(){
		super("Incapaz de carregar os dados");
	}
	
	public LoaderException(String message) {
		super(message);
	}
	
	public LoaderException(String message, Throwable cause) {
		super(message, cause);
	}
}