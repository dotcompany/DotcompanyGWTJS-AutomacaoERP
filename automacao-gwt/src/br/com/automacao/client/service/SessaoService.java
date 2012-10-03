package br.com.automacao.client.service;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/sessaoManager")
public interface SessaoService extends RemoteService {
	
	public void colocarNaSessao(String key, Serializable value);
	public Serializable retirarDaSessao(String key);
}