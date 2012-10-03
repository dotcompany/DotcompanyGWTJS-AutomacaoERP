package br.com.automacao.shared.type;

public enum MateriaPrimaType {
	SIM,
	NAO;
	
	public String getNome(){
		switch (this) {
 		case SIM: return "Sim";
 		default: return "N�o";
 		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}