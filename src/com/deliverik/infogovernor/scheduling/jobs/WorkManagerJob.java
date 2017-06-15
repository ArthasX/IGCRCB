package com.deliverik.infogovernor.scheduling.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.dbm.bl.IGDBM13BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;

public class WorkManagerJob implements Job {

    private static Log log = LogFactory.getLog(WorkManagerJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	TriggerKey key = context.getTrigger().getKey();
    	log.info("from WorkManagerJob triggerName = " + key.getName());
        String wmid = String.valueOf(context.getJobDetail().getJobDataMap().get("wmid"));
        context.getJobDetail().getJobDataMap().clear();
		
        IGDBM13BL igdbm13BL = (IGDBM13BL) WebApplicationSupport.getBean("igdbm13BL");
        IGDBM13DTO dto = new IGDBM13DTO();
        dto.setWmid(Integer.valueOf(wmid));
        try {
        	igdbm13BL.copyWorkmanagerInfo(dto);
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
    }
}