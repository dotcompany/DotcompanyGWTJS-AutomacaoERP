package br.com.automacao.shared.type;

public enum AguaType {
	ENCANADA,
	POCO;
	
	public String getNome(){
		switch (this) {
		case ENCANADA: return "Encanada";
		default: return "Po�o";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}