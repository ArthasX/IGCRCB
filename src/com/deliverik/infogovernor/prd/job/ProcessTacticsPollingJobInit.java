/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.prd.job;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.infogovernor.bl.IGSystemConfigResources;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * 概述: 流程策略轮询Job设定
 * 功能描述：添加流程策略轮询JOB任务到Quartz中
 * 创建记录：
 * 修改记录：
 */
public class ProcessTacticsPollingJobInit{
	
	static Log log = LogFactory.getLog(ProcessTacticsPollingJobInit.class);
	public static final String JOB_NAME = "ProcessTacticsPollingJob_JobName_";
	/**
	 * 给流程添加策略Job
	 * @param pdid
	 * @param psdid
	 * @throws ServletException
	 */
	public void addJob(String pdid){
		String ProcessTacticsPollingJob_JOB_NAME = JOB_NAME+pdid; //JOB 名字
		String ProcessTacticsPollingJob_JGROUP_NAME = "ProcessTacticsPollingJob_JGroupName"; //JOB 组名
		String ProcessTacticsPollingJob_TRIGGER_NAME = "ProcessTacticsPollingJob_TriggerName_"+pdid; //Trigger 名字
		String ProcessTacticsPollingJob_TGROUP_NAME = "ProcessTacticsPollingJob_TGroupName"; //Trigger 组名
		String ProcessTacticsPollingJob_RUNTIME = IGSystemConfigResources.PROCESSTACTICSPOLLINGJOB_RUNTIME; //轮巡时间
		try{
			if(JobManager.isJobAdded(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME)){
				log.debug("========================重新添加流程策略JOB执行开始  ==========================");
				JobManager.removeJob(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME, 
						ProcessTacticsPollingJob_TRIGGER_NAME, ProcessTacticsPollingJob_TGROUP_NAME);
				JobManager.addJob(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME,
						ProcessTacticsPollingJob_TRIGGER_NAME,ProcessTacticsPollingJob_TGROUP_NAME, 
						new ProcessTacticsPollingJob(), ProcessTacticsPollingJob_RUNTIME);
				log.debug("========================重新添加流程策略JOB执行结束  ==========================");
			}else{
				log.debug("========================新添加流程策略JOB执行开始  ==========================");
				JobManager.addJob(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME,
						ProcessTacticsPollingJob_TRIGGER_NAME,ProcessTacticsPollingJob_TGROUP_NAME, 
						new ProcessTacticsPollingJob(), ProcessTacticsPollingJob_RUNTIME);
				log.debug("========================新添加流程策略JOB执行结束  ==========================");
			}
		}catch(Exception e){
			log.error("流程策略轮询Job设定异常：", e);
		}
	}
	
	/**
	 * 删除流程策略Job
	 * @param pdid
	 */
	public void removeJob(String pdid){
		String ProcessTacticsPollingJob_JOB_NAME = JOB_NAME+pdid; //JOB 名字
		String ProcessTacticsPollingJob_JGROUP_NAME = "ProcessTacticsPollingJob_JGroupName"; //JOB 组名
		String ProcessTacticsPollingJob_TRIGGER_NAME = "ProcessTacticsPollingJob_TriggerName_"+pdid; //Trigger 名字
		String ProcessTacticsPollingJob_TGROUP_NAME = "ProcessTacticsPollingJob_TGroupName"; //Trigger 组名
		try {
			if(JobManager.isJobAdded(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME)){
				JobManager.removeJob(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME, 
						ProcessTacticsPollingJob_TRIGGER_NAME, ProcessTacticsPollingJob_TGROUP_NAME);
			}
		} catch (Exception e) {
			log.error("流程策略轮询Job删除异常：", e);
		}
	}
}
