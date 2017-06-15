/**
 * 
 */
package com.deliverik.infogovernor.drm.igflow.button;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessFormLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessLogInfo;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.CurrentNodeBL;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.google.gson.Gson;

/**
 * Ӧ��ָ�����̱��水ť�¼�
 * 
 * @author Administrator
 *
 */
public class IGDRMBTN0105BLImpl extends BaseBLImpl implements
WorkFlowStatusButtonHandlerBL{

	static Log log = LogFactory.getLog(IGDRMBTN0105BLImpl.class);
	/**������־*/
	protected EmergencyLogBL emergencyLogBL;
	/**��־��Ϣ*/
	protected IG036BL ig036BL;
	 /**��Ϣ����BL*/
	protected MessagePushBL messagePushBL;
	/**��ǰ�ڵ�BL*/
	private CurrentNodeBL currentNodeBL;
	private FlowSearchBL flowSearchBL;
	private IG333BL ig333BL;

	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

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

		Integer prid = bean.getLogInfo().getPrid();

		Gson gson = new Gson();
		// ****���ʹ����¼��־
		List<ProcessLogInfo> prLogList = flowSearchBL.searchProcesslog(prid, bean.getBfstatus(), bean.getPsdnum(), bean.getLogInfo().getExecutorid());
		String noticeTime = "";
		String noticeContnt = "";
		String noticeUser = "";
		String noticeId = "";
		String noticeUserid = "";
		String elPsdid = bean.getBfstatus();
		IG333Info ig333Bean = ig333BL.searchIG333InfoByKey(elPsdid);
		String elPsdName = ig333Bean.getPsdname();

		if (prLogList != null && prLogList.size() > 0) {
			ProcessLogInfo plBean = prLogList.get(prLogList.size() - 1);
			noticeTime = plBean.getCommittime();
			noticeUser = plBean.getUsername();
			noticeUserid = plBean.getUserid();
			// noticeContnt = "" + noticeTime.split(" ")[1] +
			// "�ѽӵ��¼��ϱ���������Ϣ���£�\n\n";
			noticeId = String.valueOf(plBean.getPlid());
		//���ͱ���Ϣ
			List<ProcessFormLogInfo> pfList = flowSearchBL.searchProcessFormlog(prid, bean.getBfstatus(), bean.getPsdnum(), bean.getLogInfo().getExecutorid());
			if (pfList != null && pfList.size() > 0) {
				for (ProcessFormLogInfo pfBean : pfList) {
					if (pfBean.getValue() == null || "".equals(pfBean.getValue().trim()) || "N/A".equals(pfBean.getValue().trim())) {
						continue;
					}
					if (pfBean.getName().contains("������������PRID") || pfBean.getName().contains("������")) {
						continue;
					}
					noticeContnt += pfBean.getName() + "��" + pfBean.getValue() + "\n";
				}
				if (!"".equals(noticeContnt.trim())) {

					noticeContnt = noticeContnt.replace("<br>", "");
					EmergencyLogTB elTB = new EmergencyLogTB();
					elTB.setEllidtime(noticeTime);
					elTB.setElliinfo(noticeContnt);
					elTB.setEllitype("1");
					elTB.setElprid(prid);
					elTB.setEluserid(noticeUserid);
					elTB.setElusername(noticeUser);
					elTB.setElpsdid(elPsdid);
					elTB.setElpsdname(elPsdName);
					emergencyLogBL.registEmergencyLog(elTB);
					// JSON������ϢMap����
					Map<String, Object> map = new HashMap<String, Object>();
					List<Map<String, String>> list = new LinkedList<Map<String, String>>();
					Map<String, String> mapInList = new LinkedHashMap<String, String>();
					mapInList.put("noticeId", noticeId);// ��Ϣ����ID
					mapInList.put("noticeUser", noticeUser);// ��Ϣ������
					mapInList.put("noticeTime", noticeTime.split(" ")[1]);// ��Ϣ����ʱ��
					mapInList.put("noticeType", "1");// ��Ϣ��������
					mapInList.put("noticeContnt", noticeContnt.replace("<br>", "").replace("&nbsp;", " ").trim());// ��Ϣ��������
					list.add(mapInList);
					map.put("data", list);
					map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
					messagePushBL.pushMessage(prid + "", gson.toJson(map));
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
