package br.com.automacao.shared.type;

public enum MateriaPrimaType {
	SIM,
	NAO;
	
	public String getNome(){
		switch (this) {
 		case SIM: return "Sim";
 		default: return "Não";
 		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}