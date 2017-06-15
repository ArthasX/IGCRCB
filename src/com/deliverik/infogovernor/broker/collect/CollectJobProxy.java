/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.broker.collect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.scheduling.jobs.CollectJob;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;

public class CollectJobProxy {

	private String message = "SUCCESS";
	private static CollectJobProxy job;
	private static Log log = LogFactory.getLog(CollectJobProxy.class);

	public static CollectJobProxy getInstance() {

		if (null == job) {
			job = new CollectJobProxy();
		}
		return job;
	}

	private CollectJobProxy() {

	}

	/**
	 * 添加job
	 * 
	 * @param timer01Info
	 * @return
	 * @throws Exception
	 */
	public String addCollectJob(Timer01Info timer01Info) throws Exception {

		if (timer01Info == null) {
			return "timer01Info is null";
		}
		
		this.removeCollectJob(timer01Info);

		CollectBean stopCollectBean = null;
		CollectBean startCollectBean = new CollectBean();
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		startCollectBean.setUuid(timer01Info.getUuid()+ CollectUnit._ENABLE.name());
		startCollectBean.setJobType(timer01Info.getTypename());
		startCollectBean.setTimeRule(timer01Info.getStartrule());
		startCollectBean.setExecutStatus(timer01Info.getExecutstatus());
		startCollectBean.setStartTime(df.parse(timer01Info.getStarttime()));
		startCollectBean.setStatus(CollectUnit._ENABLE.name());
		startCollectBean.setPeriodtype(timer01Info.getPeriodtype());
		startCollectBean.setResourceId(timer01Info.getResourceid());
		startCollectBean.setMetricNames(timer01Info.getFingerPrint().split(","));
		
		if(timer01Info.getStoprule() != null && !"".equals(timer01Info.getStoprule())){
			stopCollectBean = new CollectBean();
			stopCollectBean.setUuid(timer01Info.getUuid()+ CollectUnit._DISABLE.name());
			stopCollectBean.setJobType(timer01Info.getTypename());
			stopCollectBean.setTimeRule(timer01Info.getStoprule());
			stopCollectBean.setExecutStatus(timer01Info.getExecutstatus());
			stopCollectBean.setStartTime(df.parse(timer01Info.getStoptime()));
			stopCollectBean.setStatus(CollectUnit._DISABLE.name());
			stopCollectBean.setPeriodtype(timer01Info.getPeriodtype());
			stopCollectBean.setResourceId(timer01Info.getResourceid());
			stopCollectBean.setMetricNames(timer01Info.getFingerPrint().split(","));
		}
		
		message = this.addCollectJob(startCollectBean);

		if ("SUCCESS".equals(message) && stopCollectBean != null) {
			message = this.addCollectJob(stopCollectBean);
		}

		if (!"SUCCESS".equals(message)) {
			this.removeCollectJob(timer01Info);
		}

		return message;
	}

