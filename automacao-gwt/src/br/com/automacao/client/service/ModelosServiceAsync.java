package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.ModelosMirror;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface ModelosServiceAsync {

	public void saveUpdate(ModelosMirror cm, AsyncCallback<Void> callback);
	public void buscar(ModelosMirror cm, AsyncCallback<ModelosMirror> callback);
	public void excluir(ModelosMirror cm, AsyncCallback<Void> callback);
	public void pegar(ModelosMirror cm, AsyncCallback<ModelosMirror> callback);

}
