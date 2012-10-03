package br.com.automacao.shared.type;

public enum EstadosBrType {

	AC,	AL,	AP,	AM,	BA,	CE,	DF,	ES,	GO,	MA,
	MT,	MS,	MG,	PA,	PB,	PR,	PE,	PI,	RJ,	RN,
	RS,	RO,	RR,	SC,	SP,	SE,	TO;
	
	public String getNome(){
		return this.name();
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}