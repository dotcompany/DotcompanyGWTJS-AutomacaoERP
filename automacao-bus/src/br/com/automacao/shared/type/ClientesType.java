package br.com.automacao.shared.type;

public enum ClientesType {	
    F, J;
	
	public String getNome(){
		switch (this){
			case F: return "Fisica";
			default: return "Juridica";
		}
	}

}
