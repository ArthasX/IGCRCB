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
	 * 是否开启该功能
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
	 * 判断是否已添加过该job
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
	 * 添加job
	 * 
	 * @return
	 */
	public void addDashBoardRTJob() {
		try {
			//判断是否启用该功能
			if(isDashBoardMonitor()) {
				//判断是否已添加过该job
				if(!isJobAdded(SymmetrixRealTimeDataJob.JOB_NAME, SymmetrixRealTimeDataJob.JOB_GROUP_NAME)){
					//获取配置信息
//					String confPath = "C:\\DashBoardRT\\config.properties";// 配置文件
//					InputStream ins = new BufferedInputStream(new FileInputStream(new File(confPath)));
//					Properties pros = new Properties();
//					pros.load(ins);
//					String cronExpression =  pros.getProperty("CronExpression");//"0 */1 * * * ?";//秒 分 时 日 月 周
					
					String cronExpression = "0 */1 * * * ?";//秒 分 时 日 月 周
					JobManager.addJob(SymmetrixRealTimeDataJob.JOB_NAME, SymmetrixRealTimeDataJob.JOB_GROUP_NAME,
							SymmetrixRealTimeDataJob.TRIGGER_NAME, SymmetrixRealTimeDataJob.TRIGGER_GROUP_NAME, new SymmetrixRealTimeDataJob(),
							cronExpression);
				}
			}else{
				//功能关闭时需要同时删除触发器中的job
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