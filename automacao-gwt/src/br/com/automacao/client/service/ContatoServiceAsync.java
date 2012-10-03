package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.ContatoMirror;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ContatoServiceAsync {

	public void saveUpdate(ContatoMirror mm, AsyncCallback<Void> callback);
	public void buscar(ContatoMirror mm, AsyncCallback<ContatoMirror> callback);
	public void excluir(ContatoMirror mm, AsyncCallback<Void> callback);
	public void pegar(ContatoMirror mm, AsyncCallback<ContatoMirror> callback);
}
