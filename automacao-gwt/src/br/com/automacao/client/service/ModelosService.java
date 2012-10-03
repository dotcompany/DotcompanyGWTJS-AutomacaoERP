package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.ModelosMirror;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/modelosManager")
public interface ModelosService extends RemoteService {
	
	public void saveUpdate(ModelosMirror cm); 
	public void excluir(ModelosMirror cm);
	public ModelosMirror buscar(ModelosMirror cm);
	public ModelosMirror pegar(ModelosMirror cm);
	
}