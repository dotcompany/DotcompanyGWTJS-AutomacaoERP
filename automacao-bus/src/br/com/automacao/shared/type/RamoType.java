package br.com.automacao.shared.type;

public enum RamoType {
	
	R1;
	
	public String getNome(){
 		return "R1";
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
	
}