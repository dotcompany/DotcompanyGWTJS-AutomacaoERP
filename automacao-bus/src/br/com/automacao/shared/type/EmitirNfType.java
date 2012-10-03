package br.com.automacao.shared.type;

public enum EmitirNfType {
	SIM,
	NAO,
	NFE;
	
	public String getNome(){
		switch (this) {
		case SIM: return "Sim";
		case NAO: return "Não";
		default: return "Nota Fiscal Eletrônica";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}