package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.EmpresaMirror;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmpresaServiceAsync {

	void incluir(EmpresaMirror em, AsyncCallback<Void> callback);
	void alterar(EmpresaMirror em, AsyncCallback<Void> callback);
	void excluir(EmpresaMirror em, AsyncCallback<Void> callback);
	void buscar(EmpresaMirror em, AsyncCallback<EmpresaMirror> callback);
	void pegar(EmpresaMirror em, AsyncCallback<EmpresaMirror> callback);
	void saveUpdate(EmpresaMirror em, AsyncCallback<Void> callback);
	void buscarPorCnpjCpf(String cnpjCpf, AsyncCallback<EmpresaMirror> callback);
}
