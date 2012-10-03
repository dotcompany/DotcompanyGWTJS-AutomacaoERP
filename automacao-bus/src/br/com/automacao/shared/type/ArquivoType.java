package br.com.automacao.shared.type;

import java.io.Serializable;

/**
 * Enumerador que define os tipos de arquivos usados para download/upload.
 * 
 * @author Pedro H. Lira
 * @version 1.0
 */
public enum ArquivoType implements Serializable {
	/**
	 * Arquivo de impressao
	 */
	PDF,
	/**
	 * Arquivo de planilha
	 */
	XLS, 
	/**
	 * Arquivo em texto separado
	 */
	CSV, 
	/**
	 * Arquivo em tag
	 */
	XML, 
	/**
	 * Arquivo em web
	 */
	HTML,
	/**
	 * Arquivo compactado
	 */
	ZIP;

	public String getNome(){
		switch (this) {
		case PDF: return "Pdf";
		case XLS: return "Xls";
		case CSV: return "Cvs";
		case XML: return "Xml";
		case HTML: return "Html";
		default: return "Zip";
		}
 	}
 	
 	@Override
 	public String toString(){
 		return getNome();
 	}
}
