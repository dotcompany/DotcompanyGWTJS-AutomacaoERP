package br.com.automacao.client.widget.formulario.descriptor;

import br.com.automacao.client.widget.formulario.dinamico.CampoDescWidget;
import br.com.automacao.client.widget.formulario.dinamico.FieldChangeListener;
import br.com.automacao.shared.dto.BooleanFieldDTO;
import br.com.automacao.shared.type.CampoType;

import com.google.gwt.user.client.ui.CheckBox;

public class BooleanWidgetDesc extends CampoDescWidget<BooleanFieldDTO> {

	private CheckBox check = new CheckBox();

	public BooleanWidgetDesc(BooleanFieldDTO fieldTO, FieldChangeListener listener) {
		super(fieldTO, listener);
		super.add(check);
		super.setCellWidth(check, FIELD_WIDTH);
		check.setEnabled(false);
		check.setTitle(CampoType.BOOLEAN.desc());
		buildCheckIsRequired();
	}
}