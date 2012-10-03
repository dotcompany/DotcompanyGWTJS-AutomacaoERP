package br.com.automacao.shared.type;

public enum SalarioType {
	
	FIXO;
	
 	public String getNome(){
 		switch (this) {
 		case FIXO: return "Sal�rio Fixo";
 		default: return "0";
 		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
	 
}
 
