package br.com.automacao.shared.fo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class FileObjectPersist implements IsSerializable{

	/**
	 * 
	 */
	private String key;
	
	public FileObjectPersist() {
	}
	
	public FileObjectPersist(String key) {
		this.key = key;
	}

	public String getKey(){
		return key;
	}
}