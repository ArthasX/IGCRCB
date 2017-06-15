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
	 * �Ƿ����ù���
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
	 * �ж��Ƿ�����ӹ���job
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
	 * ���job
	 * 
	 * @return
	 */
	public void addInventoryJob() {
		try {
			//�ж��Ƿ����øù���
			if(isStartInventory()) {
				//�ж��Ƿ�����ӹ���job
				if(!isJobAdded(InventoryJob.JOB_NAME)){
					String cronExpression = "0 30 23 L * ?";//�� �� ʱ �� �� ��
					JobManager.addJob(InventoryJob.JOB_NAME, new InventoryJob(), cronExpression);
				}
			}else{
				//���ܹر�ʱ��Ҫͬʱɾ���������е�job
				JobManager.removeJob(InventoryJob.JOB_NAME);
			}
		} catch (Exception e) {
			log.error("-----InventoryJob Exception-----");
			log.error(e.getMessage());
		}
	}

}