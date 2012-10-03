package br.com.automacao.shared.util;

import java.io.File;
import java.io.PrintWriter;

import br.com.dotcompany.exception.NegocioException;

public class BuildDozer {
	
	private static String TO_QUALIFIED_NAME = "br.com.automacao.ctr.entidade.";

	private static String MIRROR_FOLDER = raiz() + "automacao-bus\\src\\br\\com\\automacao\\shared\\mirror\\";
	private static String MIRROR_QUALIFIED_NAME = "br.com.automacao.shared.mirror.";
	
	private final static String TAG =	"	<mapping>\n" +
									 	"		<class-a>%s</class-a>\n" +
									 	"		<class-b>%s</class-b>\n" +
									 	"	</mapping>\n\n";
	
	private static String XML_FILE = raiz() + "automacao-gwt\\src\\dozerBeanMapping.xml";
	
	private static final String HEADER ="<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
										"	<mappings xmlns=\"http://dozer.sourceforge.net\"\n " +
										"		xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n" +
										"		xsi:schemaLocation=\"http://dozer.sourceforge.net http://dozer.sourceforge.net/schema/beanmapping.xsd\">\n\n";
	
	private static final String END = "</mappings>";
	
	public static void main(String[] args) {
		build();
	}

	private static void build() {
		try{
			File file = new File(MIRROR_FOLDER);
			if(!file.exists()){ throw new NegocioException("Arquivo não encontrado"); }
				
			File fileXml = new File(XML_FILE);
			fileXml.delete();
			fileXml.createNewFile();
			
			PrintWriter writer = new PrintWriter(fileXml);
			writer.append(HEADER);
			
			
			for(File f : file.listFiles()){
				if(!f.isHidden() && !f.isDirectory()){
					String nome = f.getName();
					buildBody(writer, nome.substring(0, nome.length() - 5) );
				}
			}
			
			
			writer.append(END);
			
			writer.flush();
			writer.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private static void buildBody(PrintWriter writer, String mirrorName) {
		String toName = TO_QUALIFIED_NAME + mirrorName.substring(0, mirrorName.length() - 6) + "TO"; 
		writer.append(buildTag(MIRROR_QUALIFIED_NAME.concat(mirrorName), toName));
	}

	private static String buildTag(String mirrorName, String toName){
		return String.format(TAG, mirrorName, toName); 
	}
	
	private static String raiz(){
		String raiz = System.getProperty("java.class.path").split("\\;")[0];
		return raiz.substring(0, raiz.indexOf("automacao-bus"));
	}
}