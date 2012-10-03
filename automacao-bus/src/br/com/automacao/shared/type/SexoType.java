package br.com.automacao.shared.type;

public enum SexoType {
 	MASCULINO,
	FEMININO;
 	
 	public String getNome(){
 		switch (this) {
 		case MASCULINO: return "Masculino";
 		default: return "Feminino";
 		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
 
