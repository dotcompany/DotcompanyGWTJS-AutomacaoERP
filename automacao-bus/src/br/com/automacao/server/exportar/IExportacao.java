package br.com.automacao.server.exportar;

import br.com.automacao.shared.util.ExportacaoListagem;

/**
 * Interface que generaliza a forma como o sistema trata as exportacoes.
 * 
 * @author Pedro H. Lira
 * @version 1.0
 */
public interface IExportacao {

	/**
	 * Metodo que exporta a listagem.
	 * 
	 * @param lista
	 *            a listagem que deve ser usada para exportar os dados.
	 * @param empresa
	 *            os dados da empresa logada do sistema.
	 * @param enderecos
	 *            os dados de endereco.
	 * @param contatos
	 *            os dados de contato.
	 * @return um array de bytes do arquivo exportado.
	 */
	@SuppressWarnings("unchecked")
	public byte[] getArquivo(ExportacaoListagem lista);

	/**
	 * Metodo que exporta o registro.
	 * 
	 * @param registro
	 *            o registro que deve ser usado para exportar os dados.
	 * @param listas
	 *            a colecao de sub-listagens vinculadas ao registro.
	 * @param empresa
	 *            os dados da empresa logada do sistema.
	 * @param enderecos
	 *            os dados de endereco.
	 * @param contatos
	 *            os dados de contato.
	 * @return um array de bytes do arquivo exportado.
	 */
//	public byte[] getArquivo(ExportacaoRegistro registro, Collection<ExportacaoListagem> listas, String[] empresa, String[][] enderecos, String[][] contatos);
}
