package br.com.automacao.client;

import java.util.HashMap;
import java.util.Map;

public class DotProperties {
	public static Map<String, String> properties = new HashMap<String, String>();

	private static String DEBUG_MODE = "debug.mode";

	public static void load(Map<String, String> p) {
		properties.putAll(p);
	}

	public static void unload() {
		properties.clear();
	}

	public static String get(String key) {
		String value;
		return (value = properties.get(key)) == null ? "" : value.trim()
				.toLowerCase();
	}

	public static boolean is(String key) {
		String value;
		return (value = get(key)).equals("") ? false : "true".equals(value);
	}

	public static boolean isDebugMode() {
		return is(DEBUG_MODE);
	}
}