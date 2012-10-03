package br.com.automacao.client.service;

import java.util.List;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.util.ListUtil;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/gridManager")
public interface GridService extends RemoteService {
	
	ListUtil busca(String clazzName, List<String> idColumns);
	int countFilterAll(String nameClass, String value, String[] nomeColunas, String[] tipoColunas);
	int countFilterLike(String nameClass, String[] like);
	FileColumn loadState(FileColumn fc);
	void saveState(FileColumn fileColumn);
	
	ListUtil buscarTodos(String clazzName, Integer start, Integer maxResults, String[] idColumns);
	ListUtil buscarFilter(String clazzName, Integer start,	Integer maxResults, String[] idColumns, String[] like);
	ListUtil buscarFilterAll(String clazzName, Integer start, Integer maxResults, String value, String[] nomeColunas, String[] tipoColunas);
}