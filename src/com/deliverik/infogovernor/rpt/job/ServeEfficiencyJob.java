/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.rpt.bl.IGRPT02BL;

/**
 * ����: �¼��ͱ������Ч�ʱ���
 * ������¼��2011/11/23
 * �޸ļ�¼��
 */
public class ServeEfficiencyJob implements Job {

    private static Log log = LogFactory.getLog(ServeEfficiencyJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	log.debug("========�¼��ͱ������Ч�ʴ���ʼ========");
        IGRPT02BL rpt01BL = (IGRPT02BL) WebApplicationSupport.getBean("IGRPT02BL");
        
        try {
        	rpt01BL.saveIncidentEfficiency();
        	rpt01BL.saveAlterationEfficiency();
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
		log.debug("========�¼��ͱ������Ч�ʴ������========");
    }

}