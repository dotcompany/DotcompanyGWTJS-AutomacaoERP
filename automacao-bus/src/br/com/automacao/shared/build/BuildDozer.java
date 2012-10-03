package br.com.automacao.shared.build;

import java.io.File;
import java.io.PrintWriter;

public class BuildDozer {
	
	private static String TO_QUALIFIED_NAME = "br.com.automacao.ctr.entidade.";

	private static String MIRROR_FOLDER;
	private static String MIRROR_QUALIFIED_NAME = "br.com.automacao.shared.mirror.";
	
	private final static String TAG =	"	<mapping>\n" +
									 	"		<class-a>%s</class-a>\n" +
									 	"		<class-b>%s</class-b>\n" +
									 	"	</mapping>\n\n";
	
	private static String XML_FILE;
	
	private static final String HEADER ="<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
										"	<mappings xmlns=\"http://dozer.sourceforge.net\"\n " +
										"		xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n" +
										"		xsi:schemaLocation=\"http://dozer.sourceforge.net http://dozer.sourceforge.net/schema/beanmapping.xsd\">\n\n";
	
	private static final String END = "</mappings>";
	private static boolean isPrintConsole = true;
	
	public static void main(String... args) {
		buildPath(args[0]);
		build();
	}

	private static void build() {
		try{
			File file = new File(MIRROR_FOLDER);
			if(!file.exists()){ throw new RuntimeException("Arquivo não encontrado"); }
			File fileXml = new File(XML_FILE);
			fileXml.delete();
			fileXml.createNewFile();
			PrintWriter writer = new PrintWriter(fileXml);
			writer.append(HEADER);
			if (isPrintConsole) {
				System.out.println(HEADER);
			}
			for(File f : file.listFiles()){
				if(!f.isHidden() && !f.isDirectory()){
					String nome = f.getName();
					buildBody(writer, nome.substring(0, nome.length() - 5) );
				}
			}
			writer.append(END);
			if (isPrintConsole) {
				System.out.println(END);
			}
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
		String ret =  String.format(TAG, mirrorName, toName);
		if (isPrintConsole) {
			System.out.println(ret);
		}
		return ret; 
	}
	
	private static void buildPath(String path){
		MIRROR_FOLDER = path + "\\src\\br\\com\\automacao\\shared\\mirror\\";
		XML_FILE = path + "\\src\\dozerBeanMapping.xml";
	}
}