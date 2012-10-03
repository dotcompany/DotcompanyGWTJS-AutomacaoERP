package br.com.dotcompany.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Contador de usuários online no sistema
 * 
 * @author sergio
 * 
 */
public class UsersOnline {

	static Map<String, Date> online;

	public static synchronized void putOnline(String key) {
		if (online == null)
			online = new HashMap<String, Date>();

		online.put(key, new Date());
	}

	public static synchronized int getOnlineCount() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -30);
		Date limit = cal.getTime();

		Iterator<String> it = online.keySet().iterator();
		Date data;
		String key;
		List<String> toRemove = new ArrayList<String>();

		while (it.hasNext()) {
			key = (String) it.next();
			data = (Date) online.get(key);
			if (data.before(limit)) {
				toRemove.add(key);
			}
		}

		for (int j = 0; j < toRemove.size(); j++) {
			online.remove(toRemove.get(j));
		}

		return online.size();
	}
}
