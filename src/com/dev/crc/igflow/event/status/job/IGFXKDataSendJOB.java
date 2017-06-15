/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.crc.igflow.event.status.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.dev.crc.igflow.event.status.bl.IGFXKDataSendBL;
/***
 * 风险管理定时任务的工作。 
 * @time 2014/06/11
 * @author zhangqiang
 * @email zhangq@deliverik.com
 * @version 1.0
 */
public class IGFXKDataSendJOB implements Job {
	
	/** 初始化日志*/
	private static Log log = LogFactory.getLog(IGFXKDataSendJOB.class);
	
	/**定义工作流 名称*/
	public static final String JOB_NAME = "DATAFXKSEND_JOB";
	
	/**
	 * 执行入口
	 */
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		log.debug("====================风险管理定时任务开始=========================");
		/** 获取igFXKDataSendBL*/
		IGFXKDataSendBL ctlBL = (IGFXKDataSendBL) WebApplicationSupport.getBean("igFXKDataSendBL");
		/** 获取jobDataMap */
		JobDataMap jobDataMap = jobContext.getJobDetail().getJobDataMap();
		Date date=new Date();
		/**设置时间格式*/
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			/** 计划结束时间以毫米为单位*/
			long endTime = sdf.parse((String)jobDataMap.get("eTime")).getTime();
			/**在时间以毫米为单位*/
			long nowTime = sdf.parse(sdf.format(date)).getTime();
			//判断该定时任务是否过期
			if(nowTime>endTime){
					//判断此定时任务是否存在
				if(JobManager.isJobAdded(IGFXKDataSendJOB.JOB_NAME+jobDataMap.get("prid"))){
					//移除此定时任务
					JobManager.removeJob(IGFXKDataSendJOB.JOB_NAME+jobDataMap.get("prid"));
				}
			}else{
				/**调用crlBL的信息提醒发送方法*/
				ctlBL.dataSend(jobDataMap.get("bTime"),jobDataMap.get("eTime"),jobDataMap.get("title"));
			}
		} catch (Exception e) {
			log.error("",e);
		} 
		log.debug("====================风险管理定时任务结束=========================");
	}

}
