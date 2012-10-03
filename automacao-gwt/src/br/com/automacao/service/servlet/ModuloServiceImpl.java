package br.com.automacao.service.servlet;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.ModuloService;
import br.com.automacao.ctr.entidade.EmpresaModuloTO;
import br.com.automacao.ctr.entidade.ModuloTO;
import br.com.automacao.ctr.negocio.Modulo;
import br.com.automacao.shared.mirror.EmpresaModuloMirror;
import br.com.automacao.shared.mirror.ModuloMirror;
import br.com.dotcompany.hibernate.Generics;

@SuppressWarnings("serial")
@Service("moduloManager")
public class ModuloServiceImpl extends BaseService implements ModuloService {

	@Override
	@Transactional(readOnly = false)
	public void excluir(ModuloMirror mm) {
		ModuloTO modulo = crud(Generics.class).pegar(new ModuloTO(mm.getId()));
		crud(Modulo.class).excluir(modulo);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void saveUpdate(ModuloMirror mm) {
		ModuloTO to = DozerBeanMapperSingletonWrapper.getInstance().map(mm, ModuloTO.class);;
		if (mm.getId() == null) {
			crud(Modulo.class).incluir(to);
		} else {
			crud(Modulo.class).alterar(to);
		}
	}

	/* Método usado para sincronizar o mirror com o objeto do Banco de Dados */
	@Override
	@Transactional(readOnly = true)
	public ModuloMirror buscar(ModuloMirror mm) {
		ModuloTO modulo = crud(Generics.class).buscar(new ModuloTO(mm.getId()));
		return DozerBeanMapperSingletonWrapper.getInstance().map(modulo, ModuloMirror.class);
	}

	/* Método usado para sincronizar o mirror com o que esta na sessão do Hibernate */
	@Override
	@Transactional(readOnly = true)
	public ModuloMirror pegar(ModuloMirror mm) {
		ModuloTO colaborador = crud(Generics.class).pegar(new ModuloTO(mm.getId()));
		return DozerBeanMapperSingletonWrapper.getInstance().map(colaborador, ModuloMirror.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ModuloMirror> buscarPorEmpresa(Integer idEmpresa) {
		List<ModuloTO> lista = crud(Modulo.class).buscarPorEmpresa(idEmpresa);
		List<ModuloMirror> listaMM = new ArrayList<ModuloMirror>();
		copyList(lista, listaMM);
		return listaMM;
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(List<EmpresaModuloMirror> lEMExcludes) {
		for(EmpresaModuloMirror emm : lEMExcludes){
			EmpresaModuloTO em = crud(Generics.class).pegar(new EmpresaModuloTO(emm.getId()));
			crud(Generics.class).excluir(em);
		}
	}
}