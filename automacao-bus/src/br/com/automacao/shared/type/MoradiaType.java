package br.com.automacao.shared.type;

public enum MoradiaType {
	PROPRIA,
	ALUGADA,
	CEDIDA,
	OUTROS;
	
	public String getNome(){
		switch (this) {
		case PROPRIA: return "Própria";
		case ALUGADA: return "Alugada";
		case CEDIDA: return "Cedida";
		default: return "Outros";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}