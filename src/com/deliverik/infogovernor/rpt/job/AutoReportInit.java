/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
 * 概述: 自动生成静态报表初始化程序
 * 创建记录：李旭峙    2011/06/16
 * 修改记录：
 */
public class AutoReportInit implements PlugIn {
	
	/** log对象 */
	static Log log = LogFactory.getLog(AutoReportInit.class);
	
	public void init(ActionServlet arg0, ModuleConfig arg1) throws ServletException {
		String AUTOREPORT_JOB = "AUTOREPORT_JOB1"; //JOB 名字
		String SERVEEFFICIENCY_JOB="SERVEEFFICIENCY_JOB";
		try{
			if(JobManager.isJobAdded(AUTOREPORT_JOB)){
				JobManager.removeJob(AUTOREPORT_JOB);
				//"0 0 5 * * ?"每天的早上5点执行
				JobManager.addJob(AUTOREPORT_JOB,new AutoReportRun(), "0 0 5 * * ?");
//				JobManager.addJob("10",AUTOREPORT_JOB,"10", new AutoReportRun(),new ArrayList<String>(),new HashMap<String, String>());
			}else{
				JobManager.addJob(AUTOREPORT_JOB,new AutoReportRun(), "0 0 5 * * ?");
//				JobManager.addJob("10",AUTOREPORT_JOB,"10", new AutoReportRun(),new ArrayList<String>(),new HashMap<String, String>());
			}
			if(JobManager.isJobAdded(SERVEEFFICIENCY_JOB)){
				JobManager.removeJob(SERVEEFFICIENCY_JOB);
				//"0 0 0 * * ?"每天的早上0点执行
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
