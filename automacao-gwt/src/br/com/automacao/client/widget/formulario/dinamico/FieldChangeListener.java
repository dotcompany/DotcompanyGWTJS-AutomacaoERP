package br.com.automacao.client.widget.formulario.dinamico;

import br.com.automacao.shared.dto.FieldDTO;

public interface FieldChangeListener {
  void onChange(FieldDTO field);
  void onEdit(CampoDescWidget<?> fieldWidgetDesc);
  void onRemove(CampoDescWidget<?> fieldWidgetDesc);
  void onUpField(CampoDescWidget<?> fieldWidgetDesc);
  void onDownField(CampoDescWidget<?> fieldWidgetDesc);
}
