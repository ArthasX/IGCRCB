package com.deliverik.infogovernor.drm.igflow.status;

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
import com.deliverik.framework.igflow.resultset.ProcessLogInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.google.gson.Gson;


/**
 * Ӧ��ָ������ <Ӧ������>�ڵ�ǰ����
 * @author kenZ
 *
 */
public class IGDRMEVENT0907BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {

    static Log log = LogFactory.getLog(IGDRMEVENT0906BLImpl.class);
	
	/**��Ϣ����BL*/
	protected MessagePushBL messagePushBL;
	
	/**����API*/
	protected FlowSearchBL flowSearchBL;

	/**������־*/
	protected EmergencyLogBL emergencyLogBL;
	
	protected IG333BL ig333BL;
	
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {

	}
	
	/**
	 * ��Ϣ����BL
	 * @param MessagePushBL messagePushBL
	 */
	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}
	
	
	public void setEmergencyLogBL(EmergencyLogBL emergencyLogBL) {
		this.emergencyLogBL = emergencyLogBL;
	}

	/**
	 * ����API
	 * @param FlowSetBL flowSetBL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
	
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		Gson gson = new Gson();
		Integer prid = bean.getLogInfo().getPrid();
		Map<String, Object> pushMap = IGDRMEmergencyTools.getRelPlanProcessInfo(prid);
		messagePushBL.pushMessage(prid+"", gson.toJson(pushMap));
		
		
		//****���ʹ����¼��־
		List<ProcessLogInfo> prLogList = flowSearchBL.searchProcesslog(prid, bean.getBfstatus(), 
				bean.getPsdnum(),bean.getLogInfo().getExecutorid());
		String noticeTime = "";
		String noticeContnt = "";
		String noticeUser = "";
		String noticeId = "";
		String noticeUserid = "";
		
		if(prLogList!=null&&prLogList.size()>0){
			ProcessLogInfo plBean = prLogList.get(prLogList.size()-1);
			noticeTime = plBean.getCommittime();
			noticeContnt = "�����ָ��������ڽ�����...";
			noticeUser = plBean.getUsername();
			noticeId = String.valueOf(plBean.getPlid());
			noticeUserid = plBean.getUserid();
			String elPsdid = bean.getAfstatus();
			IG333Info ig333Bean = ig333BL.searchIG333InfoByKey(bean.getAfstatus());
			String elPsdName = ig333Bean.getPsdname();
			
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
			//JSON������ϢMap����
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, String>> list = new LinkedList<Map<String, String>>();
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			mapInList.put("noticeId", noticeId);//��Ϣ����ID
			mapInList.put("noticeUser", noticeUser);//��Ϣ������
			mapInList.put("noticeTime", noticeTime.split(" ")[1]);//��Ϣ����ʱ��
			mapInList.put("noticeType", "1");//��Ϣ��������
			mapInList.put("noticeContnt", noticeContnt.replace("<br>", "").replace("&nbsp;", " ").trim());//��Ϣ��������
			list.add(mapInList);
			map.put("data", list);
			map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
			messagePushBL.pushMessage(prid+"", gson.toJson(map));
//			String jsonString = JSONUtils.getNotisJSON(noticeTime,noticeContnt,noticeUser,noticeId,"1",prid+"",elPsdid);
//			messagePushBL.pushMessage(prid+"", jsonString);
		}
		
		log.debug("========����Ԥ�ƻָ�ʱ�����==========");
		IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		//�ж�prurgency�Ƿ�Ϊ0��Ϊ0����Ӧ������
		if("0".equals(ig500Info.getPrurgency())){
			//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
			IGDRMEmergencyTools.changeSystemState(prid, "ҵ��ϵͳ", "7",null);
		}
		
	}


}
