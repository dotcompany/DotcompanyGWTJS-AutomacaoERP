package br.com.automacao.shared.type;

public enum EstadoCivilType {
 	CASADO,
	SOLTEIRO;
 	
 	public String getNome(){
 		switch (this) {
 		case CASADO: return "Casado";
 		default: return "Solteiro";
 		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
 
