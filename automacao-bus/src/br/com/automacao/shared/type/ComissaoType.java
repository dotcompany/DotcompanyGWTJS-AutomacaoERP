package br.com.automacao.shared.type;

public enum ComissaoType {
	PORCENTAGEM,
	REAL;
	
	public String getNome(){
		switch (this) {
		case PORCENTAGEM: return "Porcentagem";
		default: return "Real";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}