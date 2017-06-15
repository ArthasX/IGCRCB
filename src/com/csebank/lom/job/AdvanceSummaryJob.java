/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.csebank.lom.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.csebank.lom.bl.IGLOM03BL;
import com.csebank.lom.dto.IGLOM03DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 后勤管理_预支费用汇总执行类
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class AdvanceSummaryJob implements Job {
	private static Log log = LogFactory.getLog(AdvanceSummaryJob.class);

	private static IGLOM03BL iglom03BL = (IGLOM03BL) WebApplicationSupport
			.getBean("iglom03BL");
	
	/**
	 * 入口
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("========预支费用汇总处理开始========");
		
		try {
			iglom03BL.advanceSummaryJob(new IGLOM03DTO());
		} catch (BLException e) {
			log.error("预支汇总定时任务异常："+e.getMessage());
		}
		
		log.debug("========预支费用汇总处理结束========");
	}

}
