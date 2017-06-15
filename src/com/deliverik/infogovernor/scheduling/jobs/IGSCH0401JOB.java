/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_�¼��ල����ִ����
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
	
	//���ڼ�¼�����Ķ��ŵ��¼�
	private static Map<String,String> notifyMap = new HashMap<String,String>();
	private static Map<String,String> reportMap = new HashMap<String,String>();
	private static Map<String,String> resolveMap = new HashMap<String,String>();
	
	/**
	 * ���
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("========�¼��ල����ʼ========");
		String errormsg = "�¼���ع����޷�������";
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
		//�ٴ�����ʱ��
		String[] notifyTime = null;
		//�����ϼ�ʱ��
		String[] reportTime = null;
		//Ԥ�ƽ��ʱ��
		String[] resolveTime = null;
		//�¼������̶�
		String[] urgency = null;
		//�¼������ɫid
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
			//�Ƿ������Ԥ�ƽ��ʱ��
			if(prInfo.getPrduration()!=null && !"".equals(prInfo.getPrduration())){
				flag = true;
			}
			//��ȡʱ���
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
								sendMessageToManager(managerRoleId,prInfo.getPrserialnum() + "���¼�����ʱ������ϵ�����Ա");
							}
						}else{
							if(getBetweenTimeNumber(prInfo.getPpinittime(),datetime)> getBetweenTimeNumber(prInfo.getPropentime(),prInfo.getPrduration())){
								if(resolveMap.containsKey(key)&&resolveMap.get(key).equals(ppbacktime)){
									
								}else{
									resolveMap.put(key, ppbacktime);
									sendMessageToManager(managerRoleId,prInfo.getPrserialnum() + "���¼�����ʱ������ϵ�����Ա");
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
		log.debug("========�¼��ල�������========");
	}

	/**
	 * �Ƚ�ʱ��
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	private static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		long timeNumber = 0;
		// 1Сʱ=60����=3600��=3600000
		long mins = 60L * 1000L;
		// long time= 24L * 60L * 60L * 1000L;��������֮��
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = df.parse(timeA);
		Date d2 = df.parse(timeB);
		timeNumber = (d2.getTime() - d1.getTime()) / mins;
		return (int) timeNumber;
	}

	/**
	 * ������
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
	 * ���û�������
	 * 
	 * @param userid
	 * @param message
	 * @throws Exception
	 */
	private void sendMessageToUser(String userid,String message){
		sendMessageBL.sendSmsToUser(userid, message);
	}

	/**
	 * ����ɫֵ���ֻ�������
	 * 
	 * @param roleid
	 * @param message
	 * @throws Exception
	 */
	private void sendMessageToRole(Integer roleid,String message){
		sendMessageBL.sendSmsToRole(roleid, message);
	}
	
	/**
	 * ���¼������ֻ�������
	 * 
	 * @param managerRoleId
	 * @param message
	 * @throws Exception
	 */
	private void sendMessageToManager(String managerRoleId, String message){
		sendMessageBL.sendSmsToRole(Integer.parseInt(managerRoleId), message);
	}
}