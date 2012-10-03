package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.ColaboradorMirror;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface ColaboradorServiceAsync {

	public void saveUpdate(ColaboradorMirror cm, AsyncCallback<Void> callback);
	public void buscar(ColaboradorMirror cm, AsyncCallback<ColaboradorMirror> callback);
	public void excluir(ColaboradorMirror cm, AsyncCallback<Void> callback);
	public void pegar(ColaboradorMirror cm, AsyncCallback<ColaboradorMirror> callback);

}