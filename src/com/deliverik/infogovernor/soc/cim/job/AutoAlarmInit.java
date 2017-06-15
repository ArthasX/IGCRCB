/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.cim.job;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.struts.ContextLoaderPlugIn;

import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * ����: �Զ��Զ����ɸ澯ʼ������
 * ������¼��������    2011/11/22
 * �޸ļ�¼��
 */
public class AutoAlarmInit extends ContextLoaderPlugIn {
	
	/** log���� */
	static Log log = LogFactory.getLog(AutoAlarmInit.class);
	
	@Override
	protected void onInit() throws ServletException {
		String AUTOALARM_JOB = "AUTOALARM_JOB"; //JOB ����
		try{
			if(JobManager.isJobAdded(AUTOALARM_JOB)){
				JobManager.removeJob(AUTOALARM_JOB);
				//"0 0 6 * * ?"ÿ�������6��ִ��
			JobManager.addJob(AUTOALARM_JOB,new AutoAlarmRun(), "0 0 6 * * ?");
				//JobManager.addJob("10",AUTOALARM_JOB,"10", new AutoAlarmRun(),new ArrayList<String>(),new HashMap<String, String>());
			}else{
				JobManager.addJob(AUTOALARM_JOB,new AutoAlarmRun(), "0 0 6 * * ?");
				//JobManager.addJob("10",AUTOALARM_JOB,"10", new AutoAlarmRun(),new ArrayList<String>(),new HashMap<String, String>());
			}
		}catch(Exception e){
			log.debug(e);
		}
	}
}
