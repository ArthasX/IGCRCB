package com.deliverik.infogovernor.scheduling.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH02DTO;

public class PersonTimerJob implements Job {

    private static Log log = LogFactory.getLog(PersonTimerJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	TriggerKey key = context.getTrigger().getKey();
        String triggerName =  key.getName();
        log.info("from PersonTimerJob triggerName = " + triggerName);
        
        IGSCH02BL sch02BL = (IGSCH02BL) WebApplicationSupport.getBean("IGSCH02BL");
        IGSCH02DTO dto = new IGSCH02DTO();
        dto.setTriggerName(triggerName);
        try {
			sch02BL.initByWorkType(dto,null);
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
    }

}