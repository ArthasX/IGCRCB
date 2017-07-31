/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.plugin.workItem.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.wim.bl.IGWIM01BL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;

/**
 * 
 * @Description ���ɹ���ʵ������
 *
 * @date 2017��6��16��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkItemJob implements Job{
	
	private static Log log = LogFactory.getLog(WorkItemJob.class);
	
	public static final String JOB_NAME = "WORKITEM_JOB";
	
	public static final String JOB_EXPRESSION = "0 0/1 * * * ?";	//�� �� ʱ �� �� ��;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("<<<<<<<<<<�����ʱ��������Job��ʼ>>>>>>>>>>");
		
		TriggerKey key = context.getTrigger().getKey();
    	log.info("from WorkItemCheckJob triggerName = " + key.getName());
    	
		//��ȡ�����������ID
		String wdid = String.valueOf(context.getJobDetail().getJobDataMap().get("wdid"));
		
		//���JobDataMap
		context.getJobDetail().getJobDataMap().clear();
		
		//��ȡIGWIM01BL
		IGWIM01BL ctlBL = (IGWIM01BL) WebApplicationSupport.getBean("igwim01BL");
		
		//ʵ����IGWIM01DTO
		IGWIM01DTO dto = new IGWIM01DTO();
		
		if("null".equals(wdid))
        	return;
		
		//���湤���������ID
		dto.setWdid(Integer.parseInt(wdid));
		
		log.debug("##########�������WDID��"+wdid);
		
		try {
			// ����IGWIM01BL���ɶ�ʱ������ʵ��
			ctlBL.registerWorkInstanceAction(dto);
			
			log.info("<<<<<ÿ��һ��ʱ��ʱ��ִ�е�JOB�����������ɶ�ʱ����<����ʵ��>��<������־>���>>>>>");
			
		} catch (BLException e) {
			
			log.debug("���ɶ�ʱ����<����ʵ��>��<������־>ʧ�ܣ�"+e.getMessage());
			e.printStackTrace();
		}
		
		log.info("<<<<<<<<<<�����ʱ��������Job����>>>>>>>>>>");
	}
}
