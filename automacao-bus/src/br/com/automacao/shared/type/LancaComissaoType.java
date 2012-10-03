package br.com.automacao.shared.type;

public enum LancaComissaoType {
	TITULO,
	CT_CORRENTE;
	
	public String getNome(){
		switch (this) {
		case TITULO: return "Titulo";
		default: return "Conta Corrente";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}