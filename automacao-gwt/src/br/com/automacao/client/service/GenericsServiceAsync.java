package br.com.automacao.client.service;

import java.util.List;
import java.util.Map;

import br.com.automacao.shared.dto.CepDTO;
import br.com.automacao.shared.dto.TextFieldDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

@SuppressWarnings("unchecked")
public interface GenericsServiceAsync {
	void loadForm(String clazzName, AsyncCallback<List<TextFieldDTO>> callback);
	void salvarForDinamico(String clazzName, List<String> listName, List<Object> listValue, AsyncCallback<Void> callback);
	void ultimoId(String clazzName, AsyncCallback<Long> callback);
	void loadCep(String value, AsyncCallback<CepDTO> callback);
	void loadApp(AsyncCallback<Map<String, String>> callback);
	void listar(String nameClass, String[] idColumns, String[] like, AsyncCallback<List> callback);
	void listar(String nameClass, AsyncCallback<List> callback);
}