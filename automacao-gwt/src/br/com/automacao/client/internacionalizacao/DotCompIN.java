package br.com.automacao.client.internacionalizacao;

import com.google.gwt.i18n.client.Constants;

public interface DotCompIN extends Constants{
	
	@DefaultStringValue(value = "Duplicar Selecionado")
	String duplicar();
	
	@DefaultStringValue(value = "Novo")
	String novo();
	
	@DefaultStringValue(value = "Editar")
	String editar();
	
	@DefaultStringValue(value = "Cancelar")
	String cancelar();
	
	@DefaultStringValue(value = "Remover")
	String remover();
	
	@DefaultStringValue(value = "Ajuda")
	String ajuda();
	
	@DefaultStringValue(value = "Favoritos")
	String favoritos();
	
	@DefaultStringValue(value = "Importar")
	String importar();
	
	@DefaultStringValue(value = "Exportar")
	String exportar();
	
	@DefaultStringValue(value = "Imprimir")
	String imprimir();
	
	@DefaultStringValue(value = "XLS")
	String xls();
	
	@DefaultStringValue(value = "PDF")
	String pdf();
	
	@DefaultStringValue(value = "CSV")
	String csv();
	
	@DefaultStringValue(value = "HTML")
	String html();
	
	@DefaultStringValue(value = "Clique aqui para pesquisar")
	String clique_pesquisar();
	
	@DefaultStringValue(value = "Pesquisar")
	String pesquisar();
	
	@DefaultStringValue(value = "Incluir")
	String incluir();
	
	@DefaultStringValue(value = "Adicionar")
	String adicionar();
	
	@DefaultStringValue(value = "Limpar")
	String limpar();
	
	@DefaultStringValue(value = "Salvar")
	String salvar();
	
	@DefaultStringValue(value = "Salvar Novo")
	String salvar_novo();
	
	@DefaultStringValue(value = "Salvar Duplicado")
	String salvar_duplicado();
	
	@DefaultStringValue(value = "Salvar status do grid")
	String grid_salvar();
	
	@DefaultStringValue(value = "O Campo não pode ser vazio!")
	String text_field_permite_branco();
	
	@DefaultStringValue(value = "Clique aqui para ver video aula")
	String clique_video_aula();
}