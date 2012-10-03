package br.com.automacao.shared.util;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

@SuppressWarnings("unchecked")
public class ListUtil implements IsSerializable{
	
	private List list;
	private int rows;

	protected ListUtil() {
		super();
	}

	public ListUtil(List listModel, int rowsCount) {
		super();
		list = listModel;
		rows = rowsCount;
	}

	public int getRowCount(){
		return rows;
	}
	
	public List getWrappedData() {
		return list;
	}
}