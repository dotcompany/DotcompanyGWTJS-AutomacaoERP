package br.com.automacao.ctr.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automacao.ctr.negocio.FormDinamico;
import br.com.automacao.shared.dto.TextFieldDTO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;
import br.com.dotcompany.util.ReflectionUtil;
import br.com.dotcompany.util.UtilObjeto;

@Service
public class FormDinamicoBO implements FormDinamico {

	@Autowired
	private Generics generics;
	
	@Override
	public void salvar(Class<?> clazz, List<String> listName, List<Object> listValue) throws NegocioException {
		try {
			clazz = ReflectionUtil.getClasseAnotacao(clazz.getClass());
			List<Object> lista = ReflectionUtil.populaObjeto(clazz, listName, listValue);
			generics.incluir(clazz, lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TextFieldDTO> loadForm(Class<?> clazz) throws NegocioException {
		List<TextFieldDTO> lista = new ArrayList<TextFieldDTO>();
		for(String nome : ReflectionUtil.getAtributosPorClasse(clazz.getName())){
			if(nome.startsWith("lista"))
				continue;
			nome = nome.substring(0, 1).toUpperCase()+nome.substring(1);
			lista.add(new TextFieldDTO(nome, UtilObjeto.splitCamelCase(nome)));
		}
		return lista;
	}
}