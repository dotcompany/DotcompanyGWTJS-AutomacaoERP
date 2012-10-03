package br.com.automacao.server.jobs;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Classe de exemplo da utiliza��o do agendamento de tarefas. Essa classe foi
 * mapeada no arquivo jobs.properties
 * 
 * @author sergio
 * 
 */
public class Tarefa implements Job {
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//System.out.println("teste: " + new Date());
	}
}