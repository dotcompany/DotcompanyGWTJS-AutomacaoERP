package br.com.automacao.server.repository;

import java.io.File;

import br.com.automacao.shared.fo.FileColumn;

public class GridRepository extends XmlRepository<FileColumn> {	
	public GridRepository(final File baseFolder) {		
		super(baseFolder, "grid");			
	}	
	
	public GridRepository(final File baseFolder, String nameClass, String nameFolder) {
		super(baseFolder, "grid/"+nameClass+"/"+nameFolder);			
	}
}
