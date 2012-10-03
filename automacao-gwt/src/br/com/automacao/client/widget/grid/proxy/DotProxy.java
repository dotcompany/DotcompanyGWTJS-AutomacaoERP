package br.com.automacao.client.widget.grid.proxy;

import br.com.automacao.shared.dto.FiltroDTO;
import br.com.automacao.shared.fo.Column;
import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.model.DotModel;

import com.extjs.gxt.ui.client.data.RpcProxy;

/**
 * Todos Proxy de consulta devera implementar esta interface.
 * Classe marcadora do Proxy da DotCompany
 * 
 * @author sergio
 *
 */
@SuppressWarnings("unchecked")
public abstract class DotProxy {
	
	protected final String nameClass;
	protected final FiltroDTO[] idColumns;
	protected final DotModel model;
	
	public DotProxy(FileColumn fileColumn, DotModel model) {
		this.nameClass = fileColumn.getNameClasse();
		idColumns = new FiltroDTO[fileColumn.getColunas().size()];
		this.model = model;
		loadIds(fileColumn);
	}
	
	private void loadIds(FileColumn fileColumn) {
		int cont = 0;
		for(Column col : fileColumn.getColunas()){
			idColumns[cont++] = new FiltroDTO(col.getNome(), col.getTipoColuna());
		}
	}

	public abstract void actionEnter(String value);
	public abstract RpcProxy getRpcProxy();
}
