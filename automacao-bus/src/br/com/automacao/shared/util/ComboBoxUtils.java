package br.com.automacao.shared.util;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;

public class ComboBoxUtils<C extends Combo> extends ComboUtils<C>{

	@SuppressWarnings("unchecked")
	public final <T extends Enum> void buildInput(LayoutContainer fs, String label, int _left, int _top, Object _width, Object _height, Class<T> t, int _tabIndex){
		List<Combo> listCombo = getItensEnum(t);
		createComboBox(fs, label, _left, _top, _width, _height,listCombo, _tabIndex);
	}

	public final void createComboBox(LayoutContainer fs, String label, int _left, int _top, Object _width, Object _height, List<Combo> itens, int _tabIndex){
		Text txt = new Text(label);
		fs.add(txt, new AbsoluteData(_left, _top-16));
		fs.add(this, new AbsoluteData(_left, _top));
		this.setSize((String)_width, (String)_height);
		this.setName(txt.getText());
	    addList(itens);
	    this.setEmptyText("-- Selecione --");
	    this.setDisplayField("label");
	    this.setStore(states);
	    this.setTriggerAction(TriggerAction.ALL);
	    this.setTabIndex(_tabIndex);
	}
	
	@SuppressWarnings("unchecked")
	public final void addList(List<Combo> itens){
		if(states.getModels() != null && states.getModels().size() > 0)
			this.states.removeAll();
		states.add((List) itens);
		this.setStore(states);
		this.getListView().setStore(states);
		
		this.recalculate();
	}
	
	public final void createComboBoxEmpty(LayoutContainer fs, String label, int _left, int _top, Object _width, Object _height, int _tabIndex){
		createComboBox(fs, label, _left, _top, _width, _height, new ArrayList<Combo>(), _tabIndex);
	}
	
	public final <T extends Enum<?>> Combo itnComboEnum(Class<T> t, String name){
		for (Combo e : getItensEnum(t)) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}