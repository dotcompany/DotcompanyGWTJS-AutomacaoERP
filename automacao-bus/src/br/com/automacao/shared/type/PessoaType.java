package br.com.automacao.shared.type;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.types <br>
 * <b>T�tulo:</b> PessoaType.java <br>
 * <b>Descri��o:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Cria��o:</b> 08/09/2011, 09:03:29
 */
public enum PessoaType {
	PF, PJ;
	
	public String getNome(){
		switch (this){
			case PF: return "F�sica";
			default: return "Juridica";
		}
	}
	@Override
 	public String toString(){
 		return getNome();
 	}
}