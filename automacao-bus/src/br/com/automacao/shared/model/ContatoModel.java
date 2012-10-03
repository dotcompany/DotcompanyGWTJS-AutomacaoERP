package br.com.automacao.shared.model;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.ContatoMirror;
import br.com.automacao.shared.util.Mirror;

@SuppressWarnings("serial")
public class ContatoModel extends DotModel{

	public final static String CONTATO 		= "contato";
	public final static String ID 				= "id";
	public final static String CPF 				= "cpf";
	public final static String NOME				= "nome";
	
	public ContatoModel() {}
	
	public ContatoModel(FileColumn fc) {
		createColumns(fc);
	}
	
//	public ContatoModel(ContatoMirror contato) {
//		add(contato);
//	}
	
	@Override
	public void add(Mirror mirror) {
		dotModel = new ContatoModel();
		ContatoMirror contato = ((ContatoMirror)mirror); 
		dotModel.set(CONTATO, contato);
		dotModel.set(CPF, contato.getCpf());
		dotModel.set(NOME, contato.getNome());
		dotModel.set(ID, contato.getId());
		listModel.add(dotModel);
	}
	
	@Override
	public ContatoMirror getTO() {
		return get(CONTATO);
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