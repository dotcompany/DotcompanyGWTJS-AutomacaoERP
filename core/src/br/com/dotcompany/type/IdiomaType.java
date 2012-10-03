package br.com.dotcompany.type;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.enumerator <br>
 * <b>Título:</b> IdiomaType.java <br>
 * <b>Descrição:</b> <br>
 * <b>Company:</b> DotCompany TI LTDA. <br>
 * 
 * Copyright (c) 2011 DotCompany - Todos os direitos reservados.
 * 
 * <b>Autor:</b> Danylo <b>Criação:</b> 18/08/2011, 09:43:31
 */
public enum IdiomaType {
	PT, EN, ZH;

	public String getNome() {
		switch (this) {
		case PT:
			return "pt";
		case EN:
			return "en";
		default:
			return "zh";
		}
	}
}