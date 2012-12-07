package br.com.dotcompany.util;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
/**
 * Comparação entre objetos
 * 
 * @author sergio
 *
 */
public class UtilObjeto {
	public static boolean isDiferentes(Object objeto1, Object objeto2) {
		return objeto1 == null ? objeto2 != null : !objeto1.equals(objeto2);
	}
	
	public static String beanAlias(Class<?> clazz) {
		return StringUtils.uncapitalize(clazz.getSimpleName());
	}

	public static boolean isTrue(Boolean bool) {
		return BooleanUtils.isTrue(bool);
	}

	public static boolean isFalse(Boolean bool) {
		return !isTrue(bool);
	}
	
	public static boolean isNotEmpty(Object objeto) {
		return !isEmpty(objeto);
	}

	public static boolean isEmpty(Object objeto) {
		if (objeto == null) {return true;}
		else if (objeto instanceof Collection<?>) {return CollectionUtils.isEmpty((Collection<?>) objeto);}
		else if (objeto instanceof Map<?, ?>) {return MapUtils.isEmpty((Map<?, ?>) objeto);}
		else if (objeto instanceof String) {return StringUtils.isEmpty((String)objeto);}
		else if (objeto instanceof Object[]) {return ((Object[]) objeto).length == 0;}
		else{throw new RuntimeException("Tipo de objeto ["+ objeto.getClass() +"] não e suportado");}
	}
	
	public static String splitCamelCase(String name) {
		return name.replaceAll(String.format("%s|%s|%s",
				"(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
				"(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
	}

}