package br.com.automacao.shared.type;

public enum EmitirNfType {
	SIM,
	NAO,
	NFE;
	
	public String getNome(){
		switch (this) {
		case SIM: return "Sim";
		case NAO: return "N�o";
		default: return "Nota Fiscal Eletr�nica";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}