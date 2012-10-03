package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.EmpresaMirror;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/empresaManager")
public interface EmpresaService extends RemoteService {
	
	public void incluir(EmpresaMirror em);
	public void alterar(EmpresaMirror em);
	public void excluir(EmpresaMirror em);
	public void saveUpdate(EmpresaMirror em);
	public EmpresaMirror buscar(EmpresaMirror em);
	public EmpresaMirror pegar(EmpresaMirror em);
	public EmpresaMirror buscarPorCnpjCpf(String cnpjCpf);
}