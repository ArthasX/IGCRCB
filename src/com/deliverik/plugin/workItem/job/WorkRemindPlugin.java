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

import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * 
 * @Description ��ʼ�����/�Ƴ�����ʵ������Job��
 *
 * @date 2017��6��22��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkRemindPlugin implements PlugIn{
	
	private static final Log log = LogFactory.getLog(WorkRemindPlugin.class);
	
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
			
			//ȡ��CodeDetailBL
			CodeDetailBL ctlBL = (CodeDetailBL) WebApplicationSupport.getBean("codeDetailBL");
			
			//У�鹤����������ѿ��ش��ڿ���״̬�·��ɽ������ѹ���ʵ��
			CodeDetailTBPK ofPk = new CodeDetailTBPK();
			ofPk.setCcid("177");
			ofPk.setCid("6");
			//ȡ�ö��ſ��ػ�������
			CodeDetail ofCodeDetal = ctlBL.searchCodeDetailByPK(ofPk);
			
			//��ȡcodedetial�ж�������ʱ�䣬ƴ�ӱ��ʽ
			CodeDetailTBPK timePk = new CodeDetailTBPK();
			timePk.setCcid("178");
			timePk.setCid("1");
			//ȡ�ö�������ʱ�䣨Сʱ����������
			CodeDetail timeCodeDetal = ctlBL.searchCodeDetailByPK(timePk);
			//������ʽ
			String expression = "0 0 "+Integer.parseInt(timeCodeDetal.getCvalue())+" * * ?";
			
			if("1".equals(ofCodeDetal.getCvalue())){
				//У�鹤����������ѿ��ش��ڿ���״̬�´���Job����
				if(JobManager.isJobAdded(WorkRemindJob.JOB_NAME)){
					
					JobManager.removeJob(WorkRemindJob.JOB_NAME);
					JobManager.addJob(WorkRemindJob.JOB_NAME, new WorkRemindJob(), expression);
				}else{
					
					JobManager.addJob(WorkRemindJob.JOB_NAME, new WorkRemindJob(), expression);
				}
			}
			
			
			log.debug("============����============");
		}catch(Exception e){
			log.error("",e);
			throw new ServletException(e);
		}
	}

}
