package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.ContatoMirror;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/marcaManager")
public interface ContatoService extends RemoteService {

	public void saveUpdate(ContatoMirror mm);
	public void excluir(ContatoMirror mm);
	public ContatoMirror buscar(ContatoMirror mm);
	public ContatoMirror pegar(ContatoMirror mm);
	

}
