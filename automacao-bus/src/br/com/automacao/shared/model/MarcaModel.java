package br.com.automacao.shared.model;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.MarcaMirror;
import br.com.automacao.shared.util.Mirror;

@SuppressWarnings("serial")
public class MarcaModel extends DotModel{


	public final static String MARCA 		= "marca";
	public final static String ID 			= "id";
	public final static String NOME 		= "nome";
	public final static String DESCRICAO 		= "descricao";

	
	public MarcaModel() {}
	
	//public MarcaModel(MarcaMirror marca) {
	//add(marca);
	//}
	
	public MarcaModel(FileColumn fc) {
		createColumns(fc);
	}

	@Override
	public void add(Mirror mirror) {
		dotModel = new MarcaModel();
		MarcaMirror marca = ((MarcaMirror)mirror); 
		dotModel.set(MARCA, marca);
		dotModel.set(NOME, marca.getNome());
		dotModel.set(DESCRICAO, marca.getDescricao());
		dotModel.set(ID, marca.getId());
		listModel.add(dotModel);
	}
	
	@Override
	public MarcaMirror getTO() {
		return get(MARCA);
	}



	public String getNome(){
		return get(NOME);
	}
	
	public String getDescricao(){
		return get(DESCRICAO);
	}

	@Override
	public String getSecond() {
		return getNome();
	}

	@Override
	protected void createColumns(FileColumn fc) {
		fc.addColumn(ID, "Long", "Código", true);
		fc.addColumn(NOME, "String", "Nome", true);
		fc.addColumn(DESCRICAO, "String", "Descricao", true);
	}

	@Override
	public String getValueFind() {
		return NOME;
	}
}
