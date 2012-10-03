package br.com.automacao.shared.type;

public enum FinalidadeType {
 
	CONSUMO, 	 
	VENDA,
	LOCACAO,
	OUTROS;
	
	public String getNome(){
		switch (this) {
 		case CONSUMO: return "Consumo";
 		case VENDA: return "Venda";
 		case LOCACAO: return "Locação";
 		default: return "Outros";
 		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}