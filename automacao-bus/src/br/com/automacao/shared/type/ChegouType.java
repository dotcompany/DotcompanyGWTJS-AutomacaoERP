package br.com.automacao.shared.type;

public enum ChegouType {
	INTERNET,GOOGLE,SUPERDOWNLOADS,BAIXAKI,
	MERCADO_LIVRE,AMIGO,EMPRESA,RADIO,TELEVISAO,OUTROS;
	
	public String getNome(){
		switch (this) {
		case INTERNET: return "Internet";
		case GOOGLE: return "Google";
		case SUPERDOWNLOADS: return "SuperDownloads";
		case BAIXAKI: return "Baixaki";
		case MERCADO_LIVRE: return "Mercado Livre";
		case AMIGO: return "Amigo";
		case EMPRESA: return "Empresa";
		case RADIO: return "Radio";
		case TELEVISAO: return "Televisão";
		default: return "Outros";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}