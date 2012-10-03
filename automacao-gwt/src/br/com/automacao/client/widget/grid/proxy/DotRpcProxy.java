package br.com.automacao.client.widget.grid.proxy;

import java.util.ArrayList;
import java.util.List;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.model.DotModel;
import br.com.automacao.shared.util.ListUtil;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.FilterConfig;
import com.extjs.gxt.ui.client.data.FilterPagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Classe de RpcProxy
 * 
 * @author sergio
 *
 */
public class DotRpcProxy<T extends DotModel> extends DotProxy {
	
	private Boolean findAll;
	private String value;

	public DotRpcProxy(FileColumn fileColumn, DotModel model) {
		super(fileColumn, model);
		findAll = Boolean.FALSE;
	}
	
	/**
	 * Retorna o RpcProxy para acesso ao banco e retornar para o grid 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public RpcProxy getRpcProxy(){
		return new RpcProxy<PagingLoadResult<T>>() {
			@Override
			protected void load(Object loadConfig, final
					AsyncCallback<PagingLoadResult<T>> callback) {
				final FilterPagingLoadConfig config = (FilterPagingLoadConfig)loadConfig;
				List<FilterConfig> filters = config.getFilterConfigs();

				if(findAll && (value != null && !value.trim().isEmpty()))
					listarFindAllFields(config, callback);
				else if(filters.size() <= 0)
					listarTodos(config, callback);
				else
					listarFiltro(config, callback);
			}
		};
	}

	/**
	 * Quando � feito uma consulta pelo textfield do grid 
	 * 
	 * @param config
	 * @param callback
	 */
	@SuppressWarnings("unchecked")
	private void listarFindAllFields(final FilterPagingLoadConfig config, final AsyncCallback<PagingLoadResult<T>> callback) {
		String[] columns = new String[idColumns.length];
		String[] tipoColumns = new String[idColumns.length];
		for (int i = 0; i < idColumns.length; i++) {
			columns[i] = idColumns[i].getNomeColuna();
			tipoColumns[i] = idColumns[i].getTipoColuna();
		}
		
		DesktopApp.getServiceGrid().buscarFilterAll(nameClass, config.getOffset(), config.getLimit(), value, columns, tipoColumns,	new AsyncCallback<ListUtil>() {
			@Override
			public void onFailure(Throwable caught) {
				callback.onSuccess(new BasePagingLoadResult<T>(new ArrayList<T>(), 0, 0));
			}

			@Override
			public void onSuccess(ListUtil result) {
				model.convert(result.getWrappedData());
	            callback.onSuccess(new BasePagingLoadResult<T>((List<T>) model.getListModel(), config.getOffset(), result.getRowCount()));
	            findAll = Boolean.FALSE;
	    		value = "";
			}
		});
	}

	/**
	 * Quando � feito uma consulta por uma coluna do grid 
	 * 
	 * @param config
	 * @param callback
	 */
	private void listarFiltro(final FilterPagingLoadConfig config, final AsyncCallback<PagingLoadResult<T>> callback) {
		String[] columns = new String[idColumns.length];
		for (int i = 0; i < idColumns.length; i++) {
			columns[i] = idColumns[i].getNomeColuna();
		}
		
		int size = config.getFilterConfigs().size() * 3;
		String[] like = new String[size];
		
		int cont = 0;
		
		for(FilterConfig fc : config.getFilterConfigs()){
			like[cont++] = fc.getField(); 
			like[cont++] = fc.getType();
			like[cont++] = String.valueOf(fc.getValue());  
		}
		
		DesktopApp.getServiceGrid().buscarFilter(nameClass, config.getOffset(), config.getLimit(), columns, like, new AsyncCallback<ListUtil>() {
			@Override
			public void onFailure(Throwable caught) {
				callback.onSuccess(new BasePagingLoadResult<T>(new ArrayList<T>(), 0, 0));
			}

			@SuppressWarnings("unchecked")
			@Override
			public void onSuccess(ListUtil result) {
				model.convert(result.getWrappedData());
				callback.onSuccess(new BasePagingLoadResult<T>((List<T>) model.getListModel(), config.getOffset(), result.getRowCount()));
			}
		});
	}

	/**
	 * Lista todos de forma paginada e projetada
	 * 
	 * @param config
	 * @param callback
	 */
	private void listarTodos(final FilterPagingLoadConfig config, final AsyncCallback<PagingLoadResult<T>> callback) {
		String[] columns = new String[idColumns.length];
		for (int i = 0; i < idColumns.length; i++) {
			columns[i] = idColumns[i].getNomeColuna();
		}
		
		DesktopApp.getServiceGrid().buscarTodos(nameClass, config.getOffset(), config.getLimit(), columns, new AsyncCallback<ListUtil>() {
			@Override
			public void onFailure(Throwable caught) {
				callback.onSuccess(new BasePagingLoadResult<T>(new ArrayList<T>(), 0, 0));
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public void onSuccess(ListUtil result) {
				model.convert(result.getWrappedData());
				callback.onSuccess(new BasePagingLoadResult<T>((List<T>) model.getListModel(), config.getOffset(), result.getRowCount()));
			}
		});
	}

	@Override
	public void actionEnter(String value) {
		findAll = Boolean.TRUE;
		this.value = value;
	}
}