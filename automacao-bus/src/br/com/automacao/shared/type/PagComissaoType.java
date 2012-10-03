package br.com.automacao.shared.type;

public enum PagComissaoType {
	PEDIDO,
	BAIXA,
	NAO_LANCAR;
	
	public String getNome(){
		switch (this) {
		case PEDIDO: return "Pedido";
		case BAIXA: return "Baixa";
		default: return "N�o Lancar";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
