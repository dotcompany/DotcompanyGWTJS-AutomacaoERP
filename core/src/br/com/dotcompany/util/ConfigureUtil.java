package br.com.dotcompany.util;

/**
 * Busca o caminho onde esta setado o arquivo de jobs.
 * 
 * @author sergio
 *
 */
public class ConfigureUtil {

	private static final String PATH_FILE_CONF = "path.sigimb.conf";
	
	protected static final String getPathFileConf(){
		String path = System.getProperty(PATH_FILE_CONF);
		if(path == null) return null;
		if(!path.endsWith("/") || !path.endsWith("\\"))
			path += "/";
		return path;
	}
	
	protected static final String getLine(String line, int pos){
		return line.substring(pos+1).trim();
	}

	protected static final String getLine(String line, int init, int fim){
		return line.substring(init, fim).trim();
	}
}