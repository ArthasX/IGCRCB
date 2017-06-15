package com.deliverik.infogovernor.scheduling.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dbm.bl.IGDBM13BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;

public class CheckEveryWorkManagerJob implements Job {

    private static Log log = LogFactory.getLog(CheckEveryWorkManagerJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	TriggerKey key = context.getTrigger().getKey();
    	log.info("from CheckEveryWorkManagerJob triggerName = " + key.getName());
        context.getJobDetail().getJobDataMap().clear();
        IGDBM13BL igdbm13BL = (IGDBM13BL) WebApplicationSupport.getBean("igdbm13BL");
        try {
        	igdbm13BL.searchDealWorkmanagerInfos(null);
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
    }
}