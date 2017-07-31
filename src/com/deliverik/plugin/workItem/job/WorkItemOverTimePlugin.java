/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.plugin.workItem.job;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * 
 * @Description 
 *
 * @date 2017年6月16日
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkItemOverTimePlugin implements PlugIn{
	
	private static final Log log = LogFactory.getLog(WorkItemOverTimePlugin.class);

	/**
	 * 销毁
	 */
	public void destroy() {
		
	}

	/**
	 * 初始化
	 */
	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		try{
			log.debug("============开始============");
			if(JobManager.isJobAdded(WorkItemOverTimeJob.JOB_NAME)){
				JobManager.removeJob(WorkItemOverTimeJob.JOB_NAME);
				JobManager.addJob(WorkItemOverTimeJob.JOB_NAME, new WorkItemOverTimeJob(), WorkItemOverTimeJob.JOB_EXPRESSION);
			}else{
				JobManager.addJob(WorkItemOverTimeJob.JOB_NAME, new WorkItemOverTimeJob(), WorkItemOverTimeJob.JOB_EXPRESSION);
			}
			log.debug("============结束============");
		}catch(Exception e){
			log.error("",e);
			throw new ServletException(e);
		}
	}

}
