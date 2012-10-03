package br.com.dotcompany.type;

import com.google.gwt.user.client.rpc.IsSerializable;

class Entry implements IsSerializable{
	private String key;
	private Object value;

	public Entry(){}
	
	protected Entry(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return this.key;
	}
	public Object getValue() {
		return this.value;
	}
}