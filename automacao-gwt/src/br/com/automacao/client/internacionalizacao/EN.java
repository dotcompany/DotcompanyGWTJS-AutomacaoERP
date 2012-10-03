package br.com.automacao.client.internacionalizacao;

public interface EN extends DotCompIN{
	
	@DefaultStringValue(value = "Duplicate")
	String duplicar();
	
	@DefaultStringValue(value = "New")
	String novo();
	
	@DefaultStringValue(value = "Edit")
	String editar();
	
	@DefaultStringValue(value = "Cancel")
	String cancelar();
	
	@DefaultStringValue(value = "Remove")
	String remover();
	
	@DefaultStringValue(value = "Help")
	String ajuda();
	
	@DefaultStringValue(value = "Bookmarks")
	String favoritos();
	
	@DefaultStringValue(value = "Import")
	String importar();
	
	@DefaultStringValue(value = "Export")
	String exportar();
	
	@DefaultStringValue(value = "Print")
	String imprimir();
	
	@DefaultStringValue(value = "XLS")
	String xls();
	
	@DefaultStringValue(value = "PDF")
	String pdf();
	
	@DefaultStringValue(value = "CSV")
	String csv();
	
	@DefaultStringValue(value = "HTML")
	String html();
	
	@DefaultStringValue(value = "Click here to search")
	String clique_pesquisar();
	
	@DefaultStringValue(value = "Search")
	String pesquisar();
	
	@DefaultStringValue(value = "Include")
	String incluir();
	
	@DefaultStringValue(value = "Add")
	String adicionar();
	
	@DefaultStringValue(value = "Clear")
	String limpar();
	
	@DefaultStringValue(value = "Save")
	String salvar();
	
	@DefaultStringValue(value = "Save New")
	String salvar_novo();
	
	@DefaultStringValue(value = "Duplicate Save")
	String salvar_duplicado();
	
	@DefaultStringValue(value = "Save the grid status")
	String grid_salvar();
	
	@DefaultStringValue(value = "The field can not be empty!")
	String text_field_permite_branco();
	
	@DefaultStringValue(value = "Click here to view video lesson")
	String clique_video_aula();
	
}