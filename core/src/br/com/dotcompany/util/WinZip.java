package br.com.dotcompany.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author sergio.filho
 *
 */
public class WinZip {
	   
	
	private static final int TAMANHO_BUFFER = 2048;
    
    
   /**
    * Descompacta um arquivo .zip (ou .war que também é .zip)
    * 
    * @param dir - Diretorio completo do Arquivo .zip
    * @param dirDescompactado - Diretorio onde ele será descompactado
    * @throws IOException 
    */
   public static void descompactar(String dir, String dirDestino) throws IOException {
	   ZipFile zipFile = null;
	   try{
    	  File fileDestino = new File(dirDestino);
    	  if(!fileDestino.exists()){
    		 fileDestino.mkdirs();
    	  }
    	  
          zipFile = new ZipFile(dir);
          Enumeration<?> entries = zipFile.entries();
          while(entries.hasMoreElements()) {
               ZipEntry entry = (ZipEntry) entries.nextElement();
               if(entry.isDirectory()) {
                  System.err.println("Descompactando diretório: " + entry.getName());
                  (new File(dirDestino + entry.getName())).mkdirs();
                  continue;
                }
                //Em alguns zip ele não cria os diretorios antes de criar o arquivo, a verificação é feita aqui
                System.out.println("Descompactando arquivo:" + entry.getName());                
                File file = new File(dirDestino, entry.getName()).getParentFile();
                if(!file.exists()){
                	file.mkdirs();
                }
                copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(dirDestino + File.separator +entry.getName())));
              
           }
           zipFile.close();
       }catch(IOException ioe) {
    	   zipFile.close();
           throw ioe;
       }
    }
   
   public static void main(String[] args) throws Exception {
	   ByteArrayOutputStream bo = new ByteArrayOutputStream();
	   compactar(new File("c:\\Teste"), bo);
	   
	   bo.toByteArray();
	   
	   
	}
   
   
   public static void compactar(File fileFonte, OutputStream os) throws Exception{ 
		  File[] files = fileFonte.listFiles(); 
		  WinZip.criarZip(os, files);
	}  
   
   public static void compactar(String fonte, OutputStream os) throws Exception{ 
		 compactar(new File(fonte), os);
	}  
   
   public static void compactar(String destino, String fonte) throws Exception{
	  File fileDestino = new File(destino);
	  if(fileDestino.exists()){
	   	 deleteFileFromDisk(fileDestino.getAbsolutePath());
	  }
	  fileDestino.createNewFile();   
	  File[] files = new File(fonte).listFiles();
	      
	  WinZip.criarZip(new File(destino), files);
	}  
	 
	private static List<ZipEntry> criarZip(File arquivoZip, File[] arquivos) throws Exception {
	    FileOutputStream fos = new FileOutputStream(arquivoZip);
	    BufferedOutputStream bos = new BufferedOutputStream(fos, TAMANHO_BUFFER);
	    List<ZipEntry> listaEntradasZip = criarZip(bos, arquivos);
	      
	    bos.flush(); bos.close();
	    fos.flush(); fos.close();
	    return listaEntradasZip;
	}

	private static List<ZipEntry> criarZip(OutputStream os, File[] arquivos) throws Exception {
	    List<ZipEntry> listaEntradasZip = new ArrayList<ZipEntry>();
	    ZipOutputStream zos = new ZipOutputStream(os);

	    for(int i = 0; i < arquivos.length; i++) {
	        String caminhoInicial = arquivos[i].getParent();
	        List<ZipEntry> novasEntradas = adicionarArquivoNoZip(zos, arquivos[i], caminhoInicial);
	        if(novasEntradas != null){
	    	   listaEntradasZip.addAll(novasEntradas);
	        }
	    }
	    zos.flush();zos.close();
	    return listaEntradasZip;
    }
	   
	private static List<ZipEntry> adicionarArquivoNoZip(ZipOutputStream zos, File arquivo, String caminhoInicial) throws Exception {
	    List<ZipEntry> listaEntradasZip = new ArrayList<ZipEntry>();
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    byte buffer[] = new byte[TAMANHO_BUFFER];
	    try{
	        //diretórios não são adicionados
	        if(arquivo.isDirectory()) {
	           //recursivamente adiciona os arquivos dos diretórios abaixo
	           File[] arquivos = arquivo.listFiles();
	           for(int i=0; i < arquivos.length; i++){
	               List<ZipEntry> novasEntradas = adicionarArquivoNoZip( zos, arquivos[i], caminhoInicial );
	               if(novasEntradas != null){
	                  listaEntradasZip.addAll(novasEntradas);
	               }
	           }
	           return listaEntradasZip;
	         }
	        	
	         String caminhoEntradaZip = null;
	         int idx = arquivo.getAbsolutePath().indexOf(caminhoInicial);
	         if(idx >= 0) {
	            //calcula os diretórios a partir do diretório inicial
	            //isso serve para não colocar uma entrada com o caminho completo
	            caminhoEntradaZip = arquivo.getAbsolutePath().substring( idx+caminhoInicial.length()+1 );
	          }
	          ZipEntry entrada = new ZipEntry( caminhoEntradaZip );
	          zos.putNextEntry( entrada );
	          zos.setMethod( ZipOutputStream.DEFLATED );
	          fis = new FileInputStream( arquivo );
	          bis = new BufferedInputStream( fis, TAMANHO_BUFFER );
	          int bytesLidos = 0;
	          while((bytesLidos = bis.read(buffer, 0, TAMANHO_BUFFER)) != -1) {
	            	zos.write( buffer, 0, bytesLidos );
	          }
	          listaEntradasZip.add( entrada );
	     }catch(Exception e) {
	         throw e;
	     }finally{
	         if(bis != null){ bis.close();}
	         if(fis != null){ fis.close();}
	     }
	     return listaEntradasZip;
    }
   
	/**
	 * Escreve no OutputStream ( que nessa classe é sempre um BufferedOutputStream) os dados
	 * que estão no InputStream
	 * 
	 * @param in - InputStream
	 * @param out - OutputStream
	 */
    private static void copyInputStream(InputStream in,  OutputStream out) throws IOException {
       byte[] buffer = new byte[1024];
       int len;
       while((len = in.read(buffer)) >= 0){
   	        out.write(buffer, 0, len);
       }
       in.close();
       out.close();
    }
    
	public static boolean deleteFileFromDisk(String completePath){
		try {
			File file = new File(completePath);
			if(file.exists()){
				deleteFile(file, 3, 0);
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		} 
	}
	public static void deleteFile(File file, int tries, int tried) {
	    if (!file.delete()) {
	        System.gc();  // No caso da JVM por sí mesma achar que possui um manipulador para o arquivo
	        if (!file.delete()) {
	            try {  // Agora espera e verifica se o arquivo já foi apagado
	                Thread.sleep(200);
	            }catch (InterruptedException e) {}
	            /* Potencial loop permanete evitado com um contador.
	             * Se o arquivo ainda existe apos todas as tentativas,
	             * desiste. Você agora tem outro problema.
	             */
	            if( tried < tries ){
	                deleteFile(file,tries,tried++);
	            }
	        }
	    }
	}
}
