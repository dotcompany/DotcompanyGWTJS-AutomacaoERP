package br.com.automacao.client.internacionalizacao;

import com.google.gwt.i18n.client.Messages;

public interface PtBr extends Messages{
	String duplicar();
	String novo();
	String editar();
	String cancelar();
	String remover();
	String ajuda();
	String favoritos();
	String importar();
	String exportar();
	String imprimir();
	String xls();
	String pdf();
	String csv();
	String html();
	String clique_pesquisar();
	String pesquisar();
	String incluir();
	String adicionar();
	String limpar();
	String salvar();
	String salvar_novo();
	String salvar_duplicado();
	
	String clique_video_aula();
	
	String text_field_permite_branco();
	
	String grid_salvar();
	
	@DefaultMessage("Param {0} e param {1}")
	String erro_teste(String value1, String value2);
}