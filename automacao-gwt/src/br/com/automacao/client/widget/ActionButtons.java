package br.com.automacao.client.widget;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;

public interface ActionButtons {
	
	public SelectionListener<ButtonEvent> actionSave();
	public SelectionListener<ButtonEvent> actionIncluir();
	public SelectionListener<ButtonEvent> actionCancel();
	public SelectionListener<ButtonEvent> actionClear();
	public SelectionListener<MenuEvent> actionSaveNew();
	public SelectionListener<MenuEvent> actionSaveDuplicate();
}