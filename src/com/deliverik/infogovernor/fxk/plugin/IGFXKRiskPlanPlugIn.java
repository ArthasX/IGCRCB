/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.plugin;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.dev.crc.igflow.event.status.job.IGFXKRiskPlanJOB;

/**
 * 概述: QUARTZ风险计划发起指派工作
 * 功能描述: QUARTZ风险计划发起指派工作
 * 创建记录: 2014/07/26
 * 修改记录:
 */
public class IGFXKRiskPlanPlugIn implements PlugIn  {

    private static Log log = LogFactory.getLog(IGFXKRiskPlanPlugIn.class);
    
	/**
	 * QUARTZ风险计划发起指派工作
	 */
    public void init(ActionServlet arg0, ModuleConfig arg1)throws ServletException {
    	try{    	
    		
			//判断是否已添加过该job
			if(!JobManager.isJobAdded(IGFXKRiskPlanJOB.JOB_NAME,IGFXKRiskPlanJOB.GROUP_NAME)){
				JobManager.addJob(IGFXKRiskPlanJOB.JOB_NAME,IGFXKRiskPlanJOB.GROUP_NAME,IGFXKRiskPlanJOB.TRIGGER_NAME,IGFXKRiskPlanJOB.TRIGGERGROUP_NAME, new IGFXKRiskPlanJOB(), IGFXKRiskPlanJOB.RISKPLAN_CRON_EXPRESSION);
			}else{
				JobManager.removeJob(IGFXKRiskPlanJOB.JOB_NAME,IGFXKRiskPlanJOB.GROUP_NAME,IGFXKRiskPlanJOB.TRIGGER_NAME,IGFXKRiskPlanJOB.TRIGGERGROUP_NAME);
				JobManager.addJob(IGFXKRiskPlanJOB.JOB_NAME,IGFXKRiskPlanJOB.GROUP_NAME,IGFXKRiskPlanJOB.TRIGGER_NAME,IGFXKRiskPlanJOB.TRIGGERGROUP_NAME, new IGFXKRiskPlanJOB(), IGFXKRiskPlanJOB.RISKPLAN_CRON_EXPRESSION);
			}
		}catch(Exception e){
			log.debug(e);
		}
    }
	
	public void destroy() {
		
	}
}
