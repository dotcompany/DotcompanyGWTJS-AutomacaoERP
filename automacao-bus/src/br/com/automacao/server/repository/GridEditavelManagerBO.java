package br.com.automacao.server.repository;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.util.Utils;

public class GridEditavelManagerBO extends AbstractRepositoryManager<GridEditavelRepository, FileColumn> implements GridEditavelManager {
	
	private static GridEditavelManagerBO INSTANCE = null;

	private GridEditavelManagerBO(){}
	
	public static GridEditavelManagerBO getInstance() {
		if(INSTANCE == null) INSTANCE = new GridEditavelManagerBO();
		return INSTANCE;
	}

	private static final GridEditavelRepository getGridEditavelManager(String nameClass, String nameFolder) {
		String path = Utils.normalize(nameClass)+nameFolder;
		GridEditavelRepository repository = (GridEditavelRepository) map.get(path); 
		if(repository == null){
			repository = new GridEditavelRepository(BASE_CONFIGURE, Utils.normalize(nameClass), nameFolder);
			
			map.put(path, repository);
		}
		return repository;
	}
	
	@Override
	public boolean removeStateGridEditavel(String nameClass, String nameFolder, String identifier) {
		getGridEditavelManager(nameClass, nameFolder);
		return super.removeItem(Utils.normalize(nameClass)+nameFolder, identifier);
	}

	@Override
	public boolean saveStateGridEditavel(FileColumn item) {
		String nameClass = item.getNameClasse();
		String key = item.getKey();
		getGridEditavelManager(nameClass, key);
		return super.saveItem(Utils.normalize(nameClass)+key, item);
	}

	@Override
	public FileColumn loadStateGridEditavel(String nameClass, String key) {
		getGridEditavelManager(nameClass, key);
		return super.getItem(Utils.normalize(nameClass)+key, key);
	}
}