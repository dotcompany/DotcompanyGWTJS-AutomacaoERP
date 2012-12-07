package br.com.automacao.client.service;

import java.util.List;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.util.ListUtil;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GridEditavelServiceAsync {

	void busca(String clazzName, List<String> idColumns, AsyncCallback<ListUtil> callback);
	void countFilterAll(String nameClass, String value, String[] nomeColunas, String[] tipoColunas, AsyncCallback<Integer> callback);
	void countFilterLike(String nameClass, String[] like, AsyncCallback<Integer> callback);
	void loadState(FileColumn fc, AsyncCallback<FileColumn> callback);
	void saveState(FileColumn fileColumn, AsyncCallback<Void> callback);
	
	void buscarTodos(String clazzName, Integer start, Integer maxResults, String[] idColumns, AsyncCallback<ListUtil> callback);
	void buscarFilter(String clazzName, Integer start, Integer maxResults, String[] idColumns, String[] like, AsyncCallback<ListUtil> callback);
	void buscarFilterAll(String clazzName, Integer start, Integer maxResults, String value, String[] nomeColunas, String[] tipoColunas, AsyncCallback<ListUtil> callback);
}