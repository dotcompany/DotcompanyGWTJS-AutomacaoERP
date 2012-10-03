package br.com.automacao.shared.type;

public enum AguaType {
	ENCANADA,
	POCO;
	
	public String getNome(){
		switch (this) {
		case ENCANADA: return "Encanada";
		default: return "Poço";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}