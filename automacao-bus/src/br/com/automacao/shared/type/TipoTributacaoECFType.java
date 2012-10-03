package br.com.automacao.shared.type;

public enum TipoTributacaoECFType {

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