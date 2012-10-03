package br.com.automacao.shared.type;

public enum ContatoType {
	FONE_COMERCIAL,
	FONE_RESIDENCIAL,
	CELULAR,
	FAX,
	EMAIL,
	NEXTEL,
	OUTROS;
	
	public String getNome(){
		switch (this) {
		case FONE_COMERCIAL: return "Telefone Comercial";
		case FONE_RESIDENCIAL: return "Telefone Residencial";
		case CELULAR: return "Celular";
		case FAX: return "Fax";
		case EMAIL: return "Email";
		case NEXTEL: return "Nextel";
		default: return "Outros";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
 
