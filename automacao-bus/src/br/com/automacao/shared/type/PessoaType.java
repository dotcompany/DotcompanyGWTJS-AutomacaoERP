package br.com.automacao.shared.type;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.types <br>
 * <b>Título:</b> PessoaType.java <br>
 * <b>Descrição:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Criação:</b> 08/09/2011, 09:03:29
 */
public enum PessoaType {
	PF, PJ;
	
	public String getNome(){
		switch (this){
			case PF: return "Física";
			default: return "Juridica";
		}
	}
	@Override
 	public String toString(){
 		return getNome();
 	}
}