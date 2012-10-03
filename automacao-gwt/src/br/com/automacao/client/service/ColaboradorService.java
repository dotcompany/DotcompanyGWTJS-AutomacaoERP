package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.ColaboradorMirror;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/colaboradorManager")
public interface ColaboradorService extends RemoteService {
	
	public void saveUpdate(ColaboradorMirror cm);
	public void excluir(ColaboradorMirror cm);
	public ColaboradorMirror buscar(ColaboradorMirror cm);
	public ColaboradorMirror pegar(ColaboradorMirror cm);
	
}