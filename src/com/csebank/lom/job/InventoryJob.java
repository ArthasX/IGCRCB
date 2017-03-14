package com.csebank.lom.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.csebank.lom.bl.IGLOM02BL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;

public class InventoryJob implements Job {

	private static Log log = LogFactory.getLog(InventoryJob.class);
	public static final String JOB_NAME = "LOM_JOB";

	public void execute(JobExecutionContext context) throws JobExecutionException {
		try{
			IGLOM02BL ctlBL = (IGLOM02BL) WebApplicationSupport.getBean("iglom02BL");
			ctlBL.insertInventoryInfoAction();
		}catch(BLException e){
			e.printStackTrace();
			log.debug(e.getMessage());
		}
		
	}
}