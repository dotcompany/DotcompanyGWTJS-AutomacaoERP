package br.com.automacao.server.repository;

import java.io.File;

import br.com.automacao.shared.fo.FileColumn;

public class GridEditavelRepository extends XmlRepository<FileColumn> {	
	public GridEditavelRepository(final File baseFolder) {		
		super(baseFolder, "gridEditavel");			
	}	
	
	public GridEditavelRepository(final File baseFolder, String nameClass, String nameFolder) {
		super(baseFolder, "gridEditavel/"+nameClass+"/"+nameFolder);			
	}
}
