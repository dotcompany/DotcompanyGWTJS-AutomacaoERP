package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.NCMMirror;
import br.com.automacao.shared.util.ListUtil;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NcmServiceAsync {

	void alterar(NCMMirror nm, AsyncCallback<Void> callback);
	void buscar(NCMMirror nm, AsyncCallback<NCMMirror> callback);
	void excluir(NCMMirror nm, AsyncCallback<Void> callback);
	void incluir(NCMMirror nm, AsyncCallback<Void> callback);
	void listComboAll(AsyncCallback<ListUtil> callback);
	void pegar(NCMMirror nm, AsyncCallback<NCMMirror> callback);
	void saveUpdate(NCMMirror nm, AsyncCallback<Void> callback);
}