package br.com.automacao.shared.type;

public enum ResideType {
	CASA,
	BARRACAO,
	QUARTO,
	KITNET,
	OUTROS;
 	
 	public String getNome(){
 		switch (this) {
 		case CASA: return "Casa";
 		case BARRACAO: return "Barracão";
 		case QUARTO: return "Quarto";
 		case KITNET: return "Kitnet";
 		default: return "Outros"; }
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}