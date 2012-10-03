package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.ColaboradorMirror;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.AnchorData;
import com.extjs.gxt.ui.client.widget.layout.AnchorLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;

public class CadColaboradorDocImg extends IForm<ColaboradorMirror>{

	private TabItem tabItemDocImg = new TabItem("Documentos e Imagens.");
	private FormPanel formDocImg = new FormPanel();
	private FormPanel frmpnlNewFormpanel_8 = new FormPanel();
	private FileUploadField fuArquivo = new FileUploadField();
	private FormPanel panelGaleria = new FormPanel();
	
	public CadColaboradorDocImg(){
		super(null);
	}
	
	public CadColaboradorDocImg(DotFormulario formulario) {
		super(formulario);
		
		tabItemDocImg.setLayout(new FitLayout());
		
		formDocImg.setHeaderVisible(false);
		formDocImg.setFrame(true);
		formDocImg.setHeading("New FormPanel");
		formDocImg.setCollapsible(true);
		formDocImg.setLayout(new AnchorLayout());
		
		frmpnlNewFormpanel_8.setHeaderVisible(false);
		frmpnlNewFormpanel_8.setFrame(true);
		frmpnlNewFormpanel_8.setHeading("New FormPanel");
		frmpnlNewFormpanel_8.setCollapsible(true);
		
		frmpnlNewFormpanel_8.add(fuArquivo, new FormData("-295"));
		fuArquivo.setSize("441px", "22px");
		formDocImg.add(frmpnlNewFormpanel_8);
		frmpnlNewFormpanel_8.setHeight("60px");
		
		panelGaleria.setHeading("Galeria de imagens");
		panelGaleria.setCollapsible(true);
		formDocImg.add(panelGaleria, new AnchorData("-30 -120"));
		tabItemDocImg.add(formDocImg);
	}

	public TabItem getTabItemDocImg() {
		return tabItemDocImg;
	}
	public void setTabItemDocImg(TabItem tabItemDocImg) {
		this.tabItemDocImg = tabItemDocImg;
	}
	public FormPanel getFormDocImg() {
		return formDocImg;
	}
	public void setFormDocImg(FormPanel formDocImg) {
		this.formDocImg = formDocImg;
	}
	public FormPanel getFrmpnlNewFormpanel_8() {
		return frmpnlNewFormpanel_8;
	}
	public void setFrmpnlNewFormpanel_8(FormPanel frmpnlNewFormpanel_8) {
		this.frmpnlNewFormpanel_8 = frmpnlNewFormpanel_8;
	}
	public FileUploadField getFuArquivo() {
		return fuArquivo;
	}
	public void setFuArquivo(FileUploadField fuArquivo) {
		this.fuArquivo = fuArquivo;
	}
	public FormPanel getPanelGaleria() {
		return panelGaleria;
	}
	public void setPanelGaleria(FormPanel panelGaleria) {
		this.panelGaleria = panelGaleria;
	}

	@Override
	public void clear() {
		super.doClear(formDocImg.getFields());
		super.doClear(frmpnlNewFormpanel_8.getFields());
	}

	@Override
	public void fillDTO(ColaboradorMirror dto) {
		
		
	}

	@Override
	public TabItem getItem() {
		return getTabItemDocImg();
	}

	@Override
	public void loadFields(ColaboradorMirror dto) {
		
		
	}
}