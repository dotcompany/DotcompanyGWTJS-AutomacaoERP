package br.com.automacao.client.service;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SessaoServiceAsync {

	void colocarNaSessao(String key, Serializable value, AsyncCallback<Void> callback);

	void retirarDaSessao(String key, AsyncCallback<Serializable> callback);

}
