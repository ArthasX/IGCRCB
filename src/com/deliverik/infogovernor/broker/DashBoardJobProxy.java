package com.deliverik.infogovernor.broker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.scheduling.jobs.SymmetrixRealTimeDataJob;
import com.deliverik.infogovernor.soc.dbs.bl.IGDBSCONSTANTS;

public class DashBoardJobProxy {

	private static Log log = LogFactory.getLog(DashBoardJobProxy.class);
	private static DashBoardJobProxy inst = null;

	public static DashBoardJobProxy getInstance() {
		if (null == inst) {
			inst = new DashBoardJobProxy();
		}
		return inst;
	}

	private DashBoardJobProxy() {}

	/**
	 * �Ƿ����ù���
	 * 
	 * @return
	 */
	private boolean isDashBoardMonitor() {
		if("1".equals(IGDBSCONSTANTS.DBM_STATUS)){
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
	private boolean isJobAdded(String jobname,String groupName) {
		try{
			return JobManager.isJobAddedForDashBoard(jobname,groupName);
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
	public void addDashBoardRTJob() {
		try {
			//�ж��Ƿ����øù���
			if(isDashBoardMonitor()) {
				//�ж��Ƿ�����ӹ���job
				if(!isJobAdded(SymmetrixRealTimeDataJob.JOB_NAME, SymmetrixRealTimeDataJob.JOB_GROUP_NAME)){
					//��ȡ������Ϣ
//					String confPath = "C:\\DashBoardRT\\config.properties";// �����ļ�
//					InputStream ins = new BufferedInputStream(new FileInputStream(new File(confPath)));
//					Properties pros = new Properties();
//					pros.load(ins);
//					String cronExpression =  pros.getProperty("CronExpression");//"0 */1 * * * ?";//�� �� ʱ �� �� ��
					
					String cronExpression = "0 */1 * * * ?";//�� �� ʱ �� �� ��
					JobManager.addJob(SymmetrixRealTimeDataJob.JOB_NAME, SymmetrixRealTimeDataJob.JOB_GROUP_NAME,
							SymmetrixRealTimeDataJob.TRIGGER_NAME, SymmetrixRealTimeDataJob.TRIGGER_GROUP_NAME, new SymmetrixRealTimeDataJob(),
							cronExpression);
				}
			}else{
				//���ܹر�ʱ��Ҫͬʱɾ���������е�job
				JobManager.removeJob(SymmetrixRealTimeDataJob.JOB_NAME, SymmetrixRealTimeDataJob.JOB_GROUP_NAME,
						SymmetrixRealTimeDataJob.TRIGGER_NAME, SymmetrixRealTimeDataJob.TRIGGER_GROUP_NAME);
			}
		} catch (Exception e) {
			log.error("-----DashBoardRT Exception-----");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

}