	/**
	 * 添加job
	 * 
	 * @return
	 */
	public String addCollectJob(CollectBean collectBean) throws Exception {

		int i = 0;

		try {
			// 判断是否启用该功能
			if (isCollectMonitor()) {

				List<String> keyname = this.getKeyList(collectBean);
				Map<String, Object> args = this.getKeyMap(collectBean);
				JobManager.addJob(collectBean.getUuid(), collectBean
						.getJobGroupName(), collectBean.getTriggerName(),
						collectBean.getTriggerGroupName(), new CollectJob(),
						keyname, args, collectBean.getStartTime(), collectBean
								.getStopTime(), collectBean.getTimeRule());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		// periodicInspection();

		return message;
	}

	/**
	 * 修改job
	 * 
	 * @param timer01Info
	 * @return
	 * @throws Exception
	 */
	public String modifryCollectJob(Timer01Info timer01Info) throws Exception {

		return addCollectJob(timer01Info);
	}

	/**
	 * 修改job
	 * 
	 * @param collectBean
	 * @return
	 * @throws Exception
	 */
	public String modifryCollectJob(CollectBean collectBean) throws Exception {

		return addCollectJob(collectBean);
	}

	/**
	 * 删除job
	 * 
	 * @param timer01Info
	 * @throws Exception
	 */
	public void removeCollectJob(Timer01Info timer01Info) throws Exception {

		if (timer01Info == null) {
			return;
		}

		
		String triggerName = CollectUnit.TRIGGER_NAME.name() + "_";
		String jobGroupName = CollectUnit.JOB_GROUP_NAME.name() + "_";
		String triggerGroupName = CollectUnit.TRIGGER_GROUP_NAME.name() + "_";
		String enableName = timer01Info.getUuid() + CollectUnit._ENABLE.name();
		String disableName = timer01Info.getUuid()+ CollectUnit._DISABLE.name();
		
		boolean isAdd = isJobAdded(enableName, jobGroupName + enableName);
		if (isAdd) {
			JobManager.removeJob(enableName, jobGroupName + enableName,
					triggerName + enableName, triggerGroupName + enableName);
		}

		isAdd = isJobAdded(disableName, jobGroupName + disableName);
		if (isAdd) {
			JobManager.removeJob(disableName, jobGroupName + disableName,
					triggerName + disableName, triggerGroupName + disableName);
		}
	}

	/**
	 * periodic Inspection
	 * 
	 * @return
	 */
	public void periodicInspection() throws Exception {

		// if (!isJobAdded("PERIODIC_INSPECTION")) {
		// JobManager.addJob("PERIODIC_INSPECTION", new CollectJob(), "");
		// }
	}

	/**
	 * 添加job
	 * 
	 * @return
	 */
	public String addCollectJob(List<CollectBean> collectBeanList)
			throws Exception {

		for (CollectBean collectBean : collectBeanList) {

			addCollectJob(collectBean);
		}

		if (!"SUCCESS".equals(message)) {
			message = "添加" + collectBeanList.size() + "个定时任务 " + message;
			log.error(message);
		}

		return message;
	}

	/**
	 * 是否开启该功能
	 * 
	 * @return
	 */
	private boolean isCollectMonitor() {
		String status = ResourceUtility.getString("COLLECT_STATUS");
		if (status != null && "start".equals(status)) {
			return true;
		} else {
			message = "采集功能已关闭";
			return false;
		}
	}

	/**
	 * 判断是否已添加过该job
	 * 
	 * @return
	 */
	private boolean isJobAdded(String jobname, String groupname) {
		try {
			return JobManager.isJobAdded(jobname, groupname);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return true;
		}
	}

	private Map<String, Object> getKeyMap(CollectBean collectBean) {

		Map<String, Object> keyMap = new HashMap<String, Object>();

		keyMap.put(CollectUnit.UUID.name(), collectBean.getUuid());
		keyMap.put(CollectUnit.TYPE.name(), collectBean.getJobType());
		keyMap.put(CollectUnit.TIME_RULE.name(), collectBean.getTimeRule());
		keyMap.put(CollectUnit.METRIC_NAMES.name(), collectBean.getMetricNames());
		keyMap.put(CollectUnit.EXECUT_STATUS.name(), collectBean.getExecutStatus());
		keyMap.put(CollectUnit.RESOURCE_ID.name(), String.valueOf(collectBean.getResourceId()));
		keyMap.put(CollectUnit.JOB_GROUP_NAME.name(), collectBean.getJobGroupName());
		keyMap.put(CollectUnit.TRIGGER_GROUP_NAME.name(), collectBean.getTriggerGroupName());
		keyMap.put(CollectUnit.STATUS.name(), collectBean.getStatus());
		keyMap.put(CollectUnit.PERIOD_TYPE.name(), collectBean.getPeriodtype());
		keyMap.put(CollectUnit.JOB_NAME.name(), collectBean.getUuid());
		keyMap.put(CollectUnit.TRIGGER_NAME.name(), collectBean.getTriggerName());

		return keyMap;
	}

	private List<String> getKeyList(CollectBean collectBean) {

		List<String> keyname = new ArrayList<String>();
		keyname.add(CollectUnit.UUID.name());
		keyname.add(CollectUnit.TYPE.name());
		keyname.add(CollectUnit.STATUS.name());
		keyname.add(CollectUnit.TIME_RULE.name());
		keyname.add(CollectUnit.RESOURCE_ID.name());
		keyname.add(CollectUnit.METRIC_NAMES.name());
		keyname.add(CollectUnit.EXECUT_STATUS.name());
		keyname.add(CollectUnit.JOB_NAME.name());
		keyname.add(CollectUnit.TRIGGER_NAME.name());
		keyname.add(CollectUnit.JOB_GROUP_NAME.name());
		keyname.add(CollectUnit.TRIGGER_GROUP_NAME.name());
		keyname.add(CollectUnit.PERIOD_TYPE.name());
		return keyname;
	}
}
