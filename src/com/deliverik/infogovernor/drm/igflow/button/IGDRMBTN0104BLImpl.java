/**
 * 
 */
package com.deliverik.infogovernor.drm.igflow.button;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG561BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.infogovernor.drm.bl.task.CurrentNodeBL;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.google.gson.Gson;

/**
 * @author Administrator
 *
 */
public class IGDRMBTN0104BLImpl extends BaseBLImpl implements
WorkFlowStatusButtonHandlerBL{

	static Log log = LogFactory.getLog(IGDRMBTN0104BLImpl.class);
	/**������־*/
	protected EmergencyLogBL emergencyLogBL;
	/**��־��Ϣ*/
	protected IG036BL ig036BL;
	 /**��Ϣ����BL*/
	protected MessagePushBL messagePushBL;
	/**��ǰ�ڵ�BL*/
	private CurrentNodeBL currentNodeBL;
	/**  
	 * ����ig036BL  
	 * @param ig036BL
	 */
	
	public void setIg036BL(IG036BL ig036bl) {
		ig036BL = ig036bl;
	}
	/**
	 * @param emergencyLogBL the emergencyLogBL to set
	 */
	public void setEmergencyLogBL(EmergencyLogBL emergencyLogBL) {
		this.emergencyLogBL = emergencyLogBL;
	}
	
	/**
	 * @param ��Ϣ����BL the messagePushBL to set
	 */
	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}
	/**  
	 * ����currentNodeBL  
	 * @param currentNodeBL
	 */
	
	public void setCurrentNodeBL(CurrentNodeBL currentNodeBL) {
		this.currentNodeBL = currentNodeBL;
	}
   
	/**
	 * ������水ť�洢��־������������
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("===============������水ť����ʼ==============");
		Gson gson = new Gson();
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		Integer prid = bean.getLogInfo().getPrid();
		String curPsdid = bean.getBfstatus();
		IG036SearchCondImpl ig036Cond = new IG036SearchCondImpl();
		ig036Cond.setPrid(prid);
		ig036Cond.setPsdid(curPsdid);
		ig036Cond.setRlType("0");
		log.debug("===============��ѯ��־��ʼ==============");
		List<IG036Info> ig036List = ig036BL.searchIG036InfoByCond(ig036Cond);
		log.debug("===============��ѯ��־����==============");
		if(ig036List != null && ig036List.size()>0){
			List<Map<String,Object>> stepMesasgeList = new ArrayList<Map<String,Object>>();
			IG036Info ig036Info = ig036List.get(ig036List.size()-1);
				//�½���־��Ϣ
			EmergencyLogTB elTB = new EmergencyLogTB();
			elTB.setElprid(prid);
			elTB.setEllitype("1");
			elTB.setEllidtime(ig036Info.getRltime());
			elTB.setEluserid(ig036Info.getRluserid());
			elTB.setElusername(ig036Info.getRlusername());
			log.debug("===============��ѯ״̬����ֵ��ʼ==============");
			// ����
			IG561BL ig561BL = (IG561BL) WebApplicationSupport
					.getBean("ig561BL");
			IG561SearchCondImpl ig561Cond = new IG561SearchCondImpl();
			ig561Cond.setPrid_q(prid.toString());
			ig561Cond.setPsdid_l(ig036Info.getPsdid());
			ig561Cond.setPidid_l(curPsdid.substring(0, curPsdid.length() - 3)
					+ "002");
			List<IG561Info> ig561InfoList = ig561BL.searchIG561(ig561Cond);
			// ���ҵ�����˵����Ϣ
			if (ig561InfoList != null && ig561InfoList.size() > 0) {
				elTB.setElliinfo(ig561InfoList.get(0).getPivarvalue());
			}
			elTB.setElpsdid(ig036Info.getPsdid());
			elTB.setElpsdname(ig036Info.getPsname());
			elTB.setOperate(ig036Info.getRldesc());
			emergencyLogBL.registEmergencyLog(elTB);
			log.debug("===============��ѯ״̬����ֵ����==============");
			Map<String, Object> stepMsgEntityMap = new HashMap<String, Object>();
			stepMsgEntityMap.put("psdid", ig036Info.getPsdid());
			stepMsgEntityMap.put("dealTime",
					ig036Info.getRltime().split(" ")[1]);
			stepMsgEntityMap.put("dealPeople", ig036Info.getRlusername());
			stepMsgEntityMap.put("logMsg",
					elTB.getElliinfo().replaceAll("<br>", ""));
			stepMsgEntityMap.put("operate", ig036Info.getRldesc());
			stepMesasgeList.add(stepMsgEntityMap);
			jsonMap.put("type", "stepMessage");
			jsonMap.put("stepMessageList", stepMesasgeList);
			messagePushBL.pushMessage(prid.toString(), gson.toJson(jsonMap));
			
			//��������Ļ����Ϣ��Ϣ
			jsonMap = new HashMap<String,Object>();
			jsonMap = getLogMessage(prid,curPsdid);
			jsonMap.put("type", "logMessage");
			messagePushBL.pushMessage(prid.toString(),gson.toJson(jsonMap));
			
			log.debug("===============������水ť�������==============");
		}
	}

	/**
	 * ��ȡ���̵Ĵ�����־
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public Map<String, Object> getLogMessage(Integer prid,String psdid) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> messageMap = new HashMap<String, Object>();
		List<Map<String, Object>> messageList = new ArrayList<Map<String,Object>>();
		//��ѯ������־
		EmergencyLogSearchCondImpl elsCond = new EmergencyLogSearchCondImpl();
		elsCond.setElprid_eq(prid.toString());
		String[] psdidArr = {psdid};
		elsCond.setPsdid_in(psdidArr);
		List<EmergencyLogInfo> emergencyLogList = emergencyLogBL.searchEmergencyLogByCond(elsCond);
		
		if(emergencyLogList!=null &&emergencyLogList.size()>0){
			EmergencyLogInfo emergencyLogInfo = emergencyLogList.get(emergencyLogList.size()-1);
				//����ʱ��
				messageMap.put("time", emergencyLogInfo.getEllidtime().split(" ")[1]);
				//������־
				messageMap.put("logMsg", emergencyLogInfo.getElliinfo().replaceAll("<br>", ""));
				//������
				messageMap.put("peopleHandle", emergencyLogInfo.getElusername());
				//�ڵ�����
				messageMap.put("nodeName", emergencyLogInfo.getElpsdname());
				//Ԥ��ʱ��
				Map<String, Object> nowNode = currentNodeBL.searchAllNodes(prid, emergencyLogInfo.getElpsdid()).get(0);
				String expectUseTime =  nowNode.get("expectusetime").toString().replace(" ", "");
				//��ȡ�ڵ�
				Map<String, Object> currentNode = currentNodeBL.searchAllNodes(prid, emergencyLogInfo.getElpsdid()).get(0);
				Date factStartTime = (Date)currentNode.get("factstarttime");
				Date factStopTime = new Date();
				if(currentNode.get("factstoptime")!=null){
					factStopTime = (Date)currentNode.get("factstoptime");
				}else{
					String ellidTime = emergencyLogInfo.getEllidtime();
					factStopTime = new Date(ellidTime);
				}
				//ʵ�ʲ�����ʱ��
				String factUseTime = computeFactUseTime(factStartTime,factStopTime);
				Double overPlusTime = Double.parseDouble(expectUseTime)-Double.parseDouble(factUseTime)/60;
				String overPlusTimeStr = String.format("%.2f", overPlusTime);
				messageMap.put("timeRemaining", ""+overPlusTimeStr);
				messageList.add(messageMap);
		}
		map.put("messageList", messageList);
		return map;
	}
	
	/**
	 * ����ʵ��ʹ��ʱ��
	 * 
	 * @param factStartTime
	 * @param factOverTime
	 * @return
	 */
	private static String computeFactUseTime(Date factStartTime,
			Date factOverTime) {
		Long factUseTime = (factOverTime.getTime() - factStartTime.getTime())/1000;
			return factUseTime.toString();
	}
}
