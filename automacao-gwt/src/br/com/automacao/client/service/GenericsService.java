package br.com.automacao.client.service;

import java.util.List;
import java.util.Map;

import br.com.automacao.shared.dto.CepDTO;
import br.com.automacao.shared.dto.TextFieldDTO;
import br.com.automacao.shared.util.Mirror;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("genericsManager")
public interface GenericsService extends RemoteService {
	
	void salvarForDinamico(String nameClass, List<String> listName, List<Object> listValue);	
	List<TextFieldDTO> loadForm(String nameClass);
	Long ultimoId(String nameClass);
	Map<String, String> loadApp();
	CepDTO loadCep(String value);
	<T extends Mirror> List<T> listar(String nameClass, String[] idColumns, String[] like);
	<T extends Mirror> List<T> listar(String nameClass);
}