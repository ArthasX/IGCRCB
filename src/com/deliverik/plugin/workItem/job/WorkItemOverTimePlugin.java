/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @date 2017��6��16��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkItemOverTimePlugin implements PlugIn{
	
	private static final Log log = LogFactory.getLog(WorkItemOverTimePlugin.class);

	/**
	 * ����
	 */
	public void destroy() {
		
	}

	/**
	 * ��ʼ��
	 */
	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		try{
			log.debug("============��ʼ============");
			if(JobManager.isJobAdded(WorkItemOverTimeJob.JOB_NAME)){
				JobManager.removeJob(WorkItemOverTimeJob.JOB_NAME);
				JobManager.addJob(WorkItemOverTimeJob.JOB_NAME, new WorkItemOverTimeJob(), WorkItemOverTimeJob.JOB_EXPRESSION);
			}else{
				JobManager.addJob(WorkItemOverTimeJob.JOB_NAME, new WorkItemOverTimeJob(), WorkItemOverTimeJob.JOB_EXPRESSION);
			}
			log.debug("============����============");
		}catch(Exception e){
			log.error("",e);
			throw new ServletException(e);
		}
	}

}
