package br.com.automacao.shared.model;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.ClienteMirror;
import br.com.automacao.shared.util.Mirror;

@SuppressWarnings("serial")
public class ClienteModel extends DotModel{

	public final static String CLIENTE 			= "cliente";
	public final static String CPF 				= "cpf";
	public final static String SOBRENOME		= "sobrenome";
	public final static String PRIMEIRO_NOME	= "primeiroNome";
	public final static String DESCRICAO		= "descricao";
	
	public ClienteModel() {}
	
	public ClienteModel(FileColumn fc) {
		createColumns(fc);
	}
	
	@Override
	public void add(Mirror mirror) {
		dotModel = new ClienteModel();
		ClienteMirror cliente = ((ClienteMirror)mirror); 
		dotModel.set(CLIENTE, cliente);
		dotModel.set(ID, cliente.getId());
		dotModel.set(CPF, cliente.getCpf());
		dotModel.set(PRIMEIRO_NOME, cliente.getPrimeiroNome());
		dotModel.set(SOBRENOME, cliente.getSobrenome());
		dotModel.set(DESCRICAO, cliente.getDescricao());
		listModel.add(dotModel);
	}
	
	public ClienteMirror getCliente(){
		return get("cliente");
	}

	@Override
	public ClienteMirror getTO() {
		return get("cliente");
	}

	public String getCpf(){
		return get(CPF);
	}
	
	public String getNome(){
		return get(PRIMEIRO_NOME);
	}

	@Override
	public String getSecond() {
		return getNome();
	}

	@Override
	protected void createColumns(FileColumn fc) {
		fc.addColumn(ID, "String", "C\u00F3digo", true);
		fc.addColumn(CPF, "String", "CPF", true);
		fc.addColumn(PRIMEIRO_NOME, "String", "Nome", true);
		fc.addColumn(SOBRENOME, "String", "Sobrenome", true);
		fc.addColumn(DESCRICAO, "String", "Descrição", true);
	}

	@Override
	public String getValueFind() {
		return PRIMEIRO_NOME;
	}
}