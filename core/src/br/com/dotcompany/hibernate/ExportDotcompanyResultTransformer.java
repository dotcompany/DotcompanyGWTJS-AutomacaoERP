package br.com.dotcompany.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

@SuppressWarnings("serial")
public class ExportDotcompanyResultTransformer implements ResultTransformer {

	@SuppressWarnings("unused")
	private Class<?> clazz;

	private List<Object> lista;

	public ExportDotcompanyResultTransformer(Class<?> clazz) {
		this.clazz = clazz;
		lista = new ArrayList<Object>();
	}

	@Override
	public Object transformTuple(Object[] arrayItemProjResult, String[] aliases) {
		lista.addAll(Arrays.asList(arrayItemProjResult));
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> transformList(List arg0) {
		return lista;
	}
}