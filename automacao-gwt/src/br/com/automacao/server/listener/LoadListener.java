package br.com.automacao.server.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.dotcompany.core.DotConfigureUtil;
import br.com.dotcompany.util.JobsConfigureUtil;

public class LoadListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent context) {}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		ServletContext sc = context.getServletContext();
		/* Configura o jobs */
		configureJobs(sc);
		/* Registry */
		registry(sc);
	}
	
	private void configureJobs(ServletContext sc){
		String jobFile = "jobs.properties";
		String path = String.format("%s\\%s", sc.getRealPath(""), "\\resources\\properties\\") + jobFile;
		JobsConfigureUtil.loadJobFile(path);
		try {
			JobsConfigureUtil.startJobs();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registry(ServletContext sc) {
		DotConfigureUtil.registry(sc);
	}
}