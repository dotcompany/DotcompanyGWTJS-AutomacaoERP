package br.com.automacao.shared.build;

public class BuildUtils {

	public static void main(String[] args) {
		executeOn(args);
	}
	
	private static void executeOn(String[] args){
		String caminho = "C:\\estrutura-marcos-codigos-fontes\\DotcompanyGWTJS-AutomacaoERP\\automacao-bus";
		BuildMirror.main(caminho);
		BuildDozer.main(caminho);
	}
}
