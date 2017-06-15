package com.deliverik.infogovernor.scheduling.jobs;

import java.util.List;

import main.java.com.dlk.hq.Server;
import main.java.com.dlk.hq.XmlTemplate;
import main.java.com.dlk.hq.XmlTemplateImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperic.hq.hqapi1.HQApi;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM13BL;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM13BLImpl;
import com.deliverik.infogovernor.util.HQUtil;

public class CollectTimerJob implements Job{
	
	
	private HQApi hqapi;
	private HQUtil hqUtil;
	private IGCIM13BL IGCIM13BLImpl;
	private static Log log = LogFactory.getLog(CollectTimerJob.class);
	
	public CollectTimerJob() {
		IGCIM13BLImpl = (IGCIM13BLImpl) WebApplicationSupport
				.getBean("igcim13BL");
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		try {

			List<Server> serverList = getServerList();
			List<CicollecttaskInfo> ciList = IGCIM13BLImpl.findAllByCollectType("0");
			
			if(ciList == null || ciList.size() == 0 && serverList != null){
				for(Server server : serverList){
					String enableName = server.getUuid()+"_ENABLE";
					String disableName = server.getUuid()+"_DISABLE";
					if(JobManager.isJobAdded(enableName)) JobManager.removeJob(enableName);
					if(JobManager.isJobAdded(disableName)) JobManager.removeJob(disableName);
				}
			}else if(serverList == null || serverList.size() == 0 && ciList != null){
				for(CicollecttaskInfo cicollecttaskInfo : ciList){
					String enableName = cicollecttaskInfo.getUuid()+"_ENABLE";
					String disableName = cicollecttaskInfo.getUuid()+"_DISABLE";
					if(JobManager.isJobAdded(enableName)) JobManager.removeJob(enableName);
					if(JobManager.isJobAdded(disableName))JobManager.removeJob(disableName);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected List<Server> getServerList()throws Exception{

		List<Server> servers = null;
		XmlTemplate template = new XmlTemplateImpl();
		try {
			servers = template.getServerListByTemplatePath(
					ResourceUtility.getString("CI_COLLECT_TYPE_PATH"));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ªÒ»°XmlTemplate ß∞‹");
			throw new Exception();
		}
		return servers;
	}

}
