/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.scheduling.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.scheduling.bl.IGSCH05BL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH05DTO;

public class UserdefinedTimerJob implements Job {

    private static Log log = LogFactory.getLog(UserdefinedTimerJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	TriggerKey key = context.getTrigger().getKey();
        String triggerName = key.getName();
        log.info("from PersonTimerJob triggerName = " + triggerName);
        IGSCH05BL sch05BL = (IGSCH05BL) WebApplicationSupport.getBean("IGSCH05BL");
        IGSCH05DTO dto = new IGSCH05DTO();
        dto.setTriggerName(triggerName);
        try {
			sch05BL.init(dto);
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
    }

}