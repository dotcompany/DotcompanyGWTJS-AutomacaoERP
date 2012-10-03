package br.com.automacao.client.service;

import br.com.automacao.shared.util.ListUtil;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
* The client side stub for the RPC service.
*/
@RemoteServiceRelativePath("springGwtServices/cnaeManager")
public interface CnaeService extends RemoteService {

	public ListUtil listComboCnae();

}