/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.prd.job;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.infogovernor.bl.IGSystemConfigResources;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * ����: ���̲�����ѯJob�趨
 * ����������������̲�����ѯJOB����Quartz��
 * ������¼��
 * �޸ļ�¼��
 */
public class ProcessTacticsPollingJobInit{
	
	static Log log = LogFactory.getLog(ProcessTacticsPollingJobInit.class);
	public static final String JOB_NAME = "ProcessTacticsPollingJob_JobName_";
	/**
	 * ��������Ӳ���Job
	 * @param pdid
	 * @param psdid
	 * @throws ServletException
	 */
	public void addJob(String pdid){
		String ProcessTacticsPollingJob_JOB_NAME = JOB_NAME+pdid; //JOB ����
		String ProcessTacticsPollingJob_JGROUP_NAME = "ProcessTacticsPollingJob_JGroupName"; //JOB ����
		String ProcessTacticsPollingJob_TRIGGER_NAME = "ProcessTacticsPollingJob_TriggerName_"+pdid; //Trigger ����
		String ProcessTacticsPollingJob_TGROUP_NAME = "ProcessTacticsPollingJob_TGroupName"; //Trigger ����
		String ProcessTacticsPollingJob_RUNTIME = IGSystemConfigResources.PROCESSTACTICSPOLLINGJOB_RUNTIME; //��Ѳʱ��
		try{
			if(JobManager.isJobAdded(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME)){
				log.debug("========================����������̲���JOBִ�п�ʼ  ==========================");
				JobManager.removeJob(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME, 
						ProcessTacticsPollingJob_TRIGGER_NAME, ProcessTacticsPollingJob_TGROUP_NAME);
				JobManager.addJob(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME,
						ProcessTacticsPollingJob_TRIGGER_NAME,ProcessTacticsPollingJob_TGROUP_NAME, 
						new ProcessTacticsPollingJob(), ProcessTacticsPollingJob_RUNTIME);
				log.debug("========================����������̲���JOBִ�н���  ==========================");
			}else{
				log.debug("========================��������̲���JOBִ�п�ʼ  ==========================");
				JobManager.addJob(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME,
						ProcessTacticsPollingJob_TRIGGER_NAME,ProcessTacticsPollingJob_TGROUP_NAME, 
						new ProcessTacticsPollingJob(), ProcessTacticsPollingJob_RUNTIME);
				log.debug("========================��������̲���JOBִ�н���  ==========================");
			}
		}catch(Exception e){
			log.error("���̲�����ѯJob�趨�쳣��", e);
		}
	}
	
	/**
	 * ɾ�����̲���Job
	 * @param pdid
	 */
	public void removeJob(String pdid){
		String ProcessTacticsPollingJob_JOB_NAME = JOB_NAME+pdid; //JOB ����
		String ProcessTacticsPollingJob_JGROUP_NAME = "ProcessTacticsPollingJob_JGroupName"; //JOB ����
		String ProcessTacticsPollingJob_TRIGGER_NAME = "ProcessTacticsPollingJob_TriggerName_"+pdid; //Trigger ����
		String ProcessTacticsPollingJob_TGROUP_NAME = "ProcessTacticsPollingJob_TGroupName"; //Trigger ����
		try {
			if(JobManager.isJobAdded(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME)){
				JobManager.removeJob(ProcessTacticsPollingJob_JOB_NAME, ProcessTacticsPollingJob_JGROUP_NAME, 
						ProcessTacticsPollingJob_TRIGGER_NAME, ProcessTacticsPollingJob_TGROUP_NAME);
			}
		} catch (Exception e) {
			log.error("���̲�����ѯJobɾ���쳣��", e);
		}
	}
}
