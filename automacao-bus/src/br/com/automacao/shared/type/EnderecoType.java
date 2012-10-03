package br.com.automacao.shared.type;

public enum EnderecoType {
	COBRANCA,
	RESIDENCIAL,
	COMERCIAL,
	ENTREGA;
	
	public String getNome(){
		switch (this) {
		case COBRANCA: return "Cobrança";
		case RESIDENCIAL: return "Residencial";
		case COMERCIAL: return "Comercial";
		default: return "Entrega";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}