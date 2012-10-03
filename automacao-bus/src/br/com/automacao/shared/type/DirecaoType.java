package br.com.automacao.shared.type;

import java.io.Serializable;

/**
 * Enumerador que define os meios de ordenação das listagens.
 * 
 * @author Pedro H. Lira
 * @version 1.0
 */
public enum DirecaoType implements Serializable {

	/**
	 * Campo que define como ASC a ordenação.
	 */
	ASC,
	/**
	 * Campo que define como DESC a ordenação.
	 */
	DESC;
	
	public String getNome(){
		switch (this) {
		case ASC: return "acs";
		default: return "desc";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
