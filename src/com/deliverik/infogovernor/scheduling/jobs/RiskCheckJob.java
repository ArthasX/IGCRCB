package com.deliverik.infogovernor.scheduling.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;

public class RiskCheckJob implements Job {

    private static Log log = LogFactory.getLog(RiskCheckJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	TriggerKey key = context.getTrigger().getKey();
    	log.info("from RiskCheckJob triggerName = " + key.getName());
        String csid = String.valueOf(context.getJobDetail().getJobDataMap().get("csid"));
        context.getJobDetail().getJobDataMap().clear();
		
        IGRIS02BL ris02BL = (IGRIS02BL) WebApplicationSupport.getBean("igris02BL");
        IGRIS02DTO dto = new IGRIS02DTO();
        
        if("null".equals(csid))
        	return;
        
        
        dto.setCsid(Integer.valueOf(csid));
        try {
        	ris02BL.initRiskCheckResult(dto);
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
    }

}
