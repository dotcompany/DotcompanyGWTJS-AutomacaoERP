package br.com.automacao.service.servlet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.EmpresaService;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.negocio.Empresa;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.dotcompany.hibernate.Generics;

@SuppressWarnings("serial")
@Service("empresaManager")
public class EmpresaServiceImpl extends BaseService implements EmpresaService {

	@Override
	@Transactional(readOnly = false)
	public void excluir(EmpresaMirror em) {
		EmpresaTO empresa = crud(Generics.class).buscar(new EmpresaTO(em.getId()));
		crud(Empresa.class).excluir(empresa);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void saveUpdate(EmpresaMirror em) {
 		EmpresaTO to = converterTo(em);
		if (em.getId() == null) {
			crud(Empresa.class).incluir(to);
		} else {
			crud(Empresa.class).alterar(to);
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public void incluir(EmpresaMirror em) {
		EmpresaTO empresa = (EmpresaTO) converterTo(em);
		crud(Empresa.class).incluir(empresa);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void alterar(EmpresaMirror em) {
		EmpresaTO empresa = (EmpresaTO) converterTo(em);
		crud(Empresa.class).alterar(empresa);
	}

	/* Método usado para sincronizar o mirror com o objeto do Banco de Dados */
	@Override
	@Transactional(readOnly = true)
	public EmpresaMirror buscar(EmpresaMirror em) {
		EmpresaTO to = crud(Generics.class).buscar(new EmpresaTO(em.getId()));
		return converterMirror(to);
	}

	/* Método usado para sincronizar o mirror com o objeto do Banco de Dados */
	@Override
	@Transactional(readOnly = true)
	public EmpresaMirror buscarPorCnpjCpf(String cnpjCpf) {
		EmpresaTO to = crud(Empresa.class).buscarPorCnpjCpf(cnpjCpf);
		return converterMirror(to);
	}
	
	/* Método usado para sincronizar o mirror com o que esta na sessão do Hibernate */
	@Override
	@Transactional(readOnly = true)
	public EmpresaMirror pegar(EmpresaMirror em) {
		EmpresaTO to = new EmpresaTO(); 
		crud(Empresa.class).pegar((EmpresaTO)converterTo(em));
		return converterMirror(to);
	}
}