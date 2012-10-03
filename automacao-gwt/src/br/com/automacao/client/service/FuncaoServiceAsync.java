package br.com.automacao.client.service;

import br.com.automacao.shared.util.ListUtil;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FuncaoServiceAsync {

	void listComboFuncao(AsyncCallback<ListUtil> callback);

}
