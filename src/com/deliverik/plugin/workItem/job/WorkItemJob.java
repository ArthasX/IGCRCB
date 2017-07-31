/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * @Description 生成工作实例任务
 *
 * @date 2017年6月16日
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkItemJob implements Job{
	
	private static Log log = LogFactory.getLog(WorkItemJob.class);
	
	public static final String JOB_NAME = "WORKITEM_JOB";
	
	public static final String JOB_EXPRESSION = "0 0/1 * * * ?";	//秒 分 时 日 月 周;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("<<<<<<<<<<工作项定时任务生成Job开始>>>>>>>>>>");
		
		TriggerKey key = context.getTrigger().getKey();
    	log.info("from WorkItemCheckJob triggerName = " + key.getName());
    	
		//获取工作项定义主键ID
		String wdid = String.valueOf(context.getJobDetail().getJobDataMap().get("wdid"));
		
		//清空JobDataMap
		context.getJobDetail().getJobDataMap().clear();
		
		//获取IGWIM01BL
		IGWIM01BL ctlBL = (IGWIM01BL) WebApplicationSupport.getBean("igwim01BL");
		
		//实例化IGWIM01DTO
		IGWIM01DTO dto = new IGWIM01DTO();
		
		if("null".equals(wdid))
        	return;
		
		//保存工作项定义主键ID
		dto.setWdid(Integer.parseInt(wdid));
		
		log.debug("##########工作项定义WDID："+wdid);
		
		try {
			// 调用IGWIM01BL生成定时任务工作实例
			ctlBL.registerWorkInstanceAction(dto);
			
			log.info("<<<<<每隔一段时间时间执行的JOB工作——生成定时任务<工作实例>和<工作日志>完成>>>>>");
			
		} catch (BLException e) {
			
			log.debug("生成定时任务<工作实例>和<工作日志>失败："+e.getMessage());
			e.printStackTrace();
		}
		
		log.info("<<<<<<<<<<工作项定时任务生成Job结束>>>>>>>>>>");
	}
}
