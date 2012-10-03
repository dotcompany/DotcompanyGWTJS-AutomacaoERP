package br.com.automacao.shared.type;

public enum ContratacaoType {

	DEFAULT;
	
	public String getNome(){
		switch (this) {
		case DEFAULT: return "default";
		default: return "default";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}