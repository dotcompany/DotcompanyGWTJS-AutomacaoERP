package br.com.automacao.shared.type;

public enum CriterioType {
	SEM_LIMITE,
	LIMITE_DIARIO;
	
	public String getNome(){
		switch (this) {
 		case SEM_LIMITE: return "Sem limite";
 		default: return "Limite diário";
 		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}