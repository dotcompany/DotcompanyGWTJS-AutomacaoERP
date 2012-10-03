package br.com.automacao.client.widget.plugin;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

public class DotSearchTextField<D> extends TextField<D> {

	private El wrap;
	private El input;
//	private El img;
	private final int imgOffset = 3;
//	private Button button = new Button(null, DesktopApp.IMG.img_find());

	public DotSearchTextField() {
//		button.setStyleAttribute("background-color", "#99BBE8");
//		button.setToolTip(DesktopApp.MESSAGE.clique_pesquisar());
	}

	@Override
	protected void doAttachChildren() {
		super.doAttachChildren();
//		ComponentHelper.doAttach(button);
	}	

	@Override
	protected void doDetachChildren() {
		super.doDetachChildren();
//		ComponentHelper.doDetach(button);
	}

	@Override
	protected El getInputEl() {
		return input;
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		wrap.removeStyleName(fieldStyle);
		if (GXT.isIE) {
			int y1, y2;
			if ((y1 = input.getY()) != (y2 = el().getParent().getY())) {
				int dif = y2 - y1;
				input.setTop(dif);
			}
		}
	}

	@Override
	protected void onRender(Element target, int index) {
		wrap = new El(DOM.createDiv());
		wrap.addStyleName("x-form-field-wrap");
		wrap.addStyleName("x-form-file-wrap");
		wrap.setStyleAttribute("background-color", "##99BBE8");

		input = new El(DOM.createInputText());
//		input.addStyleName(fieldStyle);
//		input.addStyleName("x-form-file-text");
//		input.setStyleAttribute("color", "#000000");
//		input.setStyleAttribute("margin-left", "auto");
//		input.setStyleAttribute("margin-right", "0px");
		input.addStyleName("inputPesquisa");
		input.setHeight(18);

//		img = new El(DOM.createImg());
//		img.addStyleName("imgInfo");
//		img.setTitle("Enter para pesquisar");
//		img.setHeight(16);
		
		wrap.appendChild(input.dom);
//		wrap.appendChild(img.dom);

		setElement(wrap.dom, target, index);
		super.onRender(target, index);

//		button.addStyleName("x-form-file-btn");
//		button.render(wrap.dom);

		if (width == null) {
			setWidth(150);
		}
	}

	public void addSeleSelectionListener(SelectionListener<ButtonEvent> listener){
//		button.addSelectionListener(listener);
	}
	
	@Override
	protected void onResize(int width, int height) {
		super.onResize(width, height);
		input.setWidth(wrap.getWidth() - imgOffset);
	}
}
