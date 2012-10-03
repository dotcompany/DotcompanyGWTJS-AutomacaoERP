package br.com.automacao.server.repository;

import br.com.automacao.shared.fo.FileColumn;

public interface GridManager {

	boolean removeStateGrid(String nameClass, String nameFolder, String paramString);
	boolean saveStateGrid(FileColumn fileColumn);
	FileColumn loadStateGrid(String nameClass, String key);
}
