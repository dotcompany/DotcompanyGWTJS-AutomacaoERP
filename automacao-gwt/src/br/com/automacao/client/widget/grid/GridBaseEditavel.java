package br.com.automacao.client.widget.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.dialog.MsgDialog;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.grid.proxy.DotProxy;
import br.com.automacao.client.widget.plugin.DotSearchTextField;
import br.com.automacao.shared.fo.Column;
import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.model.DotModel;
import br.com.automacao.shared.type.DirecaoType;
import br.com.automacao.shared.util.ExportacaoListagem;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BaseFilterPagingLoadConfig;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.FilterPagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.SplitButton;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.RowEditor;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.filters.GridFilters;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;

@SuppressWarnings("unchecked")
public class GridBaseEditavel<M extends DotModel, T extends Mirror> extends LayoutContainer {

	private final static int QTD_GRID = 20;
	
	private ColumnModel cm;
	private PagingLoader<PagingLoadResult<PagingLoadResult<M>>> loader;
	private ListStore<M> store;
	private RowEditor<M> re;
	private EditorGrid<M> grid;
	private FilterPagingLoadConfig config 	= new BaseFilterPagingLoadConfig();
	private final PagingToolBar toolBar 	= new PagingToolBar(QTD_GRID);
	private ContentPanel panelGrid;
	private GridFilters filters;
	
	private FileColumn fileColumn;

	private final DotProxy dotProxy;
	private final RpcProxy rpcProxy;

	private ToolBar toolBarTop;
	private DotSearchTextField<String> txtFinderAll;

	private Mirror dto;
	
	private SplitButton newButton 	= new SplitButton(DesktopApp.CONST.novo());
	private Menu newMenu 			= new Menu();
	private MenuItem menuDuplicate 	= new MenuItem(DesktopApp.CONST.duplicar(), DesktopApp.IMG.img_duplicate());
	private Button remButton 		= new Button(DesktopApp.CONST.remover(), DesktopApp.IMG.img_remove());
	
	private Button favoritosButton 	= new Button(DesktopApp.CONST.favoritos(), DesktopApp.IMG.img_favorites());
	private Button helpButton 		= new Button(null, DesktopApp.IMG.img_help());
	private Button printButton 		= new Button(DesktopApp.CONST.imprimir(), DesktopApp.IMG.img_print());
	
	private Menu menuImport;
	private Button importButton 	= new Button(DesktopApp.CONST.importar(), DesktopApp.IMG.img_base_import());
	private Menu menuExport;
	private Button exportButton 	= new Button(DesktopApp.CONST.exportar(), DesktopApp.IMG.img_base_export());
	private MenuItem menuPdf 		= new MenuItem(DesktopApp.CONST.pdf(), DesktopApp.IMG.img_pdf());
	private MenuItem menuCsv 		= new MenuItem(DesktopApp.CONST.csv(), DesktopApp.IMG.img_csv());
	private MenuItem menuHtml 		= new MenuItem(DesktopApp.CONST.html(), DesktopApp.IMG.img_html());
	private MenuItem menuXls 		= new MenuItem(DesktopApp.CONST.xls(), DesktopApp.IMG.img_xls());
	
//	private Button saveGridButton = new Button(null, DesktopApp.IMG.img_save());

	private DotFormulario formulario;
	
	private final String nameClasse;
	
	public GridBaseEditavel(DotProxy dotProxy, FileColumn fc,DotFormulario formulario) {
		this.dotProxy = dotProxy;
		this.rpcProxy = dotProxy.getRpcProxy();
		this.fileColumn = fc;
		this.nameClasse = fc.getNameClasse();
		this.formulario = formulario;
		filters = new GridFilters();
		onLoadGrid();
	}
	
	protected void onLoadGrid() {
		DesktopApp.getServiceGrid().loadState(fileColumn, new AsyncCallback<FileColumn>() {
			@Override
			public void onFailure(Throwable caught) {}

			@Override
			public void onSuccess(FileColumn result) {
				beforeLoad(result);
				buildColumnsConfig(result);
				buildToolBarTop();
				loader = new BasePagingLoader<PagingLoadResult<PagingLoadResult<M>>>(rpcProxy) {
					@Override
					protected Object newLoadConfig() {
						BasePagingLoadConfig config = new BaseFilterPagingLoadConfig();
						return config;
					}
				};
				run();
				layout();
			}
		});
	}
	
	private void beforeLoad(FileColumn fileColumn) {
		if(fileColumn != null && fileColumn.getHeight() != 0){
			super.setHeight(fileColumn.getHeight());
			super.setWidth(fileColumn.getWidth());
			super.setPosition(fileColumn.getPositionY(), fileColumn.getPositionX());
			//super.setHeaderVisible(false);	
		}
	}
	
	private void menuAdd() {
		newButton.setIcon(DesktopApp.IMG.img_add());
		newMenu.add(menuDuplicate);
		newButton.setMenu(newMenu);
	}

	private void buildMenuExportAndImport() {
		menuImport = new Menu();
		menuImport.add(menuXls);
		menuImport.add(menuCsv);
		importButton.setMenu(menuImport);
		
		menuExport = new Menu();
		menuExport.add(menuPdf);  
		menuExport.add(menuCsv);  
		menuExport.add(menuXls);  
		menuExport.add(menuHtml);  
		exportButton.setMenu(menuExport); 
	}

	private void buildToolBarTop() {
		menuAdd();
		buildMenuExportAndImport();
		buildButtons();
		buildMenusButtons();
		buildTxtFinderAll();
		toolBarTop = new ToolBar();
		
		toolBarTop.add(newButton);
//		toolBarTop.add(editButton);
		toolBarTop.add(remButton);
		toolBarTop.add(new SeparatorToolItem());
		toolBarTop.add(importButton);
		toolBarTop.add(exportButton);
		toolBarTop.add(printButton);
		toolBarTop.add(new SeparatorToolItem());
		toolBarTop.add(favoritosButton);
		toolBarTop.add(new SeparatorToolItem());
		helpButton.setToolTip(DesktopApp.CONST.clique_video_aula());
		toolBarTop.add(helpButton);
//		toolBarTop.add(new SeparatorToolItem());
//		saveGridButton.setToolTip(DesktopApp.CONST.grid_salvar());
//		toolBarTop.add(saveGridButton);
		toolBarTop.add(new SeparatorToolItem());
		toolBarTop.add(txtFinderAll);
	}

	private void buildTxtFinderAll() {
		txtFinderAll = new DotSearchTextField<String>();
		KeyListener keyListener = new KeyListener() {
			public void componentKeyUp(ComponentEvent event) {
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					dotProxy.actionEnter(txtFinderAll.getValue());
					loader.load(config);
				}
			}
		};
		txtFinderAll.setEmptyText(DesktopApp.CONST.pesquisar());
		txtFinderAll.addKeyListener(keyListener);
	}

	// voltarei mais tarde aqui
	public void run() {
		store = new ListStore<M>(loader);
		buildGrid();
		buildPanelGrid();
		setHeight(500);
		setWidth(800);
		setLayout(new FitLayout());
		add(panelGrid);
	}

	private void buildGrid() {
		re = new RowEditor<M>();
		grid = new EditorGrid<M>(store, cm);		
		grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
		grid.setLayoutData(new AbsoluteData());
		grid.addPlugin(re);
		/*grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				GridEvent ge = (GridEvent)be;
				M model = (M)ge.getModel();
				dto = model.getTO();
				change2Formulario();
			}
		});*/ 
	    
		grid.addListener(Events.ColumnResize, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				saveGridState();
			}
		});
		grid.addListener(Events.ColumnMove, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				saveGridState();
			}
		});
		grid.addListener(Events.Attach, new Listener<GridEvent<M>>() {
			public void handleEvent(GridEvent<M> be) {
				config.setOffset(0);
				config.setLimit(QTD_GRID);

				Map<String, Object> state = grid.getState();
				if (state.containsKey("offset")) {
					int offset = (Integer) state.get("offset");
					int limit = (Integer) state.get("limit");
					config.setOffset(offset);
					config.setLimit(limit);
				}
				if (state.containsKey("sortField")) {
					config.setSortField((String) state.get("sortField"));
					config.setSortDir(SortDir.valueOf((String) state
							.get("sortDir")));
				}
				int qtdColunas = be.getGrid().getColumnModel().getColumnCount();
				 for (int cont = 0; cont < qtdColunas; cont++) {
					be.getGrid().getColumnModel().getColumn(cont).setEditor(new CellEditor(new DotTextField<String>()));						
				 }						
				loader.load(config);
			}
		});

		grid.getSelectionModel().setSelectionMode(SelectionMode.MULTI);
		grid.getSelectionModel().addListener(Events.SelectionChange,
				new Listener<SelectionChangedEvent<M>>() {
					public void handleEvent(SelectionChangedEvent<M> be) {
						if (be.getSelection().size() > 0) {
							dto = ((DotModel)be.getSelectedItem()).getTO();
						} else {
							// voltar
						}
					}
				});
		grid.setLoadMask(true);
		grid.setBorders(false);
		grid.addPlugin(filters);
		toolBar.bind(loader);
	}

	private void buildPanelGrid() {
		panelGrid = new ContentPanel();
		panelGrid.setFrame(true);
		panelGrid.setCollapsible(false);
		panelGrid.setAnimCollapse(false);
//		panelGrid.setEncoding(Encoding.URLENCODED);
//		panelGrid.setIcon(DesktopApp.IMG.img_table());
		panelGrid.setHeaderVisible(false);
		panelGrid.setLayout(new FitLayout());
		panelGrid.setBorders(true);
		panelGrid.add(grid);
//		panelGrid.setAutoWidth(true);
//		panelGrid.setAutoHeight(true);
		panelGrid.setTopComponent(toolBarTop);
		panelGrid.setBottomComponent(toolBar);
//        panelGrid.setMethod(Method.POST);
        panelGrid.setHeight(450);
        panelGrid.setWidth(750);
	}

	public void buildColumnsConfig(FileColumn fileColumn) {
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		int cont = 0;
		for (Column col : fileColumn.getColunas()) {
			int size = (col.getSize() == 0) ? size = col.getLabel().length() * 25: col.getSize() ;
			ColumnConfig cc = new ColumnConfig(col.getNome(), col.getLabel(),
						size);
			cc.setHidden(!col.getAtivo());
			
			columns.add(cc);
			cont++;
		}
		cm = new ColumnModel(columns);
		buildColumnsFilters(fileColumn);
	}

	private void buildColumnsFilters(FileColumn fileColumn) {
		ManagerFilters.generate(filters, fileColumn);
	}

	private void buildButtons(){
		remButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(dto != null){
					formulario.remove(dto, ce, loader);
				} else
					MsgDialog.info("Selecione", "Nenhuma linha do grid foi selecionada!");
			}	
		});

		newButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				M model = store.getAt(1);
				re.stopEditing(false);
			    store.add(model);
			    re.startEditing(store.indexOf(model),true);
			}
		});
		
//		saveGridButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				saveGridState();
//			}
//		});
	}
	
	
	private void saveGridState() {
		Map<Integer, Column> map = new HashMap<Integer, Column>();
		int size = fileColumn.size();
		for(Column col : fileColumn.getColunas()){
			ColumnConfig cc = cm.getColumnById(col.getNome());
			int index = cm.getIndexById(col.getNome());
			col.setSize(cc.getWidth());
			if(cc.isHidden()){
				col.setAtivo(false);
			}
			col.setPosicao(index);
			map.put(index, col);
		}
		fileColumn.clear();
		for(int cont = 0; cont < size; cont++){
			Column col = map.get(cont);
			fileColumn.addColumn(col);
		}
			
		fileColumn.setWidth(super.getWidth());
		fileColumn.setHeight(super.getHeight());
		Point point = super.getPosition(true);
		fileColumn.setPositionX(point.x);
		fileColumn.setPositionY(point.y);
		
		DesktopApp.getServiceGrid().saveState(fileColumn, new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(Void result) {
				
			}
		});
	}
	
	private void buildMenusButtons() {
		menuCsv.addSelectionListener(new SelectionListener<MenuEvent>() {
			@Override
			public void componentSelected(MenuEvent ce) {
				
				final List<String> ids = new ArrayList<String>(); 
		        for (int a = 0; a < grid.getColumnModel()
		                .getColumnCount(); a++) {
		        	if(!grid.getColumnModel().isHidden(a)){
		        		ids.add(grid.getColumnModel().getColumn(a).getId());
		        	}
		        }
			}
		});
	}
	
	@SuppressWarnings("unused")
	private ExportacaoListagem populate() {
		
		int size = store.getCount();
		Integer[] tamanhos = new Integer[size];
		String[] rotulos = new String[size];
		
		for (int i = 0; i < size; i++) {
			if (!grid.getColumnModel().isHidden(i)) {
				tamanhos[i] = grid.getColumnModel().getColumnWidth(i);
				rotulos[i] = grid.getColumnModel().getColumnHeader(i);
				
				
				if (grid.getColumnModel().getColumn(i) instanceof SummaryColumnConfig) {
					SummaryColumnConfig col = (SummaryColumnConfig) grid.getColumnModel().getColumn(i);
					String tp = col.getSummaryType().equals("average") ? "AVG" : "";
				}
			}
		}
		
		ExportacaoListagem exp = new ExportacaoListagem();
		exp.setUnidade(new EmpresaMirror());
		
		exp.setDirecao(DirecaoType.ASC);
		exp.setTamanhos(tamanhos);
		exp.setRotulos(rotulos);
		exp.setNome("Empresas");
		exp.setInicio(0);
		exp.setLimite(2);
		exp.setDados(new String[][]{});
		
		return exp;
	}
	
	@Override
	protected void onHide() {
		saveGridState();
		super.onHide();
	}
	
	
	public void beforeHide() {
		saveGridState();
		remove(panelGrid);
		panelGrid.remove(grid);
		super.onHide();
	}
	
	public void updateGrid() {
		grid.recalculate();
		panelGrid.layout(true);
		layout(true);
	}
	
}