package br.com.automacao.shared.fo;

import java.util.ArrayList;
import java.util.List;

public class FileColumn extends FileObjectPersist {

	private String nameClasse;
	
	private int height;
	
	private int width;

	private int positionX;
	
	private int positionY;

	private List<Column> colunas;

	protected FileColumn() {
		super("");
	}
	
	public FileColumn(String key, String nameClasse) {
		super(key);
		this.nameClasse = nameClasse;
		colunas = new ArrayList<Column>();
	}
	
	public void addColumn(Column col){
		colunas.add(col);
	}

	public void addColumn(String nome, String tipo, String label, Boolean ativo) {
		colunas.add(new Column(nome, tipo, label, ativo));
	}

	public void clear(){
		if(colunas != null)
			colunas.clear();
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int size(){
		return colunas.size();
	}
	
	public String getNameClasse() {
		return nameClasse;
	}

	public List<Column> getColunas() {
		return colunas;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}