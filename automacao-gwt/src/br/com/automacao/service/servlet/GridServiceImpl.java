package br.com.automacao.service.servlet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.GridService;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.negocio.Grid;
import br.com.automacao.server.repository.GridManagerBO;
import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.util.ListUtil;
import br.com.automacao.shared.util.Mirror;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;
import br.com.dotcompany.util.ReflectionUtil;

@SuppressWarnings("serial")
@Service("gridManager")
public class GridServiceImpl extends BaseService implements GridService {
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public ListUtil busca(String nameClass, List<String> idColumns) {
		try {
			Class clazz = Class.forName(nameClass);
			return new ListUtil(crud(Grid.class).busca(clazz, idColumns), crud(Generics.class).count(EmpresaTO.class));
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public int countFilterAll(String nameClass, String value, String[] nomeColunas, String[] tipoColunas) {
		try {
			return crud(Grid.class).countFilterAll(Class.forName(nameClass), value, nomeColunas, tipoColunas);
		} catch (ClassNotFoundException e) { throw new NegocioException("Classe não foi encontrada: " + e.getMessage()); }
	}

	@Override
	@Transactional(readOnly = true)
	public int countFilterLike(String nameClass, String[] like) {
		try {
			return crud(Grid.class).countFilterLike(Class.forName(nameClass), like);
		} catch (ClassNotFoundException e) { throw new NegocioException("Classe não foi encontrada: " + e.getMessage()); }
	}

	@Override
	@Transactional(readOnly = true)
	public FileColumn loadState(FileColumn fc) {
		String nameClass = fc.getNameClasse();
		String key = fc.getKey();
		FileColumn fCol = GridManagerBO.getInstance().loadStateGrid(nameClass, key);
		if(fCol != null)
			return fCol;
		
		saveState(fc);
		return fc; 
	}

	@Override
	@Transactional(readOnly = false)
	public void saveState(FileColumn fc) {
		GridManagerBO.getInstance().saveStateGrid(fc);
	}

	@Override
	@Transactional(readOnly = true)
	public ListUtil buscarTodos(String clazzName, Integer start, Integer maxResults, String[] idColumns) {
		Class<?> clazz = ReflectionUtil.getClass(clazzName);
		Class<?> clazzTO = ReflectionUtil.getClasseAnotacao(clazz);
		List<?> listBd = crud(Grid.class).buscarTodos(clazzTO, start, maxResults, idColumns);
		List<Mirror> listMirror = new ArrayList<Mirror>();
		copyList(listBd, listMirror);
		int rows = crud(Generics.class).count(clazzTO);
		return new ListUtil(listMirror, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public ListUtil buscarFilter(String clazzName, Integer start, Integer maxResults, String[] idColumns, String[] like) {
		Class<?> clazz = ReflectionUtil.getClass(clazzName);
		Class<?> clazzTO = ReflectionUtil.getClasseAnotacao(clazz);
		List<?> listBd = crud(Grid.class).buscarFilter(clazzTO, start, maxResults, idColumns, like);
		List<Mirror> listMirror = new ArrayList<Mirror>();
		copyList(listBd, listMirror);
		int rows = crud(Grid.class).countFilterLike(clazzTO, like);
		
		return new ListUtil(listMirror, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public ListUtil buscarFilterAll(String clazzName, Integer start, Integer maxResults, String value, String[] nomeColunas, String[] tipoColunas) {
		Class<?> clazz = ReflectionUtil.getClass(clazzName);
		Class<?> clazzTO = ReflectionUtil.getClasseAnotacao(clazz);
		List<?> listBd = crud(Grid.class).buscarFilterAll(clazzTO, start, maxResults, value, nomeColunas, tipoColunas);
		List<Mirror> listMirror = new ArrayList<Mirror>();
		copyList(listBd, listMirror);
		int rows = crud(Grid.class).countFilterAll(clazzTO, value, nomeColunas, tipoColunas);
		return new ListUtil(listMirror, rows);
	}
}