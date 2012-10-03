package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.MarcaMirror;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MarcaServiceAsync {

	public void saveUpdate(MarcaMirror mm, AsyncCallback<Void> callback);
	public void buscar(MarcaMirror mm, AsyncCallback<MarcaMirror> callback);
	public void excluir(MarcaMirror mm, AsyncCallback<Void> callback);
	public void pegar(MarcaMirror mm, AsyncCallback<MarcaMirror> callback);
	


}
