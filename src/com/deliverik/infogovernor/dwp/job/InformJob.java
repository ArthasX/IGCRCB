/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.dwp.bl.IGDWP01BL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;
import com.deliverik.infogovernor.scheduling.jobs.RiskCheckJob;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������֪ͨJOB
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class InformJob implements Job{
	
	/** ��־���� */
	private static Log log = LogFactory.getLog(RiskCheckJob.class);
	
	/** ִ��BL */
	IGDWP01BL ctlBL = (IGDWP01BL) WebApplicationSupport.getBean("igdwp01BL");

	/**
	 * ִ��JOB
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		TriggerKey key = context.getTrigger().getKey();
		log.info("from DayWorkPlanInformJob triggerName = " + key.getName());
		//ȡ������ID
		Integer id = Integer.valueOf(String.valueOf(context.getJobDetail().getJobDataMap().get("id")));
		//ʵ����dto
		IGDWP01DTO dto = new IGDWP01DTO();
		dto.setId(id);
		try {
			//����BLִ��
			ctlBL.execute(dto);
		} catch (BLException e) {
			throw new JobExecutionException(e);
		}
	}

}
