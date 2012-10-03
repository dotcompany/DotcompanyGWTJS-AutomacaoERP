package br.com.automacao.shared.model;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.FornecedorMirror;
import br.com.automacao.shared.util.Mirror;

@SuppressWarnings("serial")
public class FornecedorModel extends DotModel{

	public final static String FORNECEDOR 		= "fornecedor";
	public final static String ID 				= "id";
	public final static String CPF 				= "cpf";
	public final static String NOME				= "nome";
	
	public FornecedorModel() {}
	
	public FornecedorModel(FileColumn fc) {
		createColumns(fc);
	}
	
//	public FornecedorModel(FornecedorMirror fornecedor) {
//		add(fornecedor);
//	}
	
	@Override
	public void add(Mirror mirror) {
		dotModel = new FornecedorModel();
		FornecedorMirror fornecedor = ((FornecedorMirror)mirror); 
		dotModel.set(FORNECEDOR, fornecedor);
		dotModel.set(CPF, fornecedor.getClass());
		dotModel.set(NOME, fornecedor.getNome());
		dotModel.set(ID, fornecedor.getId());
		listModel.add(dotModel);
	}
	
	@Override
	public FornecedorMirror getTO() {
		return get(FORNECEDOR);
	}

	public String getCpf(){
		return get(CPF);
	}
	
	public String getNome(){
		return get(NOME);
	}

	@Override
	public String getSecond() {
		return getNome();
	}

	@Override
	protected void createColumns(FileColumn fc) {
		fc.addColumn(ID, "String", "Código", true);
		fc.addColumn(CPF, "String", "Cpf", true);
		fc.addColumn(NOME, "String", "Nome", true);
	}

	@Override
	public String getValueFind() {
		return NOME;
	}
}