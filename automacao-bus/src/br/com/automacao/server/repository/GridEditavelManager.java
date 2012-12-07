package br.com.automacao.server.repository;

import br.com.automacao.shared.fo.FileColumn;

public interface GridEditavelManager {

	boolean removeStateGridEditavel(String nameClass, String nameFolder, String paramString);
	boolean saveStateGridEditavel(FileColumn fileColumn);
	FileColumn loadStateGridEditavel(String nameClass, String key);
}
