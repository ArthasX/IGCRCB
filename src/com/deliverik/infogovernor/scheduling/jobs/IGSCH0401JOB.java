/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCondImpl;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务策略_事件监督工作执行类
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSCH0401JOB implements Job {

	private static Log log = LogFactory.getLog(IGSCH0401JOB.class);
	
	private static SendMessageBL sendMessageBL = (SendMessageBL) WebApplicationSupport.getBean("sendMessageBL");
	
	private static IG500BL prVWBL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
	
	private static QuartzJobsBL qjBL = (QuartzJobsBL) WebApplicationSupport.getBean("quartzJobsBL");
	
	//用于记录发过的短信的事件
	private static Map<String,String> notifyMap = new HashMap<String,String>();
	private static Map<String,String> reportMap = new HashMap<String,String>();
	private static Map<String,String> resolveMap = new HashMap<String,String>();
	
	/**
	 * 入口
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("========事件监督处理开始========");
		String errormsg = "事件监控工作无法启动！";
		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setTodo(true);
		cond.setPrtype(IGPROCESSType.INCIDENT_PRTYPE);
		List<IG677Info> prInfoList = prVWBL.searchProcessRecordInfo(cond,
				0, 0);
		
		prInfoList.addAll(prVWBL.searchProcessRecordInfo(cond,
				0, 0));
		
		QuartzJobsSearchCondImpl qjcond = new QuartzJobsSearchCondImpl();
		qjcond.setQjname(JOBCONSTANTS.INCIDENT_MONITOR);
		List<QuartzJobs> qjList = qjBL.searchQuartzJobs(qjcond, 0, 0);
		if (qjList.isEmpty() || qjList.size() > 1) {
			throw new JobExecutionException(errormsg);
		}
		//再次提醒时间
		String[] notifyTime = null;
		//报告上级时间
		String[] reportTime = null;
		//预计解决时间
		String[] resolveTime = null;
		//事件紧急程度
		String[] urgency = null;
		//事件经理角色id
		String managerRoleId = "";
		for (QuartzJobs qj : qjList) {
			notifyTime = qj.getQjdesc().split("#");
			reportTime = qj.getQjtricron().split("#");
			resolveTime = qj.getQjinfo().split("#");
			urgency = qj.getQjorgname().split("#");
			managerRoleId = qj.getQjcrtuser();
		}
		if (notifyTime == null) {
			throw new JobExecutionException(errormsg);
		}
		if (reportTime == null) {
			throw new JobExecutionException(errormsg);
		}
		if (resolveTime == null) {
			throw new JobExecutionException(errormsg);
		}
		for (IG677Info prInfo : prInfoList) {
			boolean flag = false;
			//是否调整了预计解决时间
			if(prInfo.getPrduration()!=null && !"".equals(prInfo.getPrduration())){
				flag = true;
			}
			//获取时间差
			String ppbacktime = prInfo.getPpbacktime();
			String datetime = IGStringUtils.getCurrentDateTime();
			int number;
			try {
				number = getBetweenTimeNumber(ppbacktime,
						datetime);
			} catch (Exception e) {
				throw new JobExecutionException(errormsg);
			}
			String prurgency = prInfo.getPrurgency();
			for(int i=0;i<urgency.length;i++){
				if(prurgency.equals(urgency[i])){
					int notify = Integer.parseInt(notifyTime[i]);
					int report = Integer.parseInt(reportTime[i]);
					int resolve = Integer.parseInt(resolveTime[i]);
					int prid = prInfo.getPrid();
					String key = prid+"#"+prInfo.getPproleid()+"#"+prInfo.getPpuserid();
					try {
						
						if (resolve > -1 && getBetweenTimeNumber(prInfo.getPpinittime(),
								datetime)> resolve && !flag) {
							if(resolveMap.containsKey(key)&&resolveMap.get(key).equals(ppbacktime)){
								
							}else{
								resolveMap.put(key, ppbacktime);
								sendMessageToManager(managerRoleId,prInfo.getPrserialnum() + "号事件处理超时，请联系相关人员");
							}
						}else{
							if(getBetweenTimeNumber(prInfo.getPpinittime(),datetime)> getBetweenTimeNumber(prInfo.getPropentime(),prInfo.getPrduration())){
								if(resolveMap.containsKey(key)&&resolveMap.get(key).equals(ppbacktime)){
									
								}else{
									resolveMap.put(key, ppbacktime);
									sendMessageToManager(managerRoleId,prInfo.getPrserialnum() + "号事件处理超时，请联系相关人员");
								}
							}
							
						}
					} catch (Exception e) {
						throw new JobExecutionException(errormsg);
					}
					break;
				}
			}
		}
		log.debug("========事件监督处理结束========");
	}

	/**
	 * 比较时间
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	private static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		long timeNumber = 0;
		// 1小时=60分钟=3600秒=3600000
		long mins = 60L * 1000L;
		// long time= 24L * 60L * 60L * 1000L;计算天数之差
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = df.parse(timeA);
		Date d2 = df.parse(timeB);
		timeNumber = (d2.getTime() - d1.getTime()) / mins;
		return (int) timeNumber;
	}

	/**
	 * 发短信
	 * 
	 * @param roleid
	 * @param userid
	 * @param message
	 * @throws Exception
	 */
	private void sendMessage(Integer roleid, String userid, String message){
		if (StringUtils.isEmpty(userid)) {
			sendMessageToRole(roleid, message);
		} else {
			sendMessageToUser(userid, message);
		}
	}

	/**
	 * 给用户发短信
	 * 
	 * @param userid
	 * @param message
	 * @throws Exception
	 */
	private void sendMessageToUser(String userid,String message){
		sendMessageBL.sendSmsToUser(userid, message);
	}

	/**
	 * 给角色值班手机发短信
	 * 
	 * @param roleid
	 * @param message
	 * @throws Exception
	 */
	private void sendMessageToRole(Integer roleid,String message){
		sendMessageBL.sendSmsToRole(roleid, message);
	}
	
	/**
	 * 给事件经理手机发短信
	 * 
	 * @param managerRoleId
	 * @param message
	 * @throws Exception
	 */
	private void sendMessageToManager(String managerRoleId, String message){
		sendMessageBL.sendSmsToRole(Integer.parseInt(managerRoleId), message);
	}
}