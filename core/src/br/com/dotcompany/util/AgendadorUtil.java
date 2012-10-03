package br.com.dotcompany.util;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Classe que manipula os serviços de jobs.
 * 
 * @author sergio
 *
 */

public class AgendadorUtil {

	private static Scheduler scheduler;
	
	public static void agendarTarefa(String expressao, String nomeClasse) throws Exception{
		JobDetail jobdetail = new JobDetail(nomeClasse, Scheduler.DEFAULT_GROUP, Class.forName(nomeClasse));
		CronTrigger trigger = new CronTrigger();
		trigger.setName(nomeClasse);
		trigger.setCronExpression(expressao);
		getScheduler().scheduleJob(jobdetail, trigger);
	}

	public static void desagendarTarefa(Class<?> clazz) throws SchedulerException{
		getScheduler().unscheduleJob(clazz.getName(), Scheduler.DEFAULT_GROUP);
	}
	
	public static void interromperTarefa(Class<?> clazz) throws Exception{
		getScheduler().interrupt(clazz.getName(), Scheduler.DEFAULT_GROUP);
	}
	
	protected static Scheduler getScheduler() throws SchedulerException {
		if(scheduler == null){
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
		}
		return scheduler;
	}
}