package br.com.automacao.client.service;

import br.com.automacao.shared.mirror.MarcaMirror;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/marcaManager")
public interface MarcaService extends RemoteService {

	public void saveUpdate(MarcaMirror mm);
	public void excluir(MarcaMirror mm);
	public MarcaMirror buscar(MarcaMirror mm);
	public MarcaMirror pegar(MarcaMirror mm);
	

}
