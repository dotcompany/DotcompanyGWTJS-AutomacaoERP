package br.com.dotcompany.core;

import java.io.File;

import javax.servlet.ServletContext;


public class DotConfigureUtil {

	public static final void registry(ServletContext sc){
		String realPath = sc.getRealPath("");
		if(!realPath.endsWith("\\"))
			realPath+= File.separator;
		realPath+= "WEB-INF" + File.separator + "dotcompany-base" + File.separator;
		DotRegistry.setProperty(DotParameters.APPLICATION_PATH, realPath);
	}
}