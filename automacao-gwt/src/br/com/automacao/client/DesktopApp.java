/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package br.com.automacao.client;

import java.util.Map;

import br.com.automacao.client.dialog.ImportDialog;
import br.com.automacao.client.dialog.LoginDialog;
import br.com.automacao.client.internacionalizacao.PtBr;
import br.com.automacao.client.widget.DotAutoComplete;
import br.com.automacao.client.widget.formulario.dinamico.GeradorFormularioWidget;
import br.com.automacao.client.widget.grid.GridBase;
import br.com.automacao.client.widget.grid.proxy.DotProxy;
import br.com.automacao.client.widget.grid.proxy.DotRpcProxy;
import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.mirror.MarcaMirror;
import br.com.automacao.shared.mirror.ModelosMirror;
import br.com.automacao.shared.model.ColaboradorModel;
import br.com.automacao.shared.model.DotModel;
import br.com.automacao.shared.model.EmpresaModel;
import br.com.automacao.shared.model.MarcaModel;
import br.com.automacao.shared.model.ModelosModel;
import br.com.automacao.shared.model.ProdutoModel;

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
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
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

	public final static PtBr CONST = (PtBr)GWT.create(PtBr.class);
	private GridBase<EmpresaModel, EmpresaMirror> gridEmp;
	private GridBase<ColaboradorModel, ColaboradorMirror> gridColab;
	private GridBase<ModelosModel, ModelosMirror> gridModelos;
	private GridBase<MarcaModel, MarcaMirror> gridMarcas;

	

	public static final String USUARIO     = "user";
	
	public DesktopApp() {}

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
			//TODO: REVER AQUI 
			w.show();
		} else {
			w.toFront();
		}
	}

	public void onModuleLoad() {
		getServiceGenerics().loadApp(new AsyncCallback<Map<String,String>>() {
			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(Map<String, String> result) {
				DotProperties.load(result);
				if(DotProperties.isDebugMode()){
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
		
		FileColumn fc = new FileColumn("8877yhg", EmpresaMirror.class.getName());
		EmpresaModel em = new EmpresaModel(fc);
		
		final DotProxy proxyEmpresa = new DotRpcProxy<EmpresaModel>(fc, em);
		
		gridEmp = new GridBase<EmpresaModel, EmpresaMirror>(proxyEmpresa, fc, "Cadastro Empresa");
		
		Shortcut s3 = new Shortcut();
		s3.setText("Empresa");
		s3.setId("grid-win-shortcut");
		s3.setIcon(IMG.img_empresa()); 
		s3.setData("window", gridEmp);
		s3.addSelectionListener(shortcutListener);
		desktop.addShortcut(s3);
				
		FileColumn fcColab = new FileColumn("11111111112", ColaboradorMirror.class.getName());
		ColaboradorModel cm = new ColaboradorModel(fcColab);
		
		final DotProxy proxyColaborador = new DotRpcProxy<ColaboradorModel>(fcColab, cm);

		gridColab = new GridBase<ColaboradorModel, ColaboradorMirror>(proxyColaborador, fcColab, "Cadastro Colaborador");

		Shortcut sColab = new Shortcut();
		sColab.setText("Colaborador");
		sColab.setId("grid-win-shortcut");
		sColab.setIcon(IMG.img_colaborador());
		sColab.setData("window", gridColab);
		sColab.addSelectionListener(shortcutListener);
		desktop.addShortcut(sColab);
				
		FileColumn fcMarca = new FileColumn("1180sd1123", MarcaMirror.class.getName());
		MarcaModel mapm = new MarcaModel(fcMarca);
		final DotProxy proxyMarca = new DotRpcProxy<MarcaModel>(fcMarca, mapm);
		gridMarcas = new GridBase<MarcaModel, MarcaMirror>(proxyMarca, fcMarca, "Cadastro Marca");
		
		FileColumn fcModelos = new FileColumn("1180Modelossd1123", ModelosMirror.class.getName());
		ModelosModel mopm = new ModelosModel(fcModelos);
		final DotProxy proxyModelos = new DotRpcProxy<ModelosModel>(fcModelos, mopm);
		gridModelos = new GridBase<ModelosModel, ModelosMirror>(proxyModelos, fcModelos, "Cadastro Modelos");
		
		
		Shortcut sModelos = new Shortcut();
		sModelos.setText("Modelos");
		sModelos.setId("grid-win-shortcut");
		sModelos.setIcon(IMG.img_colaborador());
		sModelos.setData("window", gridModelos);
		sModelos.addSelectionListener(shortcutListener);
		desktop.addShortcut(sModelos);

		Shortcut Marca = new Shortcut();
		Marca.setText("Cadastro de Marca");
		Marca.setId("grid-win-shortcut");
		Marca.setIcon(IMG.img_usuario());
		Marca.setData("window", gridMarcas);
		Marca.addSelectionListener(shortcutListener);
		desktop.addShortcut(Marca);
	
		final GeradorFormularioWidget gerador = new GeradorFormularioWidget("Cadastro");
		
		Shortcut s5 = new Shortcut();
		s5.setText("Formulario Teste");
		s5.setId("grid-win-shortcut");
		s5.setIcon(IMG.img_folder());
		s5.setData("window", gerador);
		s5.addSelectionListener(shortcutListener);
		desktop.addShortcut(Marca);

		final FormPanel fp = new FormPanel();
		final Window w = new Window();
		fp.setLayout(new FitLayout());
		w.setWidth(800);
		fp.setWidth(700);
		
		FileUploadField upload = new FileUploadField();
		upload.setName("teste");
		fp.add(upload);
		Button b = new Button("Submit");
		fp.addButton(b);
		w.add(fp);
		
		Shortcut s6 = new Shortcut();
		s6.setText("Auto Complete");
		s6.setId("grid-win-shortcut");
		s6.setIcon(IMG.img_folder());
		
		Shortcut s8 = new Shortcut();
		s8.setText("Auto Complete");
		s8.setId("grid-win-shortcut");
		s8.setIcon(IMG.img_folder());
		
		Shortcut s9 = new Shortcut();
		s9.setText("Auto Complete");
		s9.setId("grid-win-shortcut");
		s9.setIcon(IMG.img_folder());
		
		Shortcut s10 = new Shortcut();
		s10.setText("Auto Complete");
		s10.setId("grid-win-shortcut");
		s10.setIcon(IMG.img_folder());
		
		Shortcut s11 = new Shortcut();
		s11.setText("Auto Complete");
		s11.setId("grid-win-shortcut");
		s11.setIcon(IMG.img_folder());
		
		Shortcut s12 = new Shortcut();
		s12.setText("Auto Complete");
		s12.setId("grid-win-shortcut");
		s12.setIcon(IMG.img_folder());
		
		Shortcut s13 = new Shortcut();
		s13.setText("Auto Complete");
		s13.setId("grid-win-shortcut");
		s13.setIcon(IMG.img_folder());
		
		
		final DotAutoComplete<ColaboradorModel> ac = new DotAutoComplete<ColaboradorModel>(ColaboradorMirror.class, new ColaboradorModel());
//		ac.getWidget()
		s6.setData("window", w);
		s6.addSelectionListener(new SelectionListener<ComponentEvent>() {
			@Override
			public void componentSelected(ComponentEvent ce) {
				fp.add(ac.getWidget());
			}
		});
		
		
		s6.addSelectionListener(shortcutListener);
		desktop.addShortcut(s6);
		
		
		Shortcut s7 = new Shortcut();
		s7.setText("Import");
		s7.setId("grid-win-shortcut");
		s7.setIcon(IMG.img_upload1());
		s7.setData("window", new ImportDialog<DotModel>());
		s7.addSelectionListener(shortcutListener);
		desktop.addShortcut(s7);
		
		TaskBar taskBar = desktop.getTaskBar();

		StartMenu menu = taskBar.getStartMenu();
		menu.setHeading("Pedro IDesconhecido");
		menu.setIconStyle("user");

		MenuItem menuItem = new MenuItem("Semed");
		menuItem.setIcon(IMG.img_medicina_pequeno());
		menuItem.addSelectionListener(menuListener);
		menu.add(menuItem);
		
		MenuItem menuItem3 = new MenuItem("Colaborador");
		menuItem3.setIcon(IMG.img_colaborador_pequeno());
		menuItem3.setData("window", gridColab);
		menuItem3.addSelectionListener(menuListener);
		menu.add(menuItem3);
		
		MenuItem menuItem4 = new MenuItem("Empresa");
		menuItem4.setIcon(IMG.img_empresa_pequeno());
		menuItem4.setData("window", gridEmp);
		menuItem4.addSelectionListener(menuListener);
		menu.add(menuItem4);

		MenuItem menuItem6 = new MenuItem("Marca");
		menuItem6.setIcon(IMG.img_empresa_pequeno());
		menuItem6.setData("window", gridMarcas);
		menuItem6.addSelectionListener(menuListener);
		menu.add(menuItem6);

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