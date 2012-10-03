package br.com.automacao.shared.model;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.util.Mirror;

@SuppressWarnings("serial")
public class EmpresaModel extends DotModel{

	public final static String EMPRESA 				= "empresa";
	public final static String RAZAO_SOCIAL			= "razaoSocial";
	public final static String NOME_FANTASIA		= "nomeFantasia";
	public final static String CNPJ 				= "cnpj";
	public final static String INSC_ESTADUAL		= "inscEstadual";
	public final static String INSC_ESTADUAL_ST 	= "inscEstadualST";
	public final static String INSC_MUNICIPAL		= "inscMunicipal";
	
	public EmpresaModel() {}
	
	public EmpresaModel(FileColumn fc) {
		createColumns(fc);
	}
	
	@Override
	public void add(Mirror mirror) {
		dotModel = new EmpresaModel();
		EmpresaMirror empresa = ((EmpresaMirror)mirror); 
		dotModel.set(EMPRESA, empresa);
		dotModel.set(ID, empresa.getId());
		dotModel.set(CNPJ, empresa.getCnpj());
		dotModel.set(RAZAO_SOCIAL, empresa.getRazaoSocial());
		dotModel.set(NOME_FANTASIA, empresa.getNomeFantasia());
		dotModel.set(INSC_ESTADUAL, empresa.getInscEstadual());
		dotModel.set(INSC_MUNICIPAL, empresa.getInscMunicipal());
		listModel.add(dotModel);
	}
	
	@Override
	public EmpresaMirror getTO() {
		return get(EMPRESA);
	}

	@Override
	public String getSecond() {
		return NOME_FANTASIA;
	}

	@Override
	protected void createColumns(FileColumn fc) {
		fc.addColumn(ID, "String", "Código", true);
		fc.addColumn(CNPJ, "String", "CNPJ", true);
		fc.addColumn(NOME_FANTASIA, "String", "Nome fantasia", true);
		fc.addColumn(RAZAO_SOCIAL, "String", "Nome", true);
		fc.addColumn(INSC_ESTADUAL, "String", "Descrição", true);
	}

	@Override
	public String getValueFind() {
		return NOME_FANTASIA;
	}
}