package br.com.automacao.shared.type;

public enum ModeType {
	EDIT, NEW;
	
	public String getNome(){
		switch (this) {
		case EDIT: return "Edit";
		default: return "new";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}