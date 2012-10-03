package br.com.dotcompany.util;

import java.util.Locale;

import br.com.dotcompany.type.IdiomaType;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.faces <br>
 * <b>T�tulo:</b> LocationUtils.java <br>
 * <b>Descri��o:</b> <br>
 * <b>Company:</b> DotCompany TI LTDA. <br>
 * 
 *    Copyright (c) 2011 DotCompany - Todos os direitos reservados.
 * 
 * <b>Autor:</b> Danylo
 * <b>Cria��o:</b> 18/08/2011, 09:43:40
 */
public class LocationUtils extends org.apache.commons.lang.LocaleUtils {

	private static String		PT = IdiomaType.PT.getNome();
    private static String		EN = IdiomaType.EN.getNome();
    private static String		ZH = IdiomaType.ZH.getNome();
    private static String		BR = "BR";
    private static String		US = "US";
    private static String		CN = "CN";
    private String 				language = PT;
    private String 				country = BR;
    private static Locale 		locale;

    /**
     * Este m�todo pode ser utilizado para <b>alterar</b> o idioma da aplica��o para o <b>portugu�s</b>
     * ou <b>ingl�s</b>.
     */
    public String change() {
    	if (CN.equals(language)) {
    		language = ZH;
    		country = CN;
		} else if(US.equals(language)) {
	    	language = EN;
	    	country = US;
	    } else {
	    	language = PT;
	    	country = BR;
	    }
	    locale = new Locale(language, country);
	    return null;
    }

	/**
	 * Este m�todo pode ser utilizado para recuperar <b>local</b> corrente.
	 */
	public static Locale getLocale(){
		if (locale == null) {locale = new Locale(PT, BR);}
		return locale;
	}
	
	public String getCountry() {
		return country;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLanguage() {
		return language;
	}
	public String getBr() {
		return BR;
	}
	public String getUs() {
    	return US;
    }
	public String getCn() {
		return CN;
	}
}