/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 概述: 事件和变更服务效率报表
 * 创建记录：2011/11/23
 * 修改记录：
 */
public class ServeEfficiencyJob implements Job {

    private static Log log = LogFactory.getLog(ServeEfficiencyJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	log.debug("========事件和变更服务效率处理开始========");
        IGRPT02BL rpt01BL = (IGRPT02BL) WebApplicationSupport.getBean("IGRPT02BL");
        
        try {
        	rpt01BL.saveIncidentEfficiency();
        	rpt01BL.saveAlterationEfficiency();
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
		log.debug("========事件和变更服务效率处理结束========");
    }

}