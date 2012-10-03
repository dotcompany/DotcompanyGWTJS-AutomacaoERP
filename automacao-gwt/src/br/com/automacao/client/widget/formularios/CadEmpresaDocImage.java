package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.EmpresaMirror;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.AnchorData;
import com.extjs.gxt.ui.client.widget.layout.AnchorLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;

public class CadEmpresaDocImage extends IForm<EmpresaMirror> {
	
	private TabItem 					tabItemImage = new TabItem("Documentos e Imagens.");
	private FormPanel 					formDocImage = new FormPanel();
	private FormPanel 					formUpload = new FormPanel();
	private FileUploadField 			fileUploadField = new FileUploadField();
	private FormPanel 					formImage = new FormPanel();
	
	public CadEmpresaDocImage(){
		super(null);
	}
	
	public CadEmpresaDocImage(DotFormulario formulario){
		super(formulario);
		
		tabItemImage.setLayout(new FitLayout());
		
		formDocImage.setHeaderVisible(false);
		formDocImage.setFrame(true);
		formDocImage.setHeading("New FormPanel");
		formDocImage.setCollapsible(true);
		formDocImage.setLayout(new AnchorLayout());
		
		formUpload.setHeaderVisible(false);
		formUpload.setFrame(true);
		formUpload.setHeading("New FormPanel");
		formUpload.setCollapsible(true);
		
		formUpload.add(fileUploadField, new FormData("-295"));
		fileUploadField.setSize("441px", "22px");
		formDocImage.add(formUpload);
		formUpload.setHeight("60px");
		
 		formImage.setHeading("Galeria de imagens");
		formImage.setCollapsible(true);
		formDocImage.add(formImage, new AnchorData("-30 -120"));
		tabItemImage.add(formDocImage);
	}

	@Override
	public void clear() {
//		super.doClear(formDocImage.getFields());
//		super.doClear(formImage.getFields());
//		super.doClear(formUpload.getFields());
	}

	@Override
	public void fillDTO(EmpresaMirror dto) {
		
	}

	@Override
	public TabItem getItem() {
		return tabItemImage;
	}

	@Override
	public void loadFields(EmpresaMirror dto) {
		
	}
}