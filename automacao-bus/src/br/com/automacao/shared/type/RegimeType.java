package br.com.automacao.shared.type;

public enum RegimeType {
	LUCRO_REAL,
	LUCRO_PRESUMIDO,
	SIMPLES_NACIONAL;
	
 	public String getNome(){
 		switch (this) {
 		case LUCRO_REAL: return "Lucro Real";
 		case LUCRO_PRESUMIDO: return "Lucro Presumido";
 		default: return "Simples Nacional"; }
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
 
