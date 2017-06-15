/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ���չ���ʱ����Ĺ����� 
 * @time 2014/06/11
 * @author zhangqiang
 * @email zhangq@deliverik.com
 * @version 1.0
 */
public class IGFXKDataSendJOB implements Job {
	
	/** ��ʼ����־*/
	private static Log log = LogFactory.getLog(IGFXKDataSendJOB.class);
	
	/**���幤���� ����*/
	public static final String JOB_NAME = "DATAFXKSEND_JOB";
	
	/**
	 * ִ�����
	 */
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		log.debug("====================���չ���ʱ����ʼ=========================");
		/** ��ȡigFXKDataSendBL*/
		IGFXKDataSendBL ctlBL = (IGFXKDataSendBL) WebApplicationSupport.getBean("igFXKDataSendBL");
		/** ��ȡjobDataMap */
		JobDataMap jobDataMap = jobContext.getJobDetail().getJobDataMap();
		Date date=new Date();
		/**����ʱ���ʽ*/
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			/** �ƻ�����ʱ���Ժ���Ϊ��λ*/
			long endTime = sdf.parse((String)jobDataMap.get("eTime")).getTime();
			/**��ʱ���Ժ���Ϊ��λ*/
			long nowTime = sdf.parse(sdf.format(date)).getTime();
			//�жϸö�ʱ�����Ƿ����
			if(nowTime>endTime){
					//�жϴ˶�ʱ�����Ƿ����
				if(JobManager.isJobAdded(IGFXKDataSendJOB.JOB_NAME+jobDataMap.get("prid"))){
					//�Ƴ��˶�ʱ����
					JobManager.removeJob(IGFXKDataSendJOB.JOB_NAME+jobDataMap.get("prid"));
				}
			}else{
				/**����crlBL����Ϣ���ѷ��ͷ���*/
				ctlBL.dataSend(jobDataMap.get("bTime"),jobDataMap.get("eTime"),jobDataMap.get("title"));
			}
		} catch (Exception e) {
			log.error("",e);
		} 
		log.debug("====================���չ���ʱ�������=========================");
	}

}
