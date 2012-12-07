/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package br.com.automacao.client;

import java.util.Map;

import br.com.automacao.client.dialog.LoginDialog;
import br.com.automacao.client.internacionalizacao.PtBr;
import br.com.automacao.client.widget.grid.GridBase;
import br.com.automacao.client.widget.grid.proxy.DotProxy;
import br.com.automacao.client.widget.grid.proxy.DotRpcProxy;
import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.model.EmpresaModel;

import com.extjs.gxt.desktop.client.Desktop;
import com.extjs.gxt.desktop.client.Shortcut;
import com.extjs.gxt.desktop.client.StartMenu;
import com.extjs.gxt.desktop.client.TaskBar;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Mukissa
 * 
 */
public class DesktopApp extends ActionServer implements EntryPoint {

	private Desktop desktop;

	public final static PtBr CONST = (PtBr) GWT.create(PtBr.class);
	private GridBase<EmpresaModel, EmpresaMirror> gridEmp;

	public static final String USUARIO = "user";

	public DesktopApp() {
	}

	public final static DesktopImages IMG = GWT.create(DesktopImages.class);

	private void itemSelected(ComponentEvent ce) {
		Window w;
		if (ce instanceof MenuEvent) {
			MenuEvent me = (MenuEvent) ce;
			w = me.getItem().getData("window");
		} else {
			w = ce.getComponent().getData("window");
		}
		if (!desktop.getWindows().contains(w)) {
			desktop.addWindow(w);
		}
		if (w != null && !w.isVisible()) {
			// TODO: REVER AQUI
			w.show();
		} else {
			w.toFront();
		}
	}
	public void onModuleLoad() {
		getServiceGenerics().loadApp(new AsyncCallback<Map<String, String>>() {
			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(Map<String, String> result) {
				DotProperties.load(result);
				if (DotProperties.isDebugMode()) {
					LoginDialog ld = new LoginDialog();
					ld.show();
				} else
					initizalize();
			}
		});
	}

	public void initizalize() {
		desktop = new Desktop();
		SelectionListener<MenuEvent> menuListener = new SelectionListener<MenuEvent>() {
			@Override
			public void componentSelected(MenuEvent me) {
				itemSelected(me);
			}
		};

		SelectionListener<ComponentEvent> shortcutListener = new SelectionListener<ComponentEvent>() {
			@Override
			public void componentSelected(ComponentEvent ce) {
				itemSelected(ce);
			}
		};
		final FormPanel fp = new FormPanel();
		final Window w = new Window();
		fp.setLayout(new FitLayout());
		w.setWidth(800);
		fp.setWidth(700);
/****************************************************Base************************************************************************/
		/*******************************************Empresa*************************************************/
		FileColumn fc = new FileColumn("8877yhg", EmpresaMirror.class.getName());
		EmpresaModel em = new EmpresaModel(fc);
		final DotProxy proxyEmpresa = new DotRpcProxy<EmpresaModel>(fc, em);
		gridEmp = new GridBase<EmpresaModel, EmpresaMirror>(proxyEmpresa,fc,"Cadastro Empresa");
		Shortcut s3 = new Shortcut();
		s3.setText("Empresa");
		s3.setId("grid-win-shortcut");
		s3.setIcon(IMG.img_empresa());
		s3.setData("window", gridEmp);
		s3.addSelectionListener(shortcutListener);
		desktop.addShortcut(s3);
/*******************************************************************************************************/
		TaskBar taskBar = desktop.getTaskBar();
		StartMenu menu = taskBar.getStartMenu();
		menu.setHeading("Pedro IDesconhecido");
		menu.setIconStyle("user");


		MenuItem menuItem4 = new MenuItem("Empresa");
		menuItem4.setIcon(IMG.img_empresa_pequeno());
		menuItem4.setData("window", gridEmp);
		menuItem4.addSelectionListener(menuListener);
		menu.add(menuItem4);

		// tools
		MenuItem tool = new MenuItem("Settings");
		tool = new MenuItem("Sair");
		tool.setIcon(IMG.img_exit());
		tool.addSelectionListener(new SelectionListener<MenuEvent>() {
			@Override
			public void componentSelected(MenuEvent ce) {
				Info.display("Evento", "O Botao 'Sair' foi clicado");
			}
		});
		menu.addTool(tool);
		tool = new MenuItem("Settings");
		tool.setIcon(IconHelper.createStyle("logout"));
		tool.addSelectionListener(new SelectionListener<MenuEvent>() {
			@Override
			public void componentSelected(MenuEvent ce) {
				Info.display("Evento", "O Botao 'Settings' foi clicado");
			}
		});
		menu.addTool(tool);
		tool = new MenuItem("Usuario");
		tool.setIcon(IMG.img_user_pequeno());
		tool.addSelectionListener(menuListener);
		menu.addTool(tool);
	}

	public static native int getHeight()/*-{
		return screen.availHeight;
	}-*/;

}