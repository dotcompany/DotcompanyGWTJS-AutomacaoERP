package br.com.automacao.shared.util;

import br.com.dotcompany.util.ReflectionUtil;

public class Utils {
	
	public static boolean ok(Object str){
		if (str == null) { return false; }
		if (str instanceof String) {
			str = str.toString();
		}
		return !((String)str).isEmpty();
	}
	
	public static String normalize(String nameClass) {
		nameClass = ReflectionUtil.getClass(nameClass).getSimpleName();
		return nameClass.substring(0, nameClass.length() - 6).toLowerCase();
	}
}