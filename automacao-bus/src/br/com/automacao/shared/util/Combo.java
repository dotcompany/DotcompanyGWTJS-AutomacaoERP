package br.com.automacao.shared.util;

import com.extjs.gxt.ui.client.data.BaseModelData;

@SuppressWarnings("serial")
public class Combo extends BaseModelData{
	public Combo() { }
	public Combo(String label, Object st) {
	    setSt(label, st);
	}
	private void setSt(String label, Object st) {
		set("COMBO_OBJ", st);
		setName(label);
	}
	private void setName(String name) {
		set("label", name);
	}
	public Object getItem() {
		return get("COMBO_OBJ");
	}
	public String getName() {
		return get("label");
	}
}