package br.com.automacao.shared.util;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

public class ComboCheckBoxUtils<C extends Combo> extends ComboBoxUtils<C> {

	private String checkBoxSelector = ".x-view-item-checkbox";

	@SuppressWarnings("unchecked")
	public List<C> getChecked() {
		super.expand();
		if (rendered) {
			List<C> l = new ArrayList<C>();
			NodeList<Element> nodes = el().select(checkBoxSelector);
			for (int i = 0; i < nodes.getLength(); i++) {
				if (com.google.gwt.dom.client.Element.is(nodes.getItem(i))) {
					InputElement e = InputElement.as(nodes.getItem(i));
					if (e.isChecked()) {
						l.add(getStore().getAt(i));
					}
				}
			}
			return l;
		} else {
			if (states.getModels() == null)
				states.add((List<? extends C>) new ArrayList<Combo>());
			return states.getModels();
		}
	}
	
	@Override
	public void onBrowserEvent(Event event) {
	    if (disabled && event.getTypeInt() == Event.ONCLICK && com.google.gwt.dom.client.Element.is(event.getEventTarget())
	        && fly((Element) com.google.gwt.dom.client.Element.as(event.getEventTarget())).is(checkBoxSelector)) {
	      event.preventDefault();
	    }
	    super.onBrowserEvent(event);
	  }

	  public void refresh() {
	    List<C> checked = getChecked();
//	    super.refresh();
	    if (states.getModels() != null) {
	      for (C m : states.getModels()) {
	        setChecked(m, true);
	      }
	      states.removeAll();
	    } else if (checked != null) {
	      for (C m : checked) {
	        setChecked(m, true);
	      }
	    }
	  }
	  
	/**
	   * Selects a specific item in the view
	   * 
	   * @param m the modeldata that should be checked
	   * @param checked true to check
	   */
	  public void setChecked(C m, boolean checked) {
	    if (rendered) {
	      NodeList<Element> nodes = el().select(checkBoxSelector);
	      int index = store.indexOf(m);
	      if (index != -1) {
	        Element e = nodes.getItem(index);
	        if (com.google.gwt.dom.client.Element.is(e)) {
	          InputElement i = InputElement.as(e);
	          i.setChecked(checked);
	        }
	      }
	    } else {
	      if (states.getModels() == null) {
	        states.add(new ArrayList<C>());
	      }
	      if (checked) {
	        if (!states.getModels().contains(m)) {
	        	states.getModels().add(m);
	        }
	      } else {
	    	  states.getModels().remove(m);
	      }
	    }
	  }
	
	
	@Override
	protected void onRender(Element target, int index) {
		if (getTemplate() == null) {
			String spacing = GXT.isIE && !GXT.isStrict ? "0" : "3";
			setTemplate(XTemplate
					.create("<tpl for=\".\"><div class='x-view-item x-view-item-check'><table cellspacing='"
							+ spacing
							+ "' cellpadding=0><tr><td><input class=\"x-view-item-checkbox\" type=\"checkbox\" /></td><td><td>{"
							+ getDisplayField()
							+ "}</td></tr></table></div></tpl>"));
		}
		super.onRender(target, index);
	}
}