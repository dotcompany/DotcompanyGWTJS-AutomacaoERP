package br.com.automacao.server.repository;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.automacao.shared.fo.FileObjectPersist;
import br.com.dotcompany.core.DotParameters;
import br.com.dotcompany.core.DotRegistry;

public abstract class AbstractRepositoryManager<R extends IRepository<T>, T extends FileObjectPersist> {
	protected static final File BASE_CONFIGURE;
	
	@SuppressWarnings("unchecked")
	protected static Map<String, IRepository> map = new HashMap<String, IRepository>();
	
	static {
	  String path = DotRegistry.getProperty(DotParameters.APPLICATION_PATH);
	  if (!path.endsWith("/") && !path.endsWith("\\"))
	    path += "/";
	  BASE_CONFIGURE = new File(path);
	}
	
//	private final R repository;
	
	protected interface Accepter<T> {
	  public boolean accept(T item);
	}
	
	protected final Accepter<T> DEFAULT = new Accepter<T>(){
	  @Override
	public boolean accept(T item){
	    return true;
	  }
	};
	
//	protected AbstractRepositoryManager(R repository) {
//		this.repository = repository;
//	}	
	
	@SuppressWarnings("unchecked")
	protected synchronized final T loadItem(String key, Accepter<T> accepter){
    try{
      Iterator<T> it = map.get(key).getItens();
      while(it.hasNext()){
        T item = it.next();
        if (accepter != null && accepter.accept(item))
          return item;
      }
      return null;
    }catch(Throwable e){
      return null;
    }
	}
	
	protected synchronized final boolean loadItens(String key, List<T> container) {
	  return loadItens(key, container, DEFAULT);
	}
	
	@SuppressWarnings("unchecked")
	protected synchronized final boolean loadItens(String key, List<T> container, Accepter<T> accepter){
	  try{
      Iterator<T> it =  map.get(key).getItens();
      while(it.hasNext()){
        T item = it.next();
        if (accepter != null && accepter.accept(item))
          container.add(item);
      }        
      return true;      
	  }catch(Throwable e){
	    return false;
	  }
	}	
	
	@SuppressWarnings("unchecked")
	protected synchronized final T getItem(String key, String identifier){
	  try{
      Iterator<T> it =  map.get(key).getItens();
      while(it.hasNext()){
        T item = it.next();
        if (item.getKey().equals(identifier))
          return item;
      }        
      return null;
	  }catch(Throwable e){
	    return null;
	  }
	}

	protected synchronized final boolean removeItem(String key, String identifier) {
		try {
			 map.get(key).remove(identifier);
			return true;
		}catch(Throwable e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	protected synchronized final boolean removeItems(String key, Accepter<T> accepter){
	    try{
	      Iterator<T> it =  map.get(key).getItens();
	      while(it.hasNext()){
	        T item = it.next();
	        if (accepter != null && accepter.accept(item))
	          it.remove();          
	      }        
	      return true;
	    }catch(Throwable e){
	      return false;
	    }
	}

	@SuppressWarnings("unchecked")
	protected synchronized final boolean saveItem(String key, T item) {
		if (removeItem(key, item.getKey()))				
			try{
				 map.get(key).put(item);					
			}catch(Throwable e){
				return false;
			}		
		return true;	
	}

	@SuppressWarnings("unchecked")
	protected synchronized final boolean editItem(String key, String beforeName, T item) {
		if (removeItem(key, beforeName))
			try{
				 map.get(key).put(item);					
			}catch(Throwable e){
				return false;
			}		
		return true;	
	}
}