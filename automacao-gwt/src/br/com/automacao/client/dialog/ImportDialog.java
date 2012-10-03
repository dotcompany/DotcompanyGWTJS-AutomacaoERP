package br.com.automacao.client.dialog;

import java.util.ArrayList;
import java.util.List;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.shared.model.DotModel;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public class ImportDialog<M extends DotModel> extends Dialog {

	private ContentPanel panelGrid;
	
	private Grid<M> grid;
	private ListStore<M> store;
	private ColumnModel cm;
	private ToolBar toolBar;
	
	private Button add;
	private Button rem;
	private Button clr;
	private Button send;
	private Button close;
	
	public ImportDialog() {
		setWidth(600);
		setModal(true);
		setButtons("");
		setHeading("Janela de Importação de Arquivos");
		buildColumnsConfig();
		buildButtons();
		buildToolbar();
		buildGrid();
		buildPanelGrid();
		add(panelGrid);
	}
	
	private void buildToolbar() {
		toolBar = new ToolBar();
		
		toolBar.add(add);
		toolBar.add(rem);
		toolBar.add(clr);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(send);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(close);
	}

	private void buildButtons() {
		add = new Button("Adicionar", DesktopApp.IMG.img_add());
		rem = new Button("Remover", DesktopApp.IMG.img_remove());
		clr = new Button("Limpar", DesktopApp.IMG.img_clear());
		send = new Button("Enviar", DesktopApp.IMG.img_send());
		close = new Button("Fechar", DesktopApp.IMG.img_close());
		
		add.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
			}
		});
		
		rem.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
			}
		});
		
		clr.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
			}
		});
		
		send.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
			}
		});
		
		close.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
			}
		});
	}

	private void buildGrid() {
		store = new ListStore<M>();
		grid = new Grid<M>(store, cm);
		grid.setAutoHeight(false);
		grid.setAutoWidth(false);
		grid.setHeight(350);
		grid.setWidth(700);
		grid.addListener(Events.Attach, new Listener<GridEvent<M>>() {
			public void handleEvent(GridEvent<M> be) {
				
			}
		});

		grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		grid.getSelectionModel().addListener(Events.SelectionChange,
				new Listener<SelectionChangedEvent<M>>() {
					public void handleEvent(SelectionChangedEvent<M> be) {
					}
				});

		grid.setBorders(false);
	}

	private void buildPanelGrid() {
		panelGrid = new FormPanel();
		panelGrid.setFrame(true);
		panelGrid.setCollapsible(false);
		panelGrid.setAnimCollapse(false);
		panelGrid.setIcon(DesktopApp.IMG.img_table());
		panelGrid.setLayout(new FitLayout());
		panelGrid.setBorders(true);
		panelGrid.add(grid);
		panelGrid.setAutoWidth(true);
		panelGrid.setAutoHeight(true);
		panelGrid.setBottomComponent(toolBar);
        panelGrid.setHeight(450);
        panelGrid.setWidth(450);
	}
	
	public void buildColumnsConfig() {
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		columns.add(new ColumnConfig("status", "Status", 55));
		columns.add(new ColumnConfig("nome", "Nome Arquivo", 255));
		columns.add(new ColumnConfig("nota", "Nota", 100));
		cm = new ColumnModel(columns);
	}
}