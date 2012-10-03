package br.com.automacao.shared.type;

public enum SangueType {
	A_NEGATIVO,A_POSITIVO,
	B_NEGATIVO,B_POSITIVO,
	AB_NEGATIVO,AB_POSITIVO,
	O_NEGATIVO,O_POSITIVO;
	
	public String getNome(){
		switch (this) {
		case A_POSITIVO: return "A+";
		case A_NEGATIVO: return "A-";
		case B_POSITIVO: return "B+";
		case B_NEGATIVO: return "B-";
		case AB_POSITIVO: return "AB+";
		case AB_NEGATIVO: return "AB-";
		case O_POSITIVO: return "O+";
		case O_NEGATIVO: return "O-";
		default: return "A-";
		}
 	}
	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}