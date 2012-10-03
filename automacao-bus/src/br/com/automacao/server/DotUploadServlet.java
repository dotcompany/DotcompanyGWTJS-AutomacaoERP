package br.com.automacao.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class DotUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7511275365528206761L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String CAMINHO = "C:/estrutura-marcos-codigos-fontes/automacao-gwt";
		
	    boolean isMultiPart = ServletFileUpload.isMultipartContent(req);      
	    if (!isMultiPart) 
	      return;
	    FileItemFactory factory = new DiskFileItemFactory();    
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    try {
	      List<FileItem> itens = upload.parseRequest(req);
	      if (itens == null || itens.size() == 0)
	        throw new Exception("Campos dos documentos não foram definidos.");      
	      for(FileItem item: itens){
	    	  System.out.println();
	    	  System.out.println("Tipo MIME : " + item.getContentType() + "<br/>");
	    	  System.out.println("Nome do campo: " + item.getFieldName() + "<br/>");
	    	  System.out.println("Nome : " + item.getName() + "<br/>");
	    	  System.out.println("Tamanho : " + item.getSize() + "<br/>");
	    	  //System.out.println("String : " + fi.getString()+"<br/>");
	    	  System.out.println("E form? " + item.isFormField() + "</br>");
	    	  if (!item.isFormField()) {

	    	  // CAMINHO � o diretorio onde serao gravados os arquivos
	    	  File diretorio = new File(CAMINHO);
	    	  if (!diretorio.exists())
	    	  diretorio.mkdir();
	    	  // Mandar o arquivo para o diret�rio upload
	    	  File file = new File(diretorio, item.getName());
	    	  FileOutputStream fos = new FileOutputStream(file);
	    	  InputStream is = item.getInputStream();
	    	  byte[] buffer = new byte[2048];
	    	  int nLidos;
	    	  while ((nLidos = is.read(buffer)) >= 0) {
	    		  fos.write(buffer, 0, nLidos);
	    	  }
	    	  fos.flush();
	    	  fos.close();
	    	  System.out.println("Arquivo gravado em:" + file.getAbsolutePath());

	    	  }
	      }
	    }catch(FileUploadBase.FileSizeLimitExceededException error){
//	      handleError(req, resp, "O tamanho do arquivo excede o limite de " + maxSize + " bytes.");   
	    }catch (Throwable error) {    
	      error.printStackTrace(System.out);
	      handleError(req, resp, error);
	    }
		
	}
	
	private void handleError(HttpServletRequest req, HttpServletResponse resp, Throwable error) {
		handleError(req, resp, "Problema no envio do documento: " + error.getMessage());
	}
	  
	private void handleError(HttpServletRequest req, HttpServletResponse resp, String error) {
		printQuietly(resp, error);
	}
	  
	private static void printQuietly(HttpServletResponse response, String message){
		try{
		  response.getWriter().print(message);
		}catch(IOException e){
		  e.printStackTrace();     
		}      
	}
}