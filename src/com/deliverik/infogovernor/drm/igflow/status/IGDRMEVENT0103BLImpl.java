package com.deliverik.infogovernor.drm.igflow.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValue;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG561BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.CurrentNodeBL;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.google.gson.Gson;

public class IGDRMEVENT0103BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {

    static Log log = LogFactory.getLog(IGDRMEVENT0103BLImpl.class);
	
    /**��Ϣ����BL*/
	protected MessagePushBL messagePushBL;
	
	/**����API*/
	protected FlowSearchBL flowSearchBL;

	/**������־*/
	protected EmergencyLogBL emergencyLogBL;
	
	/**���̽ڵ�*/
	protected IG333BL ig333BL;
	
	/**��־��Ϣ*/
	protected IG036BL ig036BL;
	
	/**��ǰ�ڵ�BL*/
	private CurrentNodeBL currentNodeBL;
	
	private FlowSetBL flowSetBL;

	protected IG599BL ig599BL;

	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**  
	 * ����currentNodeBL  
	 * @param currentNodeBL
	 */
	
	public void setCurrentNodeBL(CurrentNodeBL currentNodeBL) {
		this.currentNodeBL = currentNodeBL;
	}

	/**
	 * @param ��Ϣ����BL the messagePushBL to set
	 */
	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}

	/**
	 * @param ����API the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**  
	 * ����ig036BL  
	 * @param ig036BL
	 */
	
	public void setIg036BL(IG036BL ig036bl) {
		ig036BL = ig036bl;
	}

	/**
	 * @param ������־ the emergencyLogBL to set
	 */
	public void setEmergencyLogBL(EmergencyLogBL emergencyLogBL) {
		this.emergencyLogBL = emergencyLogBL;
	}

	/**
	 * @param ig333bl the ���̽ڵ� to set
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		Gson gson = new Gson();
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		Integer prid = bean.getLogInfo().getPrid();
		//��ȡ��ǰ�ڵ�
		String curPsdid = bean.getBfstatus();
		//�ж��Ƿ�Ϊ������ڵ�
		if(!curPsdid.substring(curPsdid.length()-3,curPsdid.length()).equals("001")){
			//��ȡ��������Ϣ
			IG036SearchCondImpl ig036Cond = new IG036SearchCondImpl();
			ig036Cond.setPrid(prid);
			ig036Cond.setPsdid(curPsdid);
			ig036Cond.setRlType("2");
			List<IG036Info> ig036List = ig036BL.searchIG036InfoByCond(ig036Cond);
			if(ig036List != null && ig036List.size()>0){
				List<Map<String, Object>> stepMesasgeList = new ArrayList<Map<String, Object>>();
				IG036Info ig036Info = ig036List.get(ig036List.size() - 1);
				// �½���־��Ϣ
				EmergencyLogTB elTB = new EmergencyLogTB();
				elTB.setElprid(prid);
				elTB.setEllitype("1");
				elTB.setEllidtime(ig036Info.getRltime());
				elTB.setEluserid(ig036Info.getRluserid());
				elTB.setElusername(ig036Info.getRlusername());
				// ����
				IG561BL ig561BL = (IG561BL) WebApplicationSupport
						.getBean("ig561BL");
				IG561SearchCondImpl ig561Cond = new IG561SearchCondImpl();
				ig561Cond.setPrid_q(prid.toString());
				ig561Cond.setPsdid_l(ig036Info.getPsdid());
				ig561Cond.setPidid_l(ig036Info.getPsdid().substring(0,
						ig036Info.getPsdid().length() - 3)
						+ "002");
				List<IG561Info> ig561InfoList = ig561BL.searchIG561(ig561Cond);
				if (ig561InfoList != null && ig561InfoList.size() > 0) {
					elTB.setElliinfo(ig561InfoList.get(0).getPivarvalue());
				}
				elTB.setElpsdid(ig036Info.getPsdid());
				elTB.setElpsdname(ig036Info.getPsname());
				elTB.setOperate(ig036Info.getRldesc());
				emergencyLogBL.registEmergencyLog(elTB);
				Map<String, Object> stepMsgEntityMap = new HashMap<String, Object>();
				stepMsgEntityMap.put("psdid", ig036Info.getPsdid());
				stepMsgEntityMap.put("dealTime",
						ig036Info.getRltime().split(" ")[1]);
				stepMsgEntityMap.put("dealPeople", ig036Info.getRlusername());
				stepMsgEntityMap.put("logMsg",
 elTB.getElliinfo() == null ? "" : elTB.getElliinfo().replaceAll("<br>", ""));
				stepMsgEntityMap.put("operate", ig036Info.getRldesc());
				stepMesasgeList.add(stepMsgEntityMap);
				jsonMap.put("type", "stepMessage");
				jsonMap.put("stepMessageList", stepMesasgeList);
				messagePushBL
						.pushMessage(prid.toString(), gson.toJson(jsonMap));
			}
			
			//��������Ļ����Ϣ��Ϣ
			jsonMap = new HashMap<String,Object>();
			jsonMap = getLogMessage(prid,curPsdid);
			jsonMap.put("type", "logMessage");
			messagePushBL.pushMessage(prid.toString(),gson.toJson(jsonMap));
			//���ͽڵ�ԾǨ
			jsonMap = new HashMap<String,Object>();
			Map<String,Object> 	stepJumpMap = new HashMap<String, Object>();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			List<Map<String, Object>> searchCurNodeList = currentNodeBL.searchAllNodes(prid, curPsdid);
			//��ʼ�ڵ�
			Map<String, Object> searchStartNode = currentNodeBL.searchAllNodes(prid, curPsdid.substring(0,curPsdid.length()-3)+"001").get(0);
			// ���̵Ŀ�ʼʱ��
			Date flowStartTime = (Date) searchStartNode.get("expectstarttime");
			List<Map<String, Object>> stepJumpList = new ArrayList<Map<String,Object>>();
			if(searchCurNodeList!=null && searchCurNodeList.size()>0){
				Map<String, Object> curNode = searchCurNodeList.get(0);
				stepJumpMap.put("psdid",curPsdid);
				stepJumpMap.put("stepType","finish");
				stepJumpMap.put("factStartTime",format.format((Date) curNode.get("factstarttime")));
				// �ڵ�ʵ��ִ��ʱ���ʶ
				String factUseTime = getFactUseTime(computeFactUseTime((Date) curNode.get("factstarttime"),(Date) curNode.get("factstoptime")));
				stepJumpMap.put("factUseTime",factUseTime);
				// �ڵ�ʵ��ִ��ʱ���ʶ
				stepJumpMap.put("factStartSign",Double.parseDouble(computeFactUseTime(flowStartTime,(Date) curNode.get("factstarttime")))/60);
				stepJumpList.add(stepJumpMap);
			}
			jsonMap.put("stepList", stepJumpList);
			jsonMap.put("type", "stepJump");
			messagePushBL.pushMessage(prid.toString(),gson.toJson(jsonMap));
			
			
		}
	}
/**
 * ǰ����
 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		Gson gson = new Gson();
		Integer prid = bean.getLogInfo().getPrid();
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		//��ǰ�ڵ�id
		String afPsdid = bean.getAfstatus();
		// ����ǹرսڵ�
		if(afPsdid.substring(afPsdid.length()-3, afPsdid.length()).equals("002")){
			jsonMap.put("sign", "0");
			jsonMap.put("type", "usedTime");
			messagePushBL.pushMessage(prid.toString(),gson.toJson(jsonMap));
			//����ʱ��
			jsonMap = new HashMap<String,Object>();
			jsonMap.put("sign", "1");
			jsonMap.put("type", "overTime");
			Date date = new Date();	
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String stopTime = format.format(date);
			jsonMap.put("time", stopTime);
			messagePushBL.pushMessage(prid.toString(),gson.toJson(jsonMap));
			// �������������������Ƿ���ɱ�*******************************
			IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
			ig599Cond.setPivarvalue(prid.toString());
			ig599Cond.setPivarname("�����������prid");
			List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
			// ����ܲ�ѯ��˵����ͨ������ֱ�ӷ���ļ����ָ�������������� �����Ƿ���ɱ� ,���³����ʲ�"�Ƿ�����"����
			if(ig599List!=null && ig599List.size()>0){

				// �ж��Ƿ�����������>Ӧ��ָ��>�����ָ�����
				Integer ig599Prid = ig599List.get(0).getPrid();
				ig599Cond = new IG599SearchCondImpl();
				ig599Cond.setPrid(ig599Prid);
				ig599Cond.setPivarname(IGDRMCONSTANTS.DRILL_FROM_NAME_DIRECT_PRID);
				List<IG599Info> ig599Arr = ig599BL.searchIG599InfosByCond(ig599Cond);
				// ������������е�Ӧ��ָ������prid ��ֵ ����Ҫ�ٴ����������̺ͳ����ʲ�(ָ�����̺���ᴦ��)
				if (ig599Arr != null && ig599Arr.size() > 0 && StringUtils.isNotEmpty(ig599Arr.get(0).getPivarvalue())) {
					return;
				}

				ig599Cond.setPivarname("����ָ���Ƿ����");
				List<IG599Info> ig599List1 = ig599BL.searchIG599InfosByCond(ig599Cond);
				if(ig599List1!=null && ig599List1.size()>0){
					IG599Info ig599Info = ig599List1.get(0);
					IG599TB ig599TB = (IG599TB) SerializationUtils.clone(ig599Info);
					ig599TB.setPivarvalue("���");
					ig599BL.updateIG599Info(ig599TB);
				}

				// ���³����ʲ��е���"��������"����***********************
				List<ProcessInfoEntityInfo> eiidList = this.flowSearchBL.searchProcessEntityItem(ig599Prid, IGDRMCONSTANTS.EMERGENCY_SCENE_NAME);
				if (eiidList != null && eiidList.size() > 0) {
					Integer eiid = eiidList.get(0).getEiid();
					// ���³����ʲ����ԡ��Ƿ���������
					List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
					// soc0107->
					EntityItemConfigValue entityConfig = null;
					entityConfig = new EntityItemConfigValue();
					entityConfig.setEiid(eiid);
					entityConfig.setName(IGDRMCONSTANTS.DRILL_FINISED_FORM_NAME);
					entityConfig.setValue("��");
					configItems.add(entityConfig);
					// false- >update ������
					flowSetBL.setEntityItemConfigValue(configItems, false);
				}
			}

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
			// ����ʱ��
			messageMap.put("time",
					emergencyLogInfo.getEllidtime().split(" ")[1]);
			// ������־
			messageMap.put("logMsg", emergencyLogInfo.getElliinfo() == null ? "" : emergencyLogInfo.getElliinfo().replaceAll("<br>", ""));
			// ������
			messageMap.put("peopleHandle", emergencyLogInfo.getElusername());
			// �ڵ�����
			messageMap.put("nodeName", emergencyLogInfo.getElpsdname());
			// Ԥ��ʱ��
			Map<String, Object> nowNode = currentNodeBL.searchAllNodes(prid,
					emergencyLogInfo.getElpsdid()).get(0);
			String expectUseTime = nowNode.get("expectusetime").toString()
					.replace(" ", "");
			// ��ȡ�ڵ�
			Map<String, Object> currentNode = currentNodeBL.searchAllNodes(
					prid, emergencyLogInfo.getElpsdid()).get(0);
			Date factStartTime = (Date) currentNode.get("factstarttime");
			Date factStopTime = (Date) currentNode.get("factstoptime");
			// ʵ�ʲ�����ʱ��
			String factUseTime = computeFactUseTime(factStartTime, factStopTime);
			Double overPlusTime = Double.parseDouble(expectUseTime)
					- Double.parseDouble(factUseTime) / 60;
			String overPlusTimeStr = String.format("%.2f", overPlusTime);
			messageMap.put("timeRemaining", "" + overPlusTimeStr);
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
	
	/**
	 * �������̵�ʹ��ʱ��
	 * 
	 * @param expectStartSign
	 * @return
	 */
	private static String getFactUseTime(String expectUseTimeSign) {
		String second = "" + Integer.parseInt(expectUseTimeSign) % 60;
		String minute = "" + Integer.parseInt(expectUseTimeSign) / 60;
		String hour = "" + Integer.parseInt(expectUseTimeSign) / 3600; 
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		if(second.length() == 1){
			second = "0" + second;
		}	
		return hour + ":" + minute + ":" + second;
		
	}
}
