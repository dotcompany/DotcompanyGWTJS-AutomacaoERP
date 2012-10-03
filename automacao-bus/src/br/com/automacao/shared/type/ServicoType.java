package br.com.automacao.shared.type;

/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.comun <br>
 * <b>T�tulo:</b> ContatoType.java <br>
 * <b>Descri��o:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Cria��o:</b> 25/08/2011, 13:48:23
 */
public enum ServicoType {
	
	TYPE1, TYPE2;
    
	public String getNome(){
		switch (this){
			case TYPE1: return "type1";
			default: return "typ2";
		}
	}
}