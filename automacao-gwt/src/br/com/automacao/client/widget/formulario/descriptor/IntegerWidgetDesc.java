package br.com.automacao.client.widget.formulario.descriptor;

import br.com.automacao.client.widget.formulario.dinamico.CampoDescWidget;
import br.com.automacao.client.widget.formulario.dinamico.FieldChangeListener;
import br.com.automacao.shared.dto.IntegerFieldDTO;
import br.com.automacao.shared.type.CampoType;

import com.extjs.gxt.ui.client.widget.form.TextField;

public class IntegerWidgetDesc extends CampoDescWidget<IntegerFieldDTO> {

	private TextField<Integer> field = new TextField<Integer>();

	public IntegerWidgetDesc(IntegerFieldDTO fieldTO, FieldChangeListener listener) {
		super(fieldTO, listener);
		super.add(field);
		super.setCellWidth(field, FIELD_WIDTH);
		field.setWidth(FIELD_WIDTH);
		field.setTitle(CampoType.INTEGER.desc());
		field.setReadOnly(true);
		buildCheckIsRequired();
	}
}