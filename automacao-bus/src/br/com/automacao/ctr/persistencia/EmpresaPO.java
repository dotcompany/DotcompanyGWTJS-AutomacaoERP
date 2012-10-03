package br.com.automacao.ctr.persistencia;

import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.dotcompany.hibernate.AbstractHibernatePO;

@Repository
public class EmpresaPO extends AbstractHibernatePO{

	public EmpresaTO buscarPorCnpjCpf(String cnpjCpf) {
		String hql = "from "+ EmpresaTO.class.getName() +" E where E.cnpj = '"+cnpjCpf+"'";
		return getDao().queryUnique(hql);
	}
}