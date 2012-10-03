package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.shared.dto.TextFieldDTO;
import br.com.dotcompany.exception.NegocioException;

public interface FormDinamico {

	public void salvar(Class<?> clazz, List<String> listName, List<Object> listValue) throws NegocioException;
	public List<TextFieldDTO> loadForm(Class<?> clazz) throws NegocioException;
}