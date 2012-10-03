package br.com.dotcompany.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import br.com.dotcompany.context.FacesCtxHolder;

/**
 * Classe de conex�o com arquivo de mensagem .properties
 * 
 * @author sergio
 * 
 */
public class PropertiesUtil {

	private static Properties propDefault;
	private static Properties propExterno;

	public static void loadProperties(ServletContext sc, Locale locale)
			throws FileNotFoundException, IOException {
		if (propDefault == null) {
			// Busca linguagem local
			String language = Locale.getDefault().getLanguage();

			String nomeArquivo = "messages_" + language + ".properties";

			String fs = File.separator;
			String file = sc.getRealPath(fs + "WEB-INF" + fs + "classes" + fs
					+ "resources" + fs + "" + nomeArquivo);

			propDefault = new Properties();
			propDefault.load(new FileInputStream(file));
		}
	}

	public static Properties loadFile(String path) throws IOException {
		propExterno = new Properties();
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null) {
			classLoader = PropertiesUtil.class.getClassLoader();
		}
		FileInputStream fis = new FileInputStream(path);
		propExterno.load(fis);
		return propExterno;
	}

	public static String getExternoProperty(String propertyName)
			throws IOException {
		if (propExterno == null) {
			throw new RuntimeException(
					"Arquivo properties externo n�o foi carregado");
		}
		return (String) propExterno.get(propertyName);
	}

	public String getProperty(String propertyName) throws IOException {
		Properties prop = new Properties();
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		if (classLoader == null) {
			classLoader = getClass().getClassLoader();
		}

		String fs = File.separator;

		FileInputStream fis = new FileInputStream(FacesCtxHolder.getRealPath()
				+ fs + "resources" + fs + "properties" + fs + "mail.properties");

		if (fis != null) {
			prop = new Properties();

			try {
				prop.load(fis);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return (String) prop.get(propertyName);
	}

	public static String pegarString(String key) {
		return propDefault.getProperty(key);
	}

	public static String pegarMessageResourceString(String key, Object params[]) {
		String text = null;
		try {
			text = pegarString(key);
		} catch (Exception e) {
			text = key;
		}
		if (params != null) {
			MessageFormat mf = new MessageFormat(text,
					new Locale("pt", "pt_br"));
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}

	protected static ClassLoader getCurrentClassLoader(Object defaultObject) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = defaultObject.getClass().getClassLoader();
		}
		return loader;
	}

	/**
	 * Retorna o valor da chave passada
	 */
	public static String getMessageResourceString(String key) {
		return getMessageResourceString(key, null);
	}

	public static String getMessageResourceString(String key, Object params[]) {
		String text = null;
		FacesContext context = FacesContext.getCurrentInstance();

		String bundleName = context.getApplication().getMessageBundle();
		Locale locale = getLocale(context);

		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale,
				getCurrentClassLoader(params));
		try {
			text = bundle.getString(key);
		} catch (Exception e) {
			text = key;
		}
		if (params != null) {
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}

	private static Locale getLocale(FacesContext context) {
		if (context.getViewRoot() != null
				&& context.getViewRoot().getLocale() != null) {
			return context.getViewRoot().getLocale();
		} else {
			return new Locale("pt", "pt_br");
		}
	}

	public static FacesMessage getMessageResource(String key, Object params[]) {
		String text = null;

		FacesContext context = FacesContext.getCurrentInstance();
		String bundleName = context.getApplication().getMessageBundle();
		Locale locale = context.getViewRoot().getLocale();

		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale,
				getCurrentClassLoader(params));
		try {
			text = bundle.getString(key);
		} catch (MissingResourceException e) {
			text = "?? key " + key + " n�o encontrada ??";
		}
		if (params != null) {
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return new FacesMessage(text, null);
	}
}
