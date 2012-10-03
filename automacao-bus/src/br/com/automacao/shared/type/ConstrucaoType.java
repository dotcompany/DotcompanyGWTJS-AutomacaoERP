package br.com.automacao.shared.type;

public enum ConstrucaoType {
	ALVENARIA,
	PLACAS,
	OUTROS;
	
	public String getNome(){
		switch (this) {
		case ALVENARIA: return "Alvenaria";
		case PLACAS: return "Placas";
		default: return "Outros";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}