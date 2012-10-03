package br.com.automacao.client.service;

import java.util.List;

import br.com.automacao.shared.mirror.EmpresaModuloMirror;
import br.com.automacao.shared.mirror.ModuloMirror;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/moduloManager")
public interface ModuloService extends RemoteService {
	
	public void saveUpdate(ModuloMirror mm);
	public void excluir(ModuloMirror mm);
	public ModuloMirror pegar(ModuloMirror mm);
	public ModuloMirror buscar(ModuloMirror mm);
	public List<ModuloMirror> buscarPorEmpresa(Integer idEmpresa);
	void excluir(List<EmpresaModuloMirror> lEMExcludes);
	
}