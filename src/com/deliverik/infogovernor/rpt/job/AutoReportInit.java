/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.rpt.job;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * ����: �Զ����ɾ�̬�����ʼ������
 * ������¼��������    2011/06/16
 * �޸ļ�¼��
 */
public class AutoReportInit implements PlugIn {
	
	/** log���� */
	static Log log = LogFactory.getLog(AutoReportInit.class);
	
	public void init(ActionServlet arg0, ModuleConfig arg1) throws ServletException {
		String AUTOREPORT_JOB = "AUTOREPORT_JOB1"; //JOB ����
		String SERVEEFFICIENCY_JOB="SERVEEFFICIENCY_JOB";
		try{
			if(JobManager.isJobAdded(AUTOREPORT_JOB)){
				JobManager.removeJob(AUTOREPORT_JOB);
				//"0 0 5 * * ?"ÿ�������5��ִ��
				JobManager.addJob(AUTOREPORT_JOB,new AutoReportRun(), "0 0 5 * * ?");
//				JobManager.addJob("10",AUTOREPORT_JOB,"10", new AutoReportRun(),new ArrayList<String>(),new HashMap<String, String>());
			}else{
				JobManager.addJob(AUTOREPORT_JOB,new AutoReportRun(), "0 0 5 * * ?");
//				JobManager.addJob("10",AUTOREPORT_JOB,"10", new AutoReportRun(),new ArrayList<String>(),new HashMap<String, String>());
			}
			if(JobManager.isJobAdded(SERVEEFFICIENCY_JOB)){
				JobManager.removeJob(SERVEEFFICIENCY_JOB);
				//"0 0 0 * * ?"ÿ�������0��ִ��
				JobManager.addJob(SERVEEFFICIENCY_JOB,new ServeEfficiencyJob(), "0 0 0 * * ?");
			}else{
				JobManager.addJob(SERVEEFFICIENCY_JOB,new ServeEfficiencyJob(), "0 0 0 * * ?");
			}
		}catch(Exception e){
			log.debug(e);
		}
	}

	public void destroy() {
		
	}

}
