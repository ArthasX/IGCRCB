/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 调度任务通知JOB
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class InformJob implements Job{
	
	/** 日志对象 */
	private static Log log = LogFactory.getLog(RiskCheckJob.class);
	
	/** 执行BL */
	IGDWP01BL ctlBL = (IGDWP01BL) WebApplicationSupport.getBean("igdwp01BL");

	/**
	 * 执行JOB
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		TriggerKey key = context.getTrigger().getKey();
		log.info("from DayWorkPlanInformJob triggerName = " + key.getName());
		//取得任务ID
		Integer id = Integer.valueOf(String.valueOf(context.getJobDetail().getJobDataMap().get("id")));
		//实例化dto
		IGDWP01DTO dto = new IGDWP01DTO();
		dto.setId(id);
		try {
			//调用BL执行
			ctlBL.execute(dto);
		} catch (BLException e) {
			throw new JobExecutionException(e);
		}
	}

}
