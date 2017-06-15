package com.deliverik.infogovernor.scheduling.jobs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.MetricApi;
import org.hyperic.hq.hqapi1.types.Metric;
import org.hyperic.hq.hqapi1.types.MetricsResponse;
import org.hyperic.hq.hqapi1.types.Resource;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;
import com.deliverik.framework.soc.asset.model.entity.Timer02TB;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.broker.collect.CollectJobProxy;
import com.deliverik.infogovernor.broker.collect.CollectUnit;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BL;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM13BL;
import com.deliverik.infogovernor.util.HQUtil;

public class CollectJob implements Job {
	
	
	private HQApi hqapi;
	private IGSCH02BL sch02BL;
	private IGCIM13BL IGCIM13BLImpl;
	private static final String yymmdd = "yyyy/MM/dd HH:mm";
	private static Log log = LogFactory.getLog(CollectJob.class);

	public CollectJob() {
		sch02BL = (IGSCH02BL) WebApplicationSupport.getBean("IGSCH02BL");
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		MetricsResponse response = null;
		String executmessage = "SUCCESS";

		Map<?, ?> map = context.getJobDetail().getJobDataMap();

		if (!validate(map)) {
			return;
		}
		
		Resource resource = null;
		Timer01TB timer01TB = null;
		CodeListUtils codeListUtils = null;
		long currentTime = System.currentTimeMillis();
		String uuid = (String)map.get(CollectUnit.UUID.name());
		String type = (String)map.get(CollectUnit.TYPE.name());
		String status = (String)map.get(CollectUnit.STATUS.name());
		String jobName = (String)map.get(CollectUnit.JOB_NAME.name());
		String periodType = (String)map.get(CollectUnit.PERIOD_TYPE.name());
		String triggerName = (String)map.get(CollectUnit.TRIGGER_NAME.name());
		String jobGroupName = (String)map.get(CollectUnit.JOB_GROUP_NAME.name());
		String executStatus = (String)map.get(CollectUnit.EXECUT_STATUS.name());
		String[] metricNames = (String[])map.get(CollectUnit.METRIC_NAMES.name());
		String triggerGroupName = (String)map.get(CollectUnit.TRIGGER_GROUP_NAME.name());
		int resourceid = Integer.parseInt((String)map.get(CollectUnit.RESOURCE_ID.name()));
		String uuids[] = uuid.split("_");
		try {

			IGCIM13BLImpl = sch02BL.getIgcim13BL();
			timer01TB = sch02BL.getTimer01(uuids[0]+"_"+uuids[1]);

			if (hqapi == null) {
				codeListUtils = sch02BL.getCodeListUtils();
				hqapi = HQUtil.getHQApi(codeListUtils);
			}

			if(timer01TB == null){
				log.warn(">> >> timer01表中没有id="+uuids[0]+"_"+uuids[1]+"的数据");
				return;
			}
			
			
			boolean isEnabled = false;
			resource = new Resource();
			resource.setId(resourceid);
			MetricApi metricApi = hqapi.getMetricApi();

			if (CollectUnit._ENABLE.name().equals(status)) {
				isEnabled = true;
				executStatus = "1";
				timer01TB.setNewstarttime(HQUtil.getTime(yymmdd, currentTime));
				response = metricApi.getMetrics(resource, false);
			} else if (CollectUnit._DISABLE.name().equals(status)){
				executStatus = "2";
				timer01TB.setNewstoptime(HQUtil.getTime(yymmdd, currentTime));
				response = metricApi.getMetrics(resource, true);
			}

			List<Metric> metricList = null;
			List<Metric> metrics = response.getMetric();
			if (metrics == null || metrics.size() == 0) {
				log.warn(">> >> hq metrics is null, response id="+resourceid);
				return;
			}

			metricList = new ArrayList<Metric>();
			for (Metric metric : metrics) {
				for (String mname : metricNames) {
					if (mname != null
							&& mname.equals(metric.getMetricTemplate()
									.getName())) {
						metric.setEnabled(isEnabled);
						metricList.add(metric);
					}
				}
			}
			metricApi.syncMetrics(metricList);
		} catch (Exception e) {
			if(e.getLocalizedMessage() != null){
				executmessage = ">> >> 操作HQ API异常 "+e.getLocalizedMessage();
			}else{
				executmessage = ">> >> 操作HQ API异常 "+e.getMessage();
			}
			e.printStackTrace();
			log.error(e);
		} finally {

			try {

				Timer02TB timer02 = null;
				if(timer01TB!=null){
					IGCIM13BLImpl.updateTimer01(timer01TB);
				}

				timer02 = new Timer02TB();
				timer02.setUuid(uuids[0]+"_"+uuids[1]);
				timer02.setTypename(type);
				timer02.setPeriodtype(periodType);
				timer02.setExecutstatus(executStatus);
				timer02.setExecutmessage(executmessage);
				timer02.setName(jobName!=null ? jobName : "");
				timer02.setExecutrule("");
				timer02.setCollectdate(HQUtil.getTime(yymmdd, currentTime));
				IGCIM13BLImpl.addTimer02(timer02);

				//仅一次
				if(periodType!=null && "1".equals(periodType)){

					boolean isAnd = JobManager.isJobAdded(jobName, jobGroupName);
					if (isAnd) {
						JobManager.removeJob(jobName, jobGroupName,
								triggerName, triggerGroupName);
					}
				}
				
				if(jobName.contains(CollectUnit._DISABLE.name())){
					
					if(timer01TB!=null){
						
						Calendar c = Calendar.getInstance();
						CollectJobProxy proxy  = CollectJobProxy.getInstance();
						DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
						Date stopDate = df.parse(timer01TB.getStoptime());

						int year = c.get(Calendar.YEAR);
						int month = c.get(Calendar.MONTH) + 1;
						int day = c.get(Calendar.DAY_OF_MONTH); 
						String calendarStr =  year+"/"+month+"/"+day; 
						Date calendarDate = df.parse(calendarStr);
						
						if( stopDate.getTime() == calendarDate.getTime()){
							timer01TB.setExecutstatus("2");
							IGCIM13BLImpl.updateTimer01(timer01TB);
							proxy.removeCollectJob(timer01TB);
						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	private boolean validate(Map<?, ?> map) {

		boolean flag = false;

		if (map == null || map.size() == 0) {
			return flag;
		} else if (!map.containsKey(CollectUnit.TYPE.name())) {
			return flag;
		} else if (!map.containsKey(CollectUnit.EXECUT_STATUS.name())) {
			return flag;
		}

		String type = (String) map.get(CollectUnit.TYPE.name());
		String executStatus = (String) map.get(CollectUnit.EXECUT_STATUS.name());

		if (type == null || "".equals(type)) {
			return flag;
		} else if (executStatus == null || "".equals(executStatus)) {
			return flag;
		}

		return true;
	}

	public void setHqapi(HQApi hqapi) {
		this.hqapi = hqapi;
	}

	public HQApi getHqapi() {
		return hqapi;
	}

}
