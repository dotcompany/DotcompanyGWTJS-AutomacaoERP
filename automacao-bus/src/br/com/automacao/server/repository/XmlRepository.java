package br.com.automacao.server.repository;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import br.com.automacao.shared.fo.FileObjectPersist;

import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public abstract class XmlRepository<T extends FileObjectPersist> implements IRepository<T> {

	private List<T> repository;
	
	@SuppressWarnings("unchecked")
	public XmlRepository(final File baseFolder, String folderName) {
		File folder = new File(baseFolder, folderName);
		if (!folder.exists()){
			folder.mkdirs();
		}
		repository = new XmlArrayList(new FilePersistenceStrategy(folder));
	}	
	
	@Override
	public final void put(T fileObject) {
		if (fileObject != null)
			repository.add(fileObject);
	}

	@Override
	public final Iterator<T> getItens() { 
		return repository.iterator();
	}

	@Override
	public final void remove(String identifier) {
		Iterator<T> it = getItens();
		while(it.hasNext()){
			if (it.next().getKey().equals(identifier))			
				it.remove();
		}		
	}	
}