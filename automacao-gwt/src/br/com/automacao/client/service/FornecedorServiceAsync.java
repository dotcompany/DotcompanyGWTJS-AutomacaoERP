package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.FornecedorMirror;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FornecedorServiceAsync {

	public void saveUpdate(FornecedorMirror mm, AsyncCallback<Void> callback);
	public void buscar(FornecedorMirror mm, AsyncCallback<FornecedorMirror> callback);
	public void excluir(FornecedorMirror mm, AsyncCallback<Void> callback);
	public void pegar(FornecedorMirror mm, AsyncCallback<FornecedorMirror> callback);
	


}
