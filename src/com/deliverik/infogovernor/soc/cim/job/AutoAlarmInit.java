/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.cim.job;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.struts.ContextLoaderPlugIn;

import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * 概述: 自动自动生成告警始化程序
 * 创建记录：李旭峙    2011/11/22
 * 修改记录：
 */
public class AutoAlarmInit extends ContextLoaderPlugIn {
	
	/** log对象 */
	static Log log = LogFactory.getLog(AutoAlarmInit.class);
	
	@Override
	protected void onInit() throws ServletException {
		String AUTOALARM_JOB = "AUTOALARM_JOB"; //JOB 名字
		try{
			if(JobManager.isJobAdded(AUTOALARM_JOB)){
				JobManager.removeJob(AUTOALARM_JOB);
				//"0 0 6 * * ?"每天的早上6点执行
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
