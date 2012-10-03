package br.com.automacao.service.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import br.com.automacao.client.service.GenericsService;
import br.com.automacao.ctr.negocio.FormDinamico;
import br.com.automacao.shared.dto.CepDTO;
import br.com.automacao.shared.dto.TextFieldDTO;
import br.com.automacao.shared.util.Mirror;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;
import br.com.dotcompany.servico.WebServiceCep;
import br.com.dotcompany.to.TransferObject;
import br.com.dotcompany.util.PropertiesUtil;
import br.com.dotcompany.util.ReflectionUtil;

@SuppressWarnings("serial")
public class GenericsServiceImpl extends BaseService implements GenericsService {

	@Override
	public Map<String, String> loadApp() {
		 
		Map<String, String> properties = new HashMap<String, String>();    
		String realPath = getServletContext().getRealPath("");
		if(!realPath.endsWith("\\")){
			realPath += "\\"; 
		}
		realPath += "resources\\properties\\configure.properties";
	    try {
	    	File f = new File(realPath);
			if (!f.isFile()){ throw new IOException("Arquivo configure.properties não encontrado"); }
	    	Properties p = PropertiesUtil.loadFile(realPath);
	    	for(Map.Entry<Object, Object> e: p.entrySet())
	    		properties.put(e.getKey().toString(), e.getValue().toString());
	    } catch (Exception e) {
	    	throw new NegocioException("Erro ao carrgar o Arquivo: configure.properties - " + e.getMessage());
	    }
		return properties;
	}

	@Override
	public CepDTO loadCep(String value) {
		if(value == null || value.isEmpty()){ return null; }
		WebServiceCep cep = WebServiceCep.searchCep(value);
		CepDTO cepDTO = new CepDTO(cep.getCep(),
								   cep.getBairro(),
								   cep.getCidade(),
								   cep.getUf(),
								   cep.getLogradouro(),
								   cep.getLogradouroFull(),
								   cep.getLogradouroType()
								   );
		return cepDTO;
	}

	@Override
	public List<TextFieldDTO> loadForm(String nameClass) {
		return crud(FormDinamico.class).loadForm(ReflectionUtil.getClass(nameClass));
	}

	@Override
	public void salvarForDinamico(String nameClass, List<String> listName, List<Object> listValue) {
		crud(FormDinamico.class).salvar(ReflectionUtil.getClass(nameClass), listName, listValue);
	}

	@Override
	public Long ultimoId(String nameClass) {
		return crud(Generics.class).ultimoId(ReflectionUtil.getClass(nameClass));
	}
	
	public <T extends Mirror> List<T> listar(String nameClass, String[] idColumns, String[] like){
		Class<?> clazz = null;
		try {
			clazz = Class.forName(nameClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class<?> clazzTO = ReflectionUtil.getClasseAnotacao(clazz);
		List<TransferObject> lista = crud(Generics.class).listarLike(clazzTO, idColumns, like);
		List<T> listaNew = new ArrayList<T>();
		copyList(lista, listaNew);
		return listaNew;
	}
	
	public <T extends Mirror> List<T> listar(String nameClass){
		Class<?> clazz = null;
		try {
			clazz = Class.forName(nameClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class<?> clazzTO = ReflectionUtil.getClasseAnotacao(clazz);
		List<?> lista = crud(Generics.class).listarPrimitivos(clazzTO);
		List<T> listaNew = new ArrayList<T>();
		copyList(lista, listaNew);
		return listaNew;
	}
}