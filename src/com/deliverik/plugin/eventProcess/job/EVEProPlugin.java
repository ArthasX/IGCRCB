package com.deliverik.plugin.eventProcess.job;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.infogovernor.scheduling.jobs.JobManager;

public class EVEProPlugin implements PlugIn {
	
	private static final Log log = LogFactory.getLog(EVEProPlugin.class);

	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {
		try{
			log.debug("============添加事件数据同步job开始============");
			if(JobManager.isJobAdded(EVEProJob.JOB_NAME)){
				JobManager.removeJob(EVEProJob.JOB_NAME);
				JobManager.addJob(EVEProJob.JOB_NAME, new EVEProJob(), EVEProJob.JOB_EXPRESSION);
			}else{
				JobManager.addJob(EVEProJob.JOB_NAME, new EVEProJob(), EVEProJob.JOB_EXPRESSION);
			}
			log.debug("============添加事件数据同步job开始============");
		}catch(Exception e){
			log.error("",e);
			throw new ServletException(e);
		}
	}
	
	public void destroy() {
		
	}
	
}
