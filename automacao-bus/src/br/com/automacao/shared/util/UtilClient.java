package br.com.automacao.shared.util;

import java.util.Date;
import java.util.Map;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.xml.client.Element;

/**
 * Classe que implementa métodos uteis ao sistema como todo.
 * 
 * @author Pedro H. Lira
 * @version 1.0
 */
public class UtilClient {

	/**
	 * Data do sistema usando a data do servidor.
	 */
	public static Date DATA;
	/**
	 * Configuracoes setadas para a empresa.
	 */
	public static Map<String, String> CONF;

	/**
	 * Metodo que recupera um registro de uma massa de dados mediante filtro.
	 * 
	 * @param store
	 *            massa de dados a ser pesquisada.
	 * @param campoFiltro
	 *            nome do campo que será usado no filtro.
	 * @param valorFiltro
	 *            valor do filtro para identificar o registro.
	 * @return o registro encontrado após o filtro usado.
	 */
//	public static Record getRegistro(Store store, String campoFiltro, String valorFiltro) {
//		try {
//			store.clearFilters();
//			store.filter(campoFiltro, valorFiltro);
//			return store.getAt(0);
//		} catch (Exception ex) {
//			return null;
//		} finally {
//			store.clearFilters();
//		}
//	}

	/**
	 * Metodo que padroniza o formato de datetime reconhecido pelo Grid.
	 * 
	 * @param data
	 *            o valor da data a ser formatada.
	 * @return a data formatada no padrão.
	 */
	public static String getDataHoraGrid(Date data) {
		if (data != null) {
			return getDataGrid(data) + " " + getHoraGrid(data);
		} else {
			return "";
		}
	}

	/**
	 * Metodo que padroniza o formato da date reconhecido pelo Grid.
	 * 
	 * @param data
	 *            o valor da data a ser formatada.
	 * @return a data formatada no padrão.
	 */
	@SuppressWarnings("deprecation")
	public static String getDataGrid(Date data) {
		if (data != null) {
			return (data.getMonth() + 1) + "/" + data.getDate() + "/" + (data.getYear() + 1900);
		} else {
			return "";
		}
	}

	/**
	 * Metodo que padroniza o formato da hora reconhecido pelo Grid.
	 * 
	 * @param hora
	 *            o valor da hora a ser formatada.
	 * @return a hora formatada no padrão.
	 */
	@SuppressWarnings("deprecation")
	public static String getHoraGrid(Date hora) {
		if (hora != null) {
			return hora.getHours() + ":" + hora.getMinutes() + ":" + hora.getSeconds();
		} else {
			return "";
		}
	}

	/**
	 * @see #formataNumero(double, int, int, boolean)
	 */
	public static String formataNumero(String valor, int inteiros, int decimal, boolean grupo) {
		return formataNumero(Double.valueOf(valor), inteiros, decimal, grupo);
	}

	/**
	 * Metodo que faz a formatacao de numeros com inteiros e fracoes
	 * 
	 * @param valor
	 *            o valor a ser formatado
	 * @param inteiros
	 *            o minimo de inteiros, que serao completados com ZEROS se
	 *            preciso
	 * @param decimal
	 *            o minimo de decimais, que serao completados com ZEROS se
	 *            preciso
	 * @param grupo
	 *            se sera colocado separador de grupo de milhar
	 * @return uma String com o numero formatado
	 */
	public static String formataNumero(double valor, int inteiros, int decimal, boolean grupo) {
		String padrao = "";

		if (grupo) {
			padrao = "#,##0";
		} else {
			for (int i = 0; i < inteiros; i++) {
				padrao += "0";
			}
		}

		if (decimal > 0) {
			padrao += ".";
			for (int i = 0; i < decimal; i++) {
				padrao += "0";
			}
		}

		NumberFormat nf = NumberFormat.getFormat(padrao);
		return nf.format(valor);
	}

	/**
	 * Metodo que verifica se o campo tem prefixo, senao coloca o padrao
	 * 
	 * @param campo
	 *            usado pela listagem.
	 * @return o campo prefixado.
	 */
	public static String getCampoPrefixado(String campo) {
		MatchResult mat = RegExp.compile("^t\\d+\\.").exec(campo);
		if (mat == null) {
			campo = "t." + campo.replace("t.", "");
		}
		return campo;
	}

	/**
	 * Metodo que retorna o ID do registro selecionado em um grid
	 * 
	 * @param grid
	 *            o grid a ser utilizado.
	 * @return 0 se nao tem ninguem selecionado ou um numero maior que 0 quando
	 *         selecionado
	 */
//	public static int getSelecionado(GridPanel grid) {
//		if (grid.getSelectionModel().hasSelection() && !grid.getSelectionModel().getSelected().isEmpty(grid.getSelectionModel().getSelected().getFields()[0])) {
//			return grid.getSelectionModel().getSelected().getAsInteger(grid.getSelectionModel().getSelected().getFields()[0]);
//		} else {
//			MessageBox.alert(OpenSigCore.i18n.txtSelecionar(), OpenSigCore.i18n.errSelecionar());
//			return 0;
//		}
//	}

	/**
	 * Metodo que percorre os comando ate achar o ultimo para adicionar ao final
	 * da fila
	 * 
	 * @param comando
	 *            o IComando que será executado.
	 * @param ultimo
	 *            o IComando que será executado no final da lista de execucao.
	 */
//	public static void comandoFinal(IComando comando, IComando ultimo) {
//		IComando fim = comando.getProximo() != null ? comando.getProximo() : comando;
//		while (fim.getProximo() != null) {
//			fim = fim.getProximo();
//		}
//		fim.setProximo(ultimo);
//	}

	/**
	 * Metodo que retorna o valor de uma tag dentro do xml.
	 * 
	 * @param ele
	 *            elemento xml em forma de objeto.
	 * @param tag
	 *            nome da tag que deseja recuperar o valor.
	 * @param excecao
	 *            se passado true dispara a exception se ocorrer erro, se false
	 *            retorna null
	 * @return valor da tag encontrada ou NULL se nao achada.
	 * @exception NullPointerException
	 *                exceção disparada em caso de erro.
	 */
	public static String getValorTag(Element ele, String tag, boolean excecao) throws NullPointerException {
		try {
			return ele.getElementsByTagName(tag).item(0).getFirstChild().getNodeValue();
		} catch (Exception e) {
			if (excecao) {
				throw new NullPointerException(CONF.get("errInvalido") + " - > " + tag);
			}
			return null;
		}
	}

	/**
	 * Métod que realiza um "refresh" na tela.
	 */
	public final static native void atualizar()/*-{
												$wnd.location.reload( false );
												}-*/;

	/**
	 * Metodo que retorna o resultado de uma expressao.
	 * 
	 * @param expressao
	 *            uma expressao matemática.
	 * @return o resultado da expressao.
	 */
	public final static native String eval(String expressao)/*-{
															return eval(expressao).toString();
															}-*/;

	/**
	 * Metodo que abre uma janela no navegador.
	 * 
	 * @param url
	 *            o endereco da página solicitada.
	 */
	public static native void abrirUrl(String url)/*-{
													window.open(url);
													}-*/;

	/**
	 * Metodo que solicita a exportacao
	 * 
	 * @param url
	 *            o endereco de exporracao formatada.
	 */
	public static native void exportar(String url) /*-{
													var frame = $doc.getElementById('__gwt_printingFrame');
													frame.src = url;
													}-*/;
}
