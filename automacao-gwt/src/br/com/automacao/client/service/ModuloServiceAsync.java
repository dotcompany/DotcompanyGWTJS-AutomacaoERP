package br.com.automacao.client.service;

import java.util.List;

import br.com.automacao.shared.mirror.EmpresaModuloMirror;
import br.com.automacao.shared.mirror.ModuloMirror;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ModuloServiceAsync {

	void saveUpdate(ModuloMirror mm, AsyncCallback<Void> callback);
	void excluir(ModuloMirror mm, AsyncCallback<Void> callback);
	void pegar(ModuloMirror mm, AsyncCallback<ModuloMirror> callback);
	void buscar(ModuloMirror mm, AsyncCallback<ModuloMirror> callback);
	void buscarPorEmpresa(Integer idEmpresa, AsyncCallback<List<ModuloMirror>> callback);
	void excluir(List<EmpresaModuloMirror> lEMExcludes,	AsyncCallback<Void> callback);
}
