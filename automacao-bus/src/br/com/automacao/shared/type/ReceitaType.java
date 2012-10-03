package br.com.automacao.shared.type;

public enum ReceitaType {
	SIMPLES_NACIONAL,
	RECEITA_BRUTA;
	
	public String getNome(){
 		switch (this) {
 		case SIMPLES_NACIONAL: return "Simples Nacional";
 		default: return "Receita Bruta"; }
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
 
