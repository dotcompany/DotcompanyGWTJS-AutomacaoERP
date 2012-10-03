package br.com.dotcompany.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Classe de inicialização dos serviços a serem executados via jobs.
 * 
 * @author sergio
 *
 */
public class JobsConfigureUtil extends ConfigureUtil {

	private static Properties jobFile;
	private static final String JOBS_QUANTIDADE 	= "JOBS_QUANTIDADE";
	private static final String JOBS_			 	= "JOBS_";
	
	public static void loadJobFile(String name){
		String pathFileConf = getPathFileConf();
		String path = null;
		if(pathFileConf == null)
			path = String.format("%s", name);
		else
			path = name;
		jobFile = new Properties();
		File file = new File(path);
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			jobFile.load(fis);
		}catch(IOException e){
			System.out.println("#-------------------------------------------------------#");
			System.out.println("#                                                       #");
			System.out.println("#      O arquivo "+path+" não pode ser carregado!       #");
			System.out.println("#                                                       #");
			System.out.println("#-------------------------------------------------------#");
		}
	}
	
	public static void startJobs() throws Exception{
		Integer cont = Integer.valueOf(jobFile.getProperty(JOBS_QUANTIDADE));
		
		for(; cont >= 1; cont--){
			String value = String.format("%s%s", JOBS_, cont.toString());
			String line = jobFile.getProperty(value).trim();
			int pos = line.indexOf("|");
			String nameClass = getLine(line, 0, pos);
			line = line.substring(pos+1);
			pos = line.indexOf("|");
			String descricao = getLine(line, 1, pos);
			line = line.substring(pos+1);
			pos = line.indexOf("|");
			String expressao = getLine(line, 1, pos);
			Boolean ativo = Boolean.valueOf(getLine(line, pos+1));
			System.out.println(nameClass);
			System.out.println(descricao);
			System.out.println(expressao);
			System.out.println(ativo);
			AgendadorUtil.agendarTarefa(expressao, nameClass);
		}
	}
}