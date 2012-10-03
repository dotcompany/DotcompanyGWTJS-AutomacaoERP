package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.FornecedorMirror;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/marcaManager")
public interface FornecedorService extends RemoteService {

	public void saveUpdate(FornecedorMirror mm);
	public void excluir(FornecedorMirror mm);
	public FornecedorMirror buscar(FornecedorMirror mm);
	public FornecedorMirror pegar(FornecedorMirror mm);
	

}
