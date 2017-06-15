/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: QUARTZ���ռƻ�����ָ�ɹ���
 * ��������: QUARTZ���ռƻ�����ָ�ɹ���
 * ������¼: 2014/07/26
 * �޸ļ�¼:
 */
public class IGFXKRiskPlanPlugIn implements PlugIn  {

    private static Log log = LogFactory.getLog(IGFXKRiskPlanPlugIn.class);
    
	/**
	 * QUARTZ���ռƻ�����ָ�ɹ���
	 */
    public void init(ActionServlet arg0, ModuleConfig arg1)throws ServletException {
    	try{    	
    		
			//�ж��Ƿ�����ӹ���job
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
