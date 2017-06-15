package com.csebank.lom.broker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.job.InventoryJob;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;

public class InventoryJobProxy {

	private static Log log = LogFactory.getLog(InventoryJobProxy.class);
	private static InventoryJobProxy inst = null;

	public static InventoryJobProxy getInstance() {
		if (null == inst) {
			inst = new InventoryJobProxy();
		}
		return inst;
	}

	private InventoryJobProxy() {}

	/**
	 * 是否开启该功能
	 * 
	 * @return
	 */
	private boolean isStartInventory() {
		if("1".equals(IGLOMCONSTANTS.INVENTORY_STATUS)){
			return true;
		}else{
			return false;
		}

	}

	/**
	 * 判断是否已添加过该job
	 * 
	 * @return
	 */
	private boolean isJobAdded(String jobname) {
		try{
			return JobManager.isJobAdded(jobname);
		}catch(Exception e){
			e.printStackTrace();
			log.debug(e.getMessage());
			return true;
		}
		

	}
	
	/**
	 * 添加job
	 * 
	 * @return
	 */
	public void addInventoryJob() {
		try {
			//判断是否启用该功能
			if(isStartInventory()) {
				//判断是否已添加过该job
				if(!isJobAdded(InventoryJob.JOB_NAME)){
					String cronExpression = "0 30 23 L * ?";//秒 分 时 日 月 周
					JobManager.addJob(InventoryJob.JOB_NAME, new InventoryJob(), cronExpression);
				}
			}else{
				//功能关闭时需要同时删除触发器中的job
				JobManager.removeJob(InventoryJob.JOB_NAME);
			}
		} catch (Exception e) {
			log.error("-----InventoryJob Exception-----");
			log.error(e.getMessage());
		}
	}

}