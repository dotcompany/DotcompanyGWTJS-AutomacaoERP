package br.com.automacao.shared.type;

import java.io.Serializable;

/**
 * Enumerador que define os meios de padronização das letras.
 * 
 * @author Pedro H. Lira
 * @version 1.0
 */
public enum LetraType implements Serializable {

	/**
	 * Campo que define como GRANDE o padrão de letras.
	 */
	GRANDE,
	/**
	 * Campo que define como NORMAL o padrão de letras
	 */
	NORMAL,
	/**
	 * Campo que define como PEQUENA o padrão de letras
	 */
	PEQUENA;
	
	public String getNome(){
		switch (this) {
		case GRANDE: return "Grande";
		case NORMAL: return "Normal";
		default: return "Pequena";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
