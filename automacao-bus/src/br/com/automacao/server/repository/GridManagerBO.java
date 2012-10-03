package br.com.automacao.server.repository;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.util.Utils;

public class GridManagerBO extends AbstractRepositoryManager<GridRepository, FileColumn> implements GridManager {
	
	private static GridManagerBO INSTANCE = null;

	private GridManagerBO(){}
	
	public static GridManagerBO getInstance() {
		if(INSTANCE == null) INSTANCE = new GridManagerBO();
		return INSTANCE;
	}

	private static final GridRepository getGridManager(String nameClass, String nameFolder) {
		String path = Utils.normalize(nameClass)+nameFolder;
		GridRepository repository = (GridRepository) map.get(path); 
		if(repository == null){
			repository = new GridRepository(BASE_CONFIGURE, Utils.normalize(nameClass), nameFolder);
			
			map.put(path, repository);
		}
		return repository;
	}
	
	@Override
	public boolean removeStateGrid(String nameClass, String nameFolder, String identifier) {
		getGridManager(nameClass, nameFolder);
		return super.removeItem(Utils.normalize(nameClass)+nameFolder, identifier);
	}

	@Override
	public boolean saveStateGrid(FileColumn item) {
		String nameClass = item.getNameClasse();
		String key = item.getKey();
		getGridManager(nameClass, key);
		return super.saveItem(Utils.normalize(nameClass)+key, item);
	}

	@Override
	public FileColumn loadStateGrid(String nameClass, String key) {
		getGridManager(nameClass, key);
		return super.getItem(Utils.normalize(nameClass)+key, key);
	}
}