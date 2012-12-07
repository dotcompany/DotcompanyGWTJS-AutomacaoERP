package br.com.automacao.client.widget.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.widget.DotFormulario;
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
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.FilterPagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.filters.GridFilters;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;

@SuppressWarnings("unchecked")
public class GridSimples<M extends DotModel, T extends Mirror> extends ContentPanel {

	private final static int QTD_GRID = 20;
	
	private ColumnModel cm;
	private PagingLoader<PagingLoadResult<PagingLoadResult<M>>> loader;
	private ListStore<M> store;
	private Grid<M> grid;
	private FilterPagingLoadConfig config 	= new BaseFilterPagingLoadConfig();
	private final PagingToolBar toolBar 	= new PagingToolBar(QTD_GRID);
	private ContentPanel panelGrid;
	private GridFilters filters;
	
	private int autoMin;
	
	private FileColumn fileColumn;

	private final DotProxy dotProxy;
	private final RpcProxy rpcProxy;

	private DotSearchTextField<String> txtFinderAll;

	private Mirror dto;
	private int height;
	private int width;
	
	private DotFormulario formulario;
	
	private final String nameClasse;
	
	public GridSimples(DotProxy dotProxy, FileColumn fc,DotFormulario formulario,int height,int width) {
		super();
		this.dotProxy = dotProxy;
		this.rpcProxy = dotProxy.getRpcProxy();
		this.fileColumn = fc;
		this.nameClasse = fc.getNameClasse();
		this.formulario = formulario;
		this.height = height;
		this.width = width;
		filters = new GridFilters();
		onLoadGrid();
	}
	public GridSimples(DotProxy dotProxy, FileColumn fc,DotFormulario formulario) {
		super();
		this.dotProxy = dotProxy;
		this.rpcProxy = dotProxy.getRpcProxy();
		this.fileColumn = fc;
		this.nameClasse = fc.getNameClasse();
		this.formulario = formulario;
		this.height = 0;
		this.width = 0;
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
			super.setHeaderVisible(false);
		}
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
		if(this.height == 0 && this.width == 0)
		{
		 setHeight(this.height);
		 setWidth(this.width);
		}else
		{
		 setHeight(this.height);
		 setWidth(this.width);
		}
		grid.setAutoExpandMin(autoMin);
		grid.setAutoHeight(true);
		grid.setAutoWidth(true);
		setLayout(new FitLayout());
		
		grid.setLayoutData(new FitLayout());
		add(grid);
	}

	private void buildGrid() {
		grid = new Grid<M>(store, cm);
		grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
		grid.setLayoutData(new FitLayout());
		grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				GridEvent ge = (GridEvent)be;
				M model = (M)ge.getModel();
				dto = model.getTO();
				//change2Formulario();
			}
		});
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
	
	@SuppressWarnings({ "unused", "rawtypes", "rawtypes", "rawtypes" })
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
		super.onHide();
	}
	
	public void updateGrid() {
		grid.recalculate();
		panelGrid.layout(true);
		layout(true);
	}
	
	private void change2Formulario() {
		saveGridState();
		add(formulario);
		if(dto != null)
			formulario.edit(dto);
		layout();
		dto = null;
	}
	
	
	public int getAutoMin() {
		return autoMin;
	}
	public void setAutoMin(int autoMin) {
		this.autoMin = autoMin;
	}
	public Mirror getDto() {
		return dto;
	}
}