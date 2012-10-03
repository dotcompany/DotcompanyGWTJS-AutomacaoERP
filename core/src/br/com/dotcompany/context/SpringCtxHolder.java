package br.com.dotcompany.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import br.com.dotcompany.util.UtilObjeto;

public class SpringCtxHolder implements ApplicationContextAware {

	private static Logger logger = LoggerFactory
			.getLogger(SpringCtxHolder.class);
	protected static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext appCtx)
			throws BeansException {
		cleanApplicationContext();
		logger.info("Inicializando o application Context do Spring");
		SpringCtxHolder.applicationContext = appCtx;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanAlias) {
		return (T) getApplicationContext().getBean(beanAlias);
	}

	public static <T> T getBean(Class<T> clazz) {
		String beanAlias = UtilObjeto.beanAlias(clazz);
		return getBean(beanAlias);
	}

	public static String getRealPath() {
		String path = getApplicationContext().getClassLoader().getResource("")
				.getPath();
		return path.replace("/", "\\")
				.substring(1, path.lastIndexOf("web") + 3);
	}

	public static void cleanApplicationContext() {
		applicationContext = null;
	}
}