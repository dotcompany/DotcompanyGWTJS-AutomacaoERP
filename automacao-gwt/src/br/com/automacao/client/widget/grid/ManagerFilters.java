package br.com.automacao.client.widget.grid;

import br.com.automacao.shared.fo.Column;
import br.com.automacao.shared.fo.FileColumn;

import com.extjs.gxt.ui.client.widget.grid.filters.BooleanFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.DateFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.Filter;
import com.extjs.gxt.ui.client.widget.grid.filters.GridFilters;
import com.extjs.gxt.ui.client.widget.grid.filters.NumericFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.StringFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.BooleanFilter.BooleanFilterMessages;
import com.extjs.gxt.ui.client.widget.grid.filters.StringFilter.StringFilterMessages;

public class ManagerFilters {

	private ManagerFilters() {}
	
	public final static void generate(GridFilters filters, FileColumn fileColumn) {
		for(Column col : fileColumn.getColunas()){
			if(col.getTipoColuna().toLowerCase().equals("boolean")){
				BooleanFilter booleanFilter = new BooleanFilter(col.getNome());
				BooleanFilterMessages booleanMessages = new BooleanFilterMessages();
				booleanMessages.setNoText("Não");
				booleanMessages.setYesText("Sim");
				booleanFilter.setMessages(booleanMessages);
				filters.addFilter(booleanFilter);
			} else if(col.getTipoColuna().toLowerCase().equals("string")){
				StringFilter stringFilter = new StringFilter(col.getNome());
				StringFilterMessages stringMessages = new StringFilterMessages();
				stringMessages.setEmptyText("");
				stringFilter.setMessages(stringMessages);
				filters.addFilter(stringFilter);
			}
		}
	}
	
	public final static String getType(Filter filter) {
		if(filter instanceof StringFilter)
			return "string";
		if(filter instanceof BooleanFilter)
			return "boolean";
		if(filter instanceof DateFilter)
			return "date";
		if(filter instanceof NumericFilter)
			return "numeric";
		
		return "list";
		
			
	}
}