package com.deliverik.infogovernor.scheduling.jobs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * @Description: QUARTZ管理器
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */

public class JobManager {
	private static Scheduler scheduler = WebApplicationSupport.getScheduler();
	private static String JOB_GROUP_NAME = "job_group";
	public static String TRIGGER_GROUP_NAME = "trigger_group";
	private static Log log = LogFactory.getLog(JobManager.class);

	public static void addJob(String jobName, Job job, String cronExpression)
			throws ParseException, SchedulerException {
//		JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, job
//				.getClass());
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, JOB_GROUP_NAME);
        JobDetail jobDetail = jobBuilder.build();
//		CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);
//		trigger.setCronExpression(cronExpression);
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
		triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
		Trigger trigger = triggerBuilder.build();
		scheduler.scheduleJob(jobDetail, trigger);
		if (!scheduler.isShutdown())
			scheduler.start();
	}
	
	public static void addJob(String jobName, Job job, String cronExpression,Map<String,Object> argsMap)
			throws ParseException, SchedulerException {
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
		jobBuilder.withIdentity(jobName, JOB_GROUP_NAME);
		JobDetail jobDetail = jobBuilder.build();
		Set<String> argsKeys = argsMap.keySet();
		Iterator<String> keysIterator = argsKeys.iterator();
		while (keysIterator.hasNext()) {
			String key = keysIterator.next();
			jobDetail.getJobDataMap().put(key, argsMap.get(key));
		}
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
		triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
		Trigger trigger = triggerBuilder.build();
		scheduler.scheduleJob(jobDetail, trigger);
		if (!scheduler.isShutdown())
			scheduler.start();
	}

	public static void addJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName, Job job,
			String cronExpression) throws SchedulerException, ParseException {
//		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job
//				.getClass());
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, jobGroupName);
        JobDetail jobDetail = jobBuilder.build();
//		CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);
//		trigger.setCronExpression(cronExpression);
        
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, triggerGroupName);
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
        Trigger trigger = triggerBuilder.build();
		scheduler.scheduleJob(jobDetail, trigger);
		if (!scheduler.isShutdown())
			scheduler.start();
	}

	public static void modifyJobTime(String jobName, String cronExpression)
			throws SchedulerException, ParseException {
//		Trigger trigger = scheduler.getTrigger(jobName, TRIGGER_GROUP_NAME);
//		if (trigger != null) {
//			CronTrigger ct = (CronTrigger) trigger;
//			ct.setCronExpression(cronExpression);
//			scheduler.resumeTrigger(jobName, TRIGGER_GROUP_NAME);
//		}
		 Trigger trigger = scheduler.getTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));
        if (trigger != null) {
            CronTriggerImpl ct = (CronTriggerImpl) trigger;
            ct.setCronExpression(cronExpression);
            scheduler.resumeTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));
        }
	}

	public static void modifyJobTime(String triggerName,
			String triggerGroupName, String cronExpression)
			throws SchedulerException, ParseException {
//		Trigger trigger = scheduler.getTrigger(triggerName, triggerGroupName);
//		if (trigger != null) {
//			CronTrigger ct = (CronTrigger) trigger;
//			// 修改时间
//			ct.setCronExpression(cronExpression);
//			// 重启触发器
//			//scheduler.resumeTrigger(triggerName, triggerGroupName);
//			scheduler.rescheduleJob(triggerName,triggerGroupName, ct);
//		}
		Trigger trigger = scheduler.getTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
        if (trigger != null) {
            CronTriggerImpl ct = (CronTriggerImpl) trigger;
            // 修改时间
            ct.setCronExpression(cronExpression);
            // 重启触发器
            // scheduler.resumeTrigger(triggerName, triggerGroupName);
            scheduler.rescheduleJob(TriggerKey.triggerKey(triggerName, triggerGroupName), ct);
        }
	}

	public static void removeJob(String jobName) throws SchedulerException {
	    scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));// 停止触发器
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));// 移除触发器
        scheduler.deleteJob(JobKey.jobKey(jobName, JOB_GROUP_NAME));// 删除任务
	}

	public static void removeJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName)
			throws SchedulerException {
	    scheduler.pauseTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));// 停止触发器
        scheduler.unscheduleJob(TriggerKey.triggerKey(triggerName, triggerGroupName));// 移除触发器
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
	}

	/**
	 * 风险检查
	 */
	public static void addJob(String jobName, String jobGroupName,
			String triggerName,String triggerGroupName, Job job ,List<String> keyname, Map<String,Integer> args, String cronExpression,Date startTime,Date endTime)
			throws SchedulerException, ParseException {
		
//		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job.getClass());
		
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, jobGroupName);
        JobDetail jobDetail = jobBuilder.build();
//		CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);
		
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, triggerGroupName);
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
        Trigger trigger = triggerBuilder.build();
		
		for(String temp : keyname){
			jobDetail.getJobDataMap().put(temp, args.get(temp));
		}
			
		try {
		    CronTriggerImpl ct = (CronTriggerImpl) trigger;
		    ct.setCronExpression(cronExpression);
		    ct.setStartTime(startTime);   
		    ct.setEndTime(endTime);   
		    ct.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
		    
		    scheduler.scheduleJob(jobDetail, ct);
			if (!scheduler.isShutdown())
				scheduler.start();
		} catch (ParseException e) {
			log.error("trigger.setCronExpression(cronExpression) Exception: ",e);
			
		} catch (SchedulerException e) {
			log.error("scheduler.scheduleJob(jobDetail, trigger) Exception: ",e);
			throw new SchedulerException();
		}
       

	}
	
	/**
	 * CCSMS
	 */
	public static void addJob(String jobName, String jobGroupName,
			String triggerName, Job job ,List<String> keyname, Map<String,String> args)
			throws SchedulerException, ParseException {
		
//		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job
//				.getClass());
		
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, jobGroupName);
        JobDetail jobDetail = jobBuilder.build();
		for(String temp : keyname){
			jobDetail.getJobDataMap().put(temp, args.get(temp));
		}
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, TRIGGER_GROUP_NAME);
        triggerBuilder.startAt(new Date());
        Trigger trigger = triggerBuilder.build();
//		Trigger trigger = TriggerUtils.makeImmediateTrigger(0, 0);  
//        trigger.setName(triggerName);   
       //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        
		scheduler.scheduleJob(jobDetail, trigger);
		if (!scheduler.isShutdown())
			scheduler.start();

	}
	
	/**
	 * collect
	 */
	public static void addJob(String jobName, String jobGroupName,
			String triggerName,String triggerGroupName,  Job job ,List<String> keyname, 
			Map<String,Object> args, Date startTime, Date endTime, String cronExpression)
			throws SchedulerException, ParseException {
		
//		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job
//				.getClass());
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, jobGroupName);
        JobDetail jobDetail = jobBuilder.build();
		for(String temp : keyname){
			jobDetail.getJobDataMap().put(temp, args.get(temp));
		}
//		CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);
//		trigger.setCronExpression(cronExpression);
		
		 Trigger trigger = scheduler.getTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));
        if (trigger != null) {
            CronTriggerImpl ct = (CronTriggerImpl) trigger;
            ct.setCronExpression(cronExpression);
            scheduler.resumeTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));
            ct.setStartTime(startTime);
            if(endTime!=null){
            	ct.setEndTime(endTime);
            }

    		scheduler.scheduleJob(jobDetail, ct);
    		if (!scheduler.isShutdown())
    			scheduler.start();
        }
	}

	//服务策略
	public static void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, 
			Job job, String cronExpression,Date startTime,Date endTime) throws SchedulerException {
//		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job.getClass());
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, jobGroupName);
        JobDetail jobDetail = jobBuilder.build();
        
//		CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, triggerGroupName);
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
        Trigger trigger = triggerBuilder.build();
        CronTriggerImpl ct = (CronTriggerImpl) trigger;
		try {
		    ct.setCronExpression(cronExpression);
		    ct.setStartTime(startTime);   
		    ct.setEndTime(endTime);   
		} catch (ParseException e) {
			log.error("trigger.setCronExpression(cronExpression) Exception: ",e);
		}
		try {
			scheduler.scheduleJob(jobDetail, ct);
			if (!scheduler.isShutdown())
				scheduler.start();
		} catch (SchedulerException e) {
			log.error("scheduler.scheduleJob(jobDetail, trigger) Exception: ",e);
			throw new SchedulerException();
		}
	}
	
	/**
	 * 2009-09-28 edit by  
	 * @param triggerName
	 * @param triggerGroupName
	 * @param cronExpression
	 * @param startTime
	 * @param endTime
	 * @throws SchedulerException
	 */
	public static void modifyJobTime(String triggerName,String triggerGroupName,
			String cronExpression,Date startTime,Date endTime) throws SchedulerException {
		Trigger trigger = null;
		try {
			
			trigger = scheduler.getTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
			//scheduler.pauseTrigger(triggerName, triggerName);// 停止触发器
			
		} catch (SchedulerException e) {
			log.error("scheduler.getTrigger(triggerName, triggerGroupName) Exception: ",e);
		}
		
		if (trigger != null) {
			//trigger.setStartTime(startTime);   
	       // trigger.setEndTime(endTime); 
		    CronTriggerImpl ct = (CronTriggerImpl) trigger;
			// 修改时间
			try {
				ct.setCronExpression(cronExpression);
				ct.setStartTime(startTime);
				ct.setEndTime(endTime); 
			} catch (ParseException e) {
				log.error("ct.setCronExpression(cronExpression) Exception: ",e);
			}
			// 重启触发器
			try {
				//scheduler.resumeTrigger(triggerName, triggerGroupName);
				scheduler.rescheduleJob(TriggerKey.triggerKey(triggerName, triggerGroupName), ct);
			} catch (SchedulerException e) {
				log.error("scheduler.resumeTrigger(triggerName, triggerGroupName) Exception: ",e);
				throw new SchedulerException();
			}
		}
	}
	
	/**
	 * RiskCheck(风险检查)
	 */
	public static void modifyJobTimeForRiskCheck(String triggerName,String triggerGroupName,
			String cronExpression,Date startTime,Date endTime) throws SchedulerException {
		Trigger trigger = null;
		try {
			
			trigger = scheduler.getTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
			//scheduler.pauseTrigger(triggerName, triggerName);// 停止触发器
			
		} catch (SchedulerException e) {
			log.error("scheduler.getTrigger(triggerName, triggerGroupName) Exception: ",e);
		}
		
		if (trigger != null) {
			//trigger.setStartTime(startTime);   
	       // trigger.setEndTime(endTime); 
		    CronTriggerImpl ct = (CronTriggerImpl) trigger;
			// 修改时间
			try {
				ct.setCronExpression(cronExpression);
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				String nowdate  = IGStringUtils.getCurrentDate();//当前日期
				if(nowdate.equals(format.format(startTime))){
					//开始日期为今天
					Calendar c = Calendar.getInstance();
					c.setTime(startTime);
					int day = c.get(Calendar.DAY_OF_MONTH);
					c.set(Calendar.DAY_OF_MONTH,day+1);   
					Date old_time = c.getTime();   

					ct.setStartTime(format.parse(format.format(old_time)));//下一天
					
				}else{
					ct.setStartTime(startTime);
				}

				ct.setEndTime(endTime); 
			} catch (ParseException e) {
				log.error("ct.setCronExpression(cronExpression) Exception: ",e);
			}
			// 重启触发器
			try {
				//scheduler.resumeTrigger(triggerName, triggerGroupName);
				scheduler.rescheduleJob(TriggerKey.triggerKey(triggerName, triggerGroupName), ct);
			} catch (SchedulerException e) {
				log.error("scheduler.resumeTrigger(triggerName, triggerGroupName) Exception: ",e);
				throw new SchedulerException();
			}
		}
	}
	
	public static void addMailJob(String jobName, String jobGroupName, String triggerName, 
			Job job , Map<String,Object> argsMap) throws SchedulerException, ParseException {
//		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job.getClass());
		
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, jobGroupName);
        JobDetail jobDetail = jobBuilder.build();
        
		Set<String> argsKeys = argsMap.keySet();
		Iterator<String> keysIterator = argsKeys.iterator();
		while(keysIterator.hasNext()){
			String key = keysIterator.next();
			jobDetail.getJobDataMap().put(key, argsMap.get(key));
		}
//		Trigger trigger = TriggerUtils.makeImmediateTrigger(0, 0);     
//        trigger.setName(triggerName);
        
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, TRIGGER_GROUP_NAME);
        triggerBuilder.startAt(new Date());
        Trigger trigger = triggerBuilder.build();
        
		scheduler.scheduleJob(jobDetail, trigger);
		if (!scheduler.isShutdown())
			scheduler.start();
	}
	
	/**
	 * 添加实时job
	 * 
	 * @param jobName job名称
	 * @param jobGroupName job组名
	 * @param triggerName 触发器名
	 * @param triggerGroupName 触发器组名
	 * @param job
	 * @param argsMap
	 */
	public static void addRealTimeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, 
            Job job , Map<String,Object> argsMap) throws SchedulerException, ParseException {
	    
	    JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, jobGroupName);
        JobDetail jobDetail = jobBuilder.build();
        
        Set<String> argsKeys = argsMap.keySet();
        Iterator<String> keysIterator = argsKeys.iterator();
        while(keysIterator.hasNext()){
            String key = keysIterator.next();
            jobDetail.getJobDataMap().put(key, argsMap.get(key));
        }
        
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, triggerGroupName);
        triggerBuilder.startAt(new Date());
        Trigger trigger = triggerBuilder.build();
        
        scheduler.scheduleJob(jobDetail, trigger);
        if (!scheduler.isShutdown()){
            scheduler.start();
        }
	}
	
	
	/**
	 * 判断是否已添加过该job
	 * @param triggerName
	 * @param triggerGroupName
	 * @param cronExpression
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	public static boolean isJobAdded(String jobname) throws SchedulerException, ParseException {
		JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobname, JOB_GROUP_NAME));
		if (jobDetail != null) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否已添加过该job
	 * @param triggerName
	 * @param triggerGroupName
	 * @param cronExpression
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	public static boolean isJobAdded(String jobName,String jobGroupName) throws SchedulerException, ParseException {
		JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
		if (jobDetail != null) {
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isJobAddedForDashBoard(String jobname,String jobGroupName) throws SchedulerException, ParseException {
		JobDetail jobDetail = scheduler.getJobDetail(new JobKey(jobname, jobGroupName));
		if (jobDetail != null) {
			return true;
		}else{
			return false;
		}
	}
	
	/** SOC添加 **/
	/**
	 * 业务故障分析（SOC_IGPRR01BLImpl调用）
	 */
	public static void addJobForFaultAnalyse(String jobName, String jobGroupName,
			String triggerName, Job job ,Integer prid,String keyName)
			throws SchedulerException, ParseException {
		
//		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job
//				.getClass());
		
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
        jobBuilder.withIdentity(jobName, jobGroupName);
        JobDetail jobDetail = jobBuilder.build();
		jobDetail.getJobDataMap().put(keyName, prid);	
//		Trigger trigger = TriggerUtils.makeImmediateTrigger(0, 0);     
//        trigger.setName(triggerName);   
        
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, TRIGGER_GROUP_NAME);
        triggerBuilder.startAt(new Date());
        Trigger trigger = triggerBuilder.build();
       //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        
		scheduler.scheduleJob(jobDetail, trigger);
		if (!scheduler.isShutdown())
			scheduler.start();

	}
	public static void addJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName, Job job,
			List<String> keyname, Map<String,Integer> args,
			String cronExpression) throws SchedulerException, ParseException {
//		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job
//				.getClass());
		JobBuilder jobBuilder = JobBuilder.newJob(job.getClass());
		jobBuilder.withIdentity(jobName, jobGroupName);
		JobDetail jobDetail = jobBuilder.build();
//		CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);
//		trigger.setCronExpression(cronExpression);
		
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		triggerBuilder.withIdentity(triggerName, triggerGroupName);
		triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
		Trigger trigger = triggerBuilder.build();
		for(String temp : keyname){
			jobDetail.getJobDataMap().put(temp, args.get(temp));
		}
		scheduler.scheduleJob(jobDetail, trigger);
		if (!scheduler.isShutdown())
			scheduler.start();
	}
}