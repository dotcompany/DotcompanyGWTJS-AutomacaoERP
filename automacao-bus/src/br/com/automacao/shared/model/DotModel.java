package br.com.automacao.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.data.BaseModel;

public abstract class DotModel extends BaseModel implements Serializable {

	protected DotModel dotModel;
	protected List<DotModel> listModel = new ArrayList<DotModel>();
	
	public DotModel() {}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String ID 				= "id";
	
	public abstract Mirror getTO();
	
	protected abstract  void createColumns(FileColumn fc);
	
	public abstract String getSecond();
	
	public abstract String getValueFind();
	
	public abstract void add(Mirror mirror);

	public List<DotModel> getListModel() {
		return listModel;
	}
	
	public String getFirst(){
		return ID;
	}

	public void convert(List<Mirror> wrappedData) {
		int size = wrappedData.size();
		listModel = new ArrayList<DotModel>();
		for (int i = 0; i < size; i++) {
			Mirror cm = wrappedData.get(i);
			add(cm);
		}
	}
}