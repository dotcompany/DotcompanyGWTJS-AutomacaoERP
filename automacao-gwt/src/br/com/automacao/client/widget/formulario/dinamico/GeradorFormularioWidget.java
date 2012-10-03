package br.com.automacao.client.widget.formulario.dinamico;

import java.util.Iterator;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.dialog.MsgDialog;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.client.widget.formulario.descriptor.BooleanWidgetDesc;
import br.com.automacao.client.widget.formulario.descriptor.DateWidgetDesc;
import br.com.automacao.client.widget.formulario.descriptor.FloatWidgetDesc;
import br.com.automacao.client.widget.formulario.descriptor.IntegerWidgetDesc;
import br.com.automacao.client.widget.formulario.descriptor.StringWidgetDesc;
import br.com.automacao.client.widget.formulario.dinamico.FieldDialog.Callback;
import br.com.automacao.shared.dto.BooleanFieldDTO;
import br.com.automacao.shared.dto.DateFieldDTO;
import br.com.automacao.shared.dto.FieldCollectionDTO;
import br.com.automacao.shared.dto.FieldDTO;
import br.com.automacao.shared.dto.FloatFieldDTO;
import br.com.automacao.shared.dto.IntegerFieldDTO;
import br.com.automacao.shared.dto.StringFieldDTO;
import br.com.automacao.shared.type.CampoType;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

interface FieldDefined {
	void onDefineField(FieldDTO field);

	int getOrder();
}

public class GeradorFormularioWidget extends DotWindow implements FieldDefined,
		FieldChangeListener {

	private final ToolBar toolBar = new ToolBar();
	private final ContentPanel panel = new ContentPanel();
	private final HorizontalPanel header = new HorizontalPanel();

	private FieldCollectionDTO currentFieldCollection = new FieldCollectionDTO(
			"teste");

	public GeradorFormularioWidget(String header) {
		super(header);
		initHeader();
		buildAddMenuWidget();
		 buildSaveMenuWidget();
		setHeight(500);
		setWidth(600);
		super.add(toolBar);
		super.add(panel);
		// super.setWidth("100%");
	}

	private final void initHeader() {
		LabelField label;
		header.add(label = new LabelField(""));
		header.setCellWidth(label, CampoDescWidget.FIRST_COLUMN);
		header.setCellHorizontalAlignment(label,
				HasHorizontalAlignment.ALIGN_CENTER);
		header.setCellVerticalAlignment(label,
				HasVerticalAlignment.ALIGN_MIDDLE);

		header.add(label = new LabelField(""));
		header.setCellWidth(label, CampoDescWidget.FIRST_COLUMN);
		header.setCellHorizontalAlignment(label,
				HasHorizontalAlignment.ALIGN_CENTER);
		header.setCellVerticalAlignment(label,
				HasVerticalAlignment.ALIGN_MIDDLE);

		header.add(label = new LabelField(""));
		header.setCellWidth(label, CampoDescWidget.FIRST_COLUMN);
		header.setCellHorizontalAlignment(label,
				HasHorizontalAlignment.ALIGN_CENTER);
		header.setCellVerticalAlignment(label,
				HasVerticalAlignment.ALIGN_MIDDLE);

		header.add(label = new LabelField(""));
		header.setCellWidth(label, CampoDescWidget.FIRST_COLUMN);
		header.setCellHorizontalAlignment(label,
				HasHorizontalAlignment.ALIGN_CENTER);
		header.setCellVerticalAlignment(label,
				HasVerticalAlignment.ALIGN_MIDDLE);

		header.add(label = new LabelField("Nome do campo"));
		header.setCellWidth(label, CampoDescWidget.LABEL_WIDTH);
		header.setCellHorizontalAlignment(label,
				HasHorizontalAlignment.ALIGN_LEFT);
		header.setCellVerticalAlignment(label,
				HasVerticalAlignment.ALIGN_MIDDLE);

		header.add(label = new LabelField("Estilo do campo"));
		header.setCellWidth(label, CampoDescWidget.FIELD_WIDTH);
		header.setCellHorizontalAlignment(label,
				HasHorizontalAlignment.ALIGN_LEFT);
		header.setCellVerticalAlignment(label,
				HasVerticalAlignment.ALIGN_MIDDLE);

		header.add(label = new LabelField("Requerido"));
		header.setCellWidth(label, CampoDescWidget.FLAGS_WIDTH);
		header.setCellHorizontalAlignment(label,
				HasHorizontalAlignment.ALIGN_CENTER);

		header.setSpacing(CampoDescWidget.HORIZONTAL_SPACING);
		panel.setHeaderVisible(false);
		cleanPanel();
	}

	private void cleanPanel() {
		panel.removeAll();
		panel.add(header);
	}

	private void buildAddMenuWidget() {
		toolBar.setAddCallback(new FieldDefined() {
			@Override
			public void onDefineField(FieldDTO field) {
				GeradorFormularioWidget.this.onDefineField(field);
			}

			@Override
			public int getOrder() {
				return GeradorFormularioWidget.this.getOrder();
			}
		});
	}

	public void setViewEmpty() {
		cleanPanel();
		toolBar.disableAll();
		panel.layout();
	}

	public void loadFromCollection(FieldCollectionDTO fieldCollection) {
		cleanPanel();
		this.currentFieldCollection = fieldCollection;
		Iterator<FieldDTO> fields = fieldCollection.getFields();
		int order = 1;
		while (fields.hasNext()) {
			FieldDTO field = fields.next();
			field.setOrdem(order++);
			defineField(field);
		}
		toolBar.setAddEnabled(true);
		toolBar.setSaveEnabled(fieldCollection.isModified());
		panel.layout();
	}

	private void buildSaveMenuWidget() {
		toolBar.setSaveCallback(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				onSaveField();
			}
		});
	}

	private void onSaveField() {
//		final FieldCollectionDTO fc = getCurrentFieldCollection();
		// DesktopApp.getService().execute(new SaveFieldCollection(fc), new
		// AsyncCallback<Response>(){
		// @Override
		// public void onFailure(Throwable caught) {
		// MsgDialog.alert("Erro", "N�o foi poss�vel salvar os campos!");
		// }
		// @Override
		// public void onSuccess(Response result) {
		// MsgDialog.message("Campos salvos com sucesso!");
		// cache.remove(fc.getName());
		// fieldDefWidget.saved();
		// Dispatcher.forwardEvent(FieldEvents.SavedFieldsDefinition, fc);
		// }}
		// );
	}

	private void defineField(FieldDTO fieldTO) {
		CampoDescWidget<?> field;
		if (fieldTO instanceof DateFieldDTO)
			field = new DateWidgetDesc((DateFieldDTO) fieldTO, this);
		else if (fieldTO instanceof StringFieldDTO)
			field = new StringWidgetDesc((StringFieldDTO) fieldTO, this);
		else if (fieldTO instanceof BooleanFieldDTO)
			field = new BooleanWidgetDesc((BooleanFieldDTO) fieldTO, this);
		else if (fieldTO instanceof IntegerFieldDTO)
			field = new IntegerWidgetDesc((IntegerFieldDTO) fieldTO, this);
		else if (fieldTO instanceof FloatFieldDTO)
			field = new FloatWidgetDesc((FloatFieldDTO) fieldTO, this);
		else
			return; // we have to go back here!
		panel.setBorders(true);
		panel.add(field);
	}

	@Override
	public int getOrder() {
		return currentFieldCollection != null ? currentFieldCollection.size() + 1
				: 1;
	}

	public FieldCollectionDTO getCurrentFieldCollection() {
		return currentFieldCollection;
	}

	@Override
	public final void onDefineField(FieldDTO fieldDTO) {
		if (fieldDTO == null)
			return;
		final String fieldName = fieldDTO.getNome();
		if (currentFieldCollection.hasAlreadyDefined(fieldName))
			MsgDialog.alert("Campo já definido",
					"Já foi definido um campo com o nome '" + fieldName + "'");
		else {
			defineField(fieldDTO);
			panel.layout();
			currentFieldCollection.addField(fieldDTO);
			toolBar.setSaveEnabled(currentFieldCollection.isModified());
		}
	}

	@Override
	public void onChange(FieldDTO field) {
		toolBar.saveOn();
		currentFieldCollection.unsave();
	}

	@Override
	public void onEdit(final CampoDescWidget<?> fieldWidgetDesc) {
		FieldDialog.edit(new Callback() {
			@Override
			public void cancell(FieldDialog d) {
				;
			}

			@Override
			public void ok(FieldDialog dialog) {
				updatePanel(fieldWidgetDesc, dialog.getFieldDTO().getNome());
			}
		}, (FieldDTO) fieldWidgetDesc.getFieldDTO());

	}

	@Override
	public void onRemove(CampoDescWidget<?> fieldWidgetDesc) {
		currentFieldCollection.remove(fieldWidgetDesc.getFieldDTO());
		panel.remove(fieldWidgetDesc);
		toolBar.saveOn();
	}

	@SuppressWarnings("unchecked")
	@Override
	public final void onUpField(CampoDescWidget<?> fieldWidgetDesc) {
		for (int count = panel.getItemCount() - 1; count > 0; count--)
			if (panel.getWidget(count) == fieldWidgetDesc) {
				CampoDescWidget<?> before = (CampoDescWidget) panel
						.getWidget(count - 1);
				panel.remove(fieldWidgetDesc);
				panel.insert(fieldWidgetDesc, count - 1);
				before.incrementOrder();
				fieldWidgetDesc.decrementOrder();
				toolBar.saveOn();
				break;
			}
		panel.layout(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final void onDownField(CampoDescWidget<?> fieldWidgetDesc) {
		int total = panel.getItemCount();
		for (int count = 0; count < total - 1; count++)
			if (panel.getWidget(count) == fieldWidgetDesc) {
				CampoDescWidget<?> before = (CampoDescWidget) panel
						.getWidget(count + 1);
				panel.remove(fieldWidgetDesc);
				panel.insert(fieldWidgetDesc, count + 1);
				before.decrementOrder();
				fieldWidgetDesc.incrementOrder();
				toolBar.saveOn();
				break;
			}
		panel.layout(true);
	}

	private void updatePanel(final CampoDescWidget<?> fieldWidgetDesc,
			String value) {
		fieldWidgetDesc.setText(value);
		FieldDTO field = fieldWidgetDesc.getFieldDTO();
		onChange(field);
		panel.layout(true);
	}

	@Override
	public void cancel() {
		
		
	}
}

final class ToolBar extends Composite {
	private final HorizontalPanel toolBar = new HorizontalPanel();
	private final Button saveButton = new Button(null, DesktopApp.IMG
			.img_save());
	private final Button textButton = new Button(null, DesktopApp.IMG
			.img_text());
	private final Button textAreaButton = new Button(null, DesktopApp.IMG
			.img_textarea());
	private final Button dateButton = new Button(null, DesktopApp.IMG
			.img_calendar());
	private final Button integerButton = new Button(null, DesktopApp.IMG
			.img_integer());
	private final Button floatButton = new Button(null, DesktopApp.IMG
			.img_float());
	private final Button booleanButton = new Button(null, DesktopApp.IMG
			.img_check());

	public ToolBar() {
		initWidget(toolBar);
		initLayout();
		initButtons();
	}

	static class Callback extends SelectionListener<ButtonEvent> implements
			FieldDialog.Callback {
		protected final CampoType fieldType;
		protected final FieldDefined fieldDefined;
		protected FieldDialog dialog;

		public Callback(FieldDefined fieldDefined, CampoType fieldType) {
			this.fieldType = fieldType;
			this.fieldDefined = fieldDefined;
		}

		@Override
		public void componentSelected(ButtonEvent ce) {
			dialog = FieldDialog.show(this, fieldType, fieldDefined.getOrder());
		}

		@Override
		public void cancell(FieldDialog d) {
		}

		@Override
		public void ok(FieldDialog d) {
			fieldDefined.onDefineField(dialog.getFieldDTO());
		}
	}

	public void setAddCallback(final FieldDefined fieldDefined) {
		textButton.addSelectionListener(new Callback(fieldDefined,
				CampoType.STRING));
		dateButton.addSelectionListener(new Callback(fieldDefined,
				CampoType.DATE));
		floatButton.addSelectionListener(new Callback(fieldDefined,
				CampoType.FLOAT));
		integerButton.addSelectionListener(new Callback(fieldDefined,
				CampoType.INTEGER));
		textAreaButton.addSelectionListener(new Callback(fieldDefined,
				CampoType.TEXT_AREA));
		booleanButton.addSelectionListener(new Callback(fieldDefined,
				CampoType.BOOLEAN));
	}

	public void setAddEnabled(boolean b) {
		for (int i = 0; i < toolBar.getWidgetCount(); i++) {
			Button add = (Button) toolBar.getWidget(i);
			if (add != saveButton)
				add.setEnabled(b);
		}
	}

	private void initLayout() {
		toolBar.setSpacing(5);
		toolBar.add(saveButton);
		saveButton.setToolTip("Salvar os campos definidos");
		toolBar.add(integerButton);
		integerButton.setToolTip(CampoType.INTEGER.desc());
		toolBar.add(floatButton);
		floatButton.setToolTip(CampoType.FLOAT.desc());
		toolBar.add(textButton);
		textButton.setToolTip(CampoType.STRING.desc());
		// toolBar.add(textAreaButton);textAreaButton.setToolTip(TipoCampo.TEXT_AREA.desc());
		toolBar.add(dateButton);
		dateButton.setToolTip(CampoType.DATE.desc());
		toolBar.add(booleanButton);
		booleanButton.setToolTip(CampoType.BOOLEAN.desc());
		// toolBar.add(sortedButton);
		// sortedButton.setToolTip(TipoCampo.SORTED.desc());
		// toolBar.add(fileButton);
		// fileButton.setToolTip(TipoCampo.BINARY.desc());
	}

	void setSaveCallback(SelectionListener<ButtonEvent> callback) {
		saveButton.addSelectionListener(callback);
	}

	private void initButtons() {
		for (int i = 0; i < toolBar.getWidgetCount(); i++)
			((Button) toolBar.getWidget(i)).setWidth(40);
	}

	public void setSaveEnabled(boolean saved) {
		saveButton.setEnabled(saved);
	}

	public void saveOn() {
		setSaveEnabled(true);
	}

	public void saveOff() {
		setSaveEnabled(false);
	}

	public void addOn() {
		setAddEnabled(true);
	}

	public void addOff() {
		setAddEnabled(false);
	}

	public void disableAll() {
		for (int i = 0; i < toolBar.getWidgetCount(); i++)
			((Button) toolBar.getWidget(i)).disable();
		saveButton.disable();
	}
}