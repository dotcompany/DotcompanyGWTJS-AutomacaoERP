package br.com.automacao.client.widget.formulario.dinamico;

import static com.google.gwt.event.dom.client.KeyCodes.KEY_ENTER;

import java.util.HashMap;
import java.util.Map;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.shared.dto.FieldDTO;
import br.com.automacao.shared.type.CampoType;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

public final class FieldDialog extends Dialog {

  public static interface Callback{
    public void ok(FieldDialog dialog);
    public void cancell(FieldDialog dialog);
  }
  
  private TextField<String> fieldName;
  private Button addButton;
  private Button cancelButton;
  private Callback callback;
  private final CampoType tipoCampo;
  private final int fieldOrder;
  private FieldDTO field;
  
  private static final Map<CampoType, AbstractImagePrototype> IMAGES = new HashMap<CampoType, AbstractImagePrototype>();
  
  static {
    IMAGES.put(CampoType.STRING, DesktopApp.IMG.img_text());
    IMAGES.put(CampoType.TEXT_AREA, DesktopApp.IMG.img_textarea());
    IMAGES.put(CampoType.BOOLEAN, DesktopApp.IMG.img_check());
    IMAGES.put(CampoType.DATE, DesktopApp.IMG.img_calendar());
    IMAGES.put(CampoType.FLOAT, DesktopApp.IMG.img_float());
    IMAGES.put(CampoType.INTEGER, DesktopApp.IMG.img_integer());    
  }
  
  private FieldDialog(Callback callback, FieldDTO field){
    this(callback, field.getTipo(), field.getOrdem(), field);    
  }
  
  private FieldDialog(Callback callback, CampoType tipoCampo, int fieldOrder, FieldDTO field){
    this.field = field;
    this.callback = callback;
    this.tipoCampo = tipoCampo;
    this.fieldOrder = fieldOrder;
    initDialog();      
    if (field == null){
      initFieldName("");
    }else{
      initFieldName(field.getNome());
    }
    setFocusWidget(fieldName);
    validate();
    
  }

  private void initFieldName(String fieldValue) {
    KeyListener keyListener = new KeyListener() {
      public void componentKeyUp(ComponentEvent event) {
        if (validate() && event.getKeyCode() == KEY_ENTER)
          saveOrEdit();
      }
    };
 
    Validator validator = new Validator(){
      @Override
      public String validate(Field<?> field, String value) {
        if (value != null && value.trim().length() > 0)
          return null;
        return "O campo deve ser preenchido";
      }
    };
    fieldName = new TextField<String>();
    fieldName.setValue(fieldValue);
    fieldName.setValidator(validator);
    fieldName.setMinLength(1); 
    fieldName.setMaxLength(23);
    fieldName.setFieldLabel("Nome");
    fieldName.setAllowBlank(false);
    fieldName.addKeyListener(keyListener);
    add(fieldName);  
  }  
 
  private void initDialog() {
    FormLayout layout = new FormLayout();
    layout.setLabelWidth(80);
    layout.setDefaultWidth(260);
    setLayout(layout);    
    setButtonAlign(HorizontalAlignment.LEFT);
    setButtons("");
    setIcon(IMAGES.get(tipoCampo));
    setHeading("Definição de " + tipoCampo.desc());
    setModal(true);
    setBodyBorder(true);
    setBodyStyle("padding: 8px;background: none");
    setWidth(400);
    setResizable(false);  
  }

  private void saveOrEdit() {
    FieldDialog.this.hide();
    if (field != null){
      field.setNome(fieldName.getValue());
    }        
    if (callback != null)
      callback.ok(this);
  }


  @Override
  protected void createButtons() {
    super.createButtons();
    getButtonBar().add(new FillToolItem());    
    addButton = new Button("OK");
    addButton.setEnabled(field != null);
    addButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        saveOrEdit();
      }
    });
    addButton(addButton);    

    cancelButton = new Button("Cancel");    
    cancelButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        FieldDialog.this.hide();
        if (callback != null)
          callback.cancell(FieldDialog.this);
      }
    });  
    addButton(cancelButton);
  }  
  
  public static FieldDialog edit(Callback callback, FieldDTO field){    
    FieldDialog dialog = new FieldDialog(callback, field);
    dialog.show();
    return dialog;
  }
  
  public static FieldDialog show(Callback callback, CampoType TipoCampo, int order){
    FieldDialog dialog = new FieldDialog(callback, TipoCampo, order, null);
    dialog.show();
    return dialog;
  }
    
  protected boolean validate() {
    String value = fieldName.getValue();    
    if (value != null && value.length() >= 23)
      fieldName.setValue(value.substring(0, 23));
    addButton.setEnabled(fieldName.getValue() != null && fieldName.getValue().trim().length() > 0 );
    return addButton.isEnabled();
  }

  public final FieldDTO getFieldDTO() {
    if (field != null)
      return field;
    String fieldNameText = fieldName.getValue();
    if (fieldNameText == null || (fieldNameText = fieldNameText.trim()).length() == 0)
      return null;
    return tipoCampo.makeField(fieldNameText, fieldOrder, false);
  }  
}
