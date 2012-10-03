package br.com.automacao.client.widget;

import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.google.gwt.user.client.ui.Composite;

public class MenuWidget extends Composite{

	private ContentPanel panel 	= new ContentPanel();
	private MenuBar bar 		= new MenuBar();
	
	public MenuWidget() {
		initWidget(panel);
		initialize();
	}

	private void initialize() {
		initPanel();
		loadMenuBar();
	}

	private void loadMenuBar() {
		bar.setBorders(false);  
		bar.setStyleAttribute("borderTop", "none");
		configureMenuBar();
	}

	private void configureMenuBar() {
		Menu menuFile = new Menu();
		MenuItem menuItemTransfer = new MenuItem("Transferir arquivos");
		menuItemTransfer.addSelectionListener(new SelectionListener<MenuEvent>() {
			@Override
			public void componentSelected(MenuEvent ce) {
				
			}
		});
		
		MenuItem menuItemClose = new MenuItem("Sair");
		
		menuFile.add(menuItemTransfer);
		menuFile.add(new SeparatorMenuItem());
		menuFile.add(menuItemClose);
		
		MenuBarItem menuBarItemFile = new MenuBarItem("Arquivos", menuFile);
		
		bar.add(menuBarItemFile);
		panel.setTopComponent(bar);
	}

	private void initPanel() {
		panel.setHeading("Transporte de arquivo");
		panel.setHeaderVisible(true);
		panel.setSize("100%", "100%");
	}
}
