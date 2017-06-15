/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.scheduling.jobs;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.framework.utility.ResourceUtility;

/**
 * 概述: 流程状态提醒及上报处理类始化程序
 * 功能描述：添加流程状态提醒及上报监控任务到Quartz中
 * 创建记录：
 * 修改记录：
 */
public class IGProcessNoticeStrategyJOBInit implements PlugIn {
	
	static Log log = LogFactory.getLog(IGProcessNoticeStrategyJOBInit.class);
	
	public void init(ActionServlet actionservlet, ModuleConfig moduleconfig)
			throws ServletException {
		String IGProcessNoticeStrategyJOB_SWITCH = ResourceUtility.getString("IGProcessNoticeStrategyJOB_SWITCH");//是否启用轮巡功能
		String IGPROCESSNOTIEC_JOB = "IGPROCESSNOTIEC_JOB"; //JOB 名字
		String IGProcessNoticeStrategyJOB_TIME = ResourceUtility.getString("IGProcessNoticeStrategyJOB_TIME"); //轮巡时间
		try{
			//如果不启用监控功能，则删除原有的JOB
			if("0".equals(IGProcessNoticeStrategyJOB_SWITCH)){
				if(JobManager.isJobAdded(IGPROCESSNOTIEC_JOB)){
					JobManager.removeJob(IGPROCESSNOTIEC_JOB);
				}
				return;
			}else{//如果启用监控功能,则重新添加JOB
				if(JobManager.isJobAdded(IGPROCESSNOTIEC_JOB)){
					JobManager.removeJob(IGPROCESSNOTIEC_JOB);
					JobManager.addJob(IGPROCESSNOTIEC_JOB,new IGProcessNoticeStrategyJOB(), IGProcessNoticeStrategyJOB_TIME);
				}else{
					JobManager.addJob(IGPROCESSNOTIEC_JOB,new IGProcessNoticeStrategyJOB(), IGProcessNoticeStrategyJOB_TIME);
					log.debug("========流程状态提醒及上报监程序开启========");
				}
			}
		}catch(Exception e){
			log.error("流程状态提醒及上报监控始化程序异常：", e);
		}
		
	}
	
	public void destroy() {
		
	}
}
