/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ڹ���_Ԥ֧���û���ִ����
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
	 * ���
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("========Ԥ֧���û��ܴ���ʼ========");
		
		try {
			iglom03BL.advanceSummaryJob(new IGLOM03DTO());
		} catch (BLException e) {
			log.error("Ԥ֧���ܶ�ʱ�����쳣��"+e.getMessage());
		}
		
		log.debug("========Ԥ֧���û��ܴ������========");
	}

}
