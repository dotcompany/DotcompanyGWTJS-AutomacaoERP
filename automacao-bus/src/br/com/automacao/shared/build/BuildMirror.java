package br.com.automacao.shared.build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BuildMirror {
	
	private static String TO_FOLDER;
	private static String TO_QUALIFIED_NAME = "br.com.automacao.ctr.entidade";

	private static String MIRROR_FOLDER;
	private static String MIRROR_QUALIFIED_NAME = "br.com.automacao.shared.mirror";
	
	private static String IMPORT_ANNOTATED = "import br.com.dotcompany.core.ServerCalledCommand;";
	private static String IMPORT_MIRROR_BASE = "import br.com.automacao.shared.util.Mirror;";
	private static String ANNOTATED = "@";
	private static boolean isPrintConsole = true;
	
	private static Map<String, String> toToMirror = new HashMap<String, String>();
	private static Map<String, String> toAllPaths = new HashMap<String, String>();
	
	public static void main(String... args) {
		buildPath(args[0]);
		buildAllMirror();
	}
	
	private static void buildAllMirror(){
		scanFilesPaths(TO_FOLDER);
		clearMirrorDirectory(MIRROR_FOLDER);
		for (Map.Entry<String, String> to : toAllPaths.entrySet()) {
			createMirror(to.getKey(), to.getValue());
			if (isPrintConsole) {
				System.out.println("\n\n");
			}
		}
	}
	
	private static void createMirror(String toName, String pathClazz){
		try {
			File fileRd = new File(pathClazz);
			if (!fileRd.exists()){ throw new RuntimeException("Arquivo não encontrado"); }
			
			String mirrorName = toToMirror.get(toName); 
			File fileWt = new File(MIRROR_FOLDER + File.separator + mirrorName + ".java");
		
			BufferedReader br = new BufferedReader(new FileReader(fileRd.getCanonicalPath()));
			PrintWriter    pw = new PrintWriter(fileWt);
			
			String line = br.readLine();
			boolean isAddImport = true;
			
			// Remove todos os imports do referentes as anotações do hibernate
			do {
				if (line.startsWith("package")) {
					// Altera o nome do pacote 
					writer(pw, "package" + " " + MIRROR_QUALIFIED_NAME + ";");
					line = br.readLine();
				}
				if (line.contains("javax.persistence") || line.contains("org.hibernate") || line.contains("TransferObject")) {
					if (isAddImport) {
						// Inclui o importes
						writer(pw, "import" + " " + TO_QUALIFIED_NAME + "." + toName + ";");
						writer(pw, IMPORT_ANNOTATED);
						writer(pw, IMPORT_MIRROR_BASE);
						
						isAddImport = false;
					}
					line = br.readLine();
					continue;
				}
				writer(pw, line);
				line = br.readLine();
			} while (!isAnnotated(line));
			
			while (line != null) {
				if (isAnnotated(line)) {
					do {
						line = br.readLine();
					} while (isAnnotated(line));
					
					if (line.contains("class")) {
						line = builAnnotated(toName, mirrorName, line);		
					} else {
						line = renameTO(line);
					}
				} else {
					line = renameTO(line);
				}
				writer(pw, line);
				line = br.readLine();
			}
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boolean isAnnotated(String line){
		return line.trim().startsWith(ANNOTATED);
	}
	
	private static String renameTO(String line){
		for (Map.Entry<String, String> map : toToMirror.entrySet()) {
			if (line.contains(map.getKey())) {
				line = line.replace(map.getKey(), map.getValue());
			}
		}
		return line;
	}
	
	private static String builAnnotated(String to, String mirrorName, String line){
		String annot = line.replace("TransferObject", "Mirror");
		annot = annot.replace(to, mirrorName);
		line = "@SuppressWarnings(\"serial\")" + "\n";
		line  += "@ServerCalledCommand(" + to + ".class)" + "\n";
		return line += annot;	
	}
	
	private static void scanFilesPaths(String folderPath) {
		StringTokenizer st = new StringTokenizer(folderPath, File.pathSeparator);
		File folder = new File(st.nextToken());
		if (folder == null || !folder.isDirectory()) { return; }
		for (String name : folder.list()) {
			File content = new File(folder.getAbsolutePath() + File.separator + name);
			if (content.isFile()) {
				String to = name.split("\\.")[0];
				String mirror = to.substring(0, to.length() - 2) + "Mirror";
				toToMirror.put(to, mirror);
				toAllPaths.put(to, content.getAbsolutePath());
			}
		}
	}

	private static void clearMirrorDirectory(String folderPath){
		StringTokenizer st = new StringTokenizer(folderPath, File.pathSeparator);
		File folder = new File(st.nextToken());
		if (folder == null || !folder.isDirectory()) { return; }
		File[] sun = folder.listFiles();
		for (File toDelete : sun) {
			toDelete.delete();
		}  
	}
	
	private static void writer(PrintWriter pw, String line){
		pw.println(line);
		if (isPrintConsole) {
			System.out.println(line);
		}
	}
	
	private static void buildPath(String path){
		TO_FOLDER = path + "\\src\\br\\com\\automacao\\ctr\\entidade\\";
		MIRROR_FOLDER = path + "\\src\\br\\com\\automacao\\shared\\mirror\\";
	}
}