package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.NCMMirror;
import br.com.automacao.shared.util.ListUtil;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/ncmManager")
public interface NcmService extends RemoteService {
	
	public void incluir(NCMMirror nm);
	public void alterar(NCMMirror nm);
	public void excluir(NCMMirror nm);
	public void saveUpdate(NCMMirror nm);
	public NCMMirror buscar(NCMMirror nm);
	public NCMMirror pegar(NCMMirror nm);
	public ListUtil listComboAll();
}