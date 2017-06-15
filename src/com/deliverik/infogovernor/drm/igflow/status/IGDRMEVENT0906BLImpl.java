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
import com.deliverik.framework.igflow.resultset.ProcessFormLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.google.gson.Gson;

public class IGDRMEVENT0906BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {

    static Log log = LogFactory.getLog(IGDRMEVENT0906BLImpl.class);
	
	/**��Ϣ����BL*/
	protected MessagePushBL messagePushBL;
	
	/**����API*/
	protected FlowSearchBL flowSearchBL;

	/**������־*/
	protected EmergencyLogBL emergencyLogBL;
	
	protected IG333BL ig333BL;
	
	
	public void setEmergencyLogBL(EmergencyLogBL emergencyLogBL) {
		this.emergencyLogBL = emergencyLogBL;
	}

	/**
	 * ��Ϣ����BL
	 * @param MessagePushBL messagePushBL
	 */
	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
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
	
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		Gson gson = new Gson();
		
		Integer prid = bean.getLogInfo().getPrid();
		//�¼��ϱ�����Ϣ����
		messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getEmergencyProcessInfo(prid)));
		messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getRelPlanProcessInfo(prid)));
		messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getProcessStatusListInit(prid)));
		if("0138601006".equals(bean.getBfstatus())){
			messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getSocMap(prid)));
		}
		//****���ʹ����¼��־
		List<ProcessLogInfo> prLogList = flowSearchBL.searchProcesslog(prid, bean.getBfstatus(), 
				bean.getPsdnum(),bean.getLogInfo().getExecutorid());
		String noticeTime = "";
		String noticeContnt = "";
		String noticeUser = "";
		String noticeId = "";
		String noticeUserid = "";
		String elPsdid = bean.getBfstatus();
		IG333Info ig333Bean = ig333BL.searchIG333InfoByKey(elPsdid);
		String elPsdName = ig333Bean.getPsdname();
		
		if(prLogList!=null&&prLogList.size()>0){
			ProcessLogInfo plBean = prLogList.get(prLogList.size()-1);
			//********�շ������̣����⴦��
			if (bean.getBfstatus().endsWith("001")) {
				noticeTime = plBean.getCommittime();
				noticeUser = plBean.getUsername();
				noticeUserid = plBean.getUserid();
				noticeContnt = ""+noticeTime.split(" ")[1]+"�ѽӵ��¼��ϱ���������Ϣ���£�\n\n";
				noticeId = String.valueOf(plBean.getPlid());
				//���ͱ���Ϣ
				List<ProcessFormLogInfo> pfList =  flowSearchBL.searchProcessFormlog(prid, bean.getBfstatus(),
						bean.getPsdnum(),bean.getLogInfo().getExecutorid());
				if(pfList!=null&&pfList.size()>0){
					for(ProcessFormLogInfo pfBean:pfList){
						if(pfBean.getValue()==null||"".equals(pfBean.getValue().trim())||"N/A".equals(pfBean.getValue().trim())){
							continue;
						}
						if(pfBean.getName().contains("������������PRID")){
							continue;
						}
						noticeContnt+=pfBean.getName()+"��"+pfBean.getValue()+"\n";
					}
					if(!"".equals(noticeContnt.trim())){

						noticeContnt = noticeContnt.replace("<br>","");
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
					}
				}
				
				ProcessStatusInfo psInfo = flowSearchBL.searchProcessStatus(bean.getAfstatus());
				String ppString = "Ӧ�����̽���"+psInfo.getPsdname()+"״̬ ";
				EmergencyLogTB elTB = new EmergencyLogTB();
				elTB.setEllidtime(noticeTime);
				elTB.setElliinfo(ppString);
				elTB.setEllitype("1");
				elTB.setElprid(prid);
				elTB.setEluserid("sys");
				elTB.setElusername("sys");
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
				mapInList.put("noticeContnt", ppString.replace("<br>", "").replace("&nbsp;", " ").trim());//��Ϣ��������
				list.add(mapInList);
				map.put("data", list);
				map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
				messagePushBL.pushMessage(prid+"", gson.toJson(map));
			}else{
				noticeTime = plBean.getCommittime();
				noticeUser = plBean.getUsername();
				noticeUserid = plBean.getUserid();
				noticeId = String.valueOf(plBean.getPlid());
				
				ProcessStatusInfo psInfo = flowSearchBL.searchProcessStatus(bean.getAfstatus());
				EmergencyLogTB elTB;

				//���ʹ����¼
				noticeContnt = plBean.getRecord();
				if(noticeContnt!=null&&!"".equals((noticeContnt.replaceAll("&nbsp;","").trim()))){
					noticeContnt = noticeContnt.replace("<br>","");
					elTB = new EmergencyLogTB();
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
				}
				//���ͱ���Ϣ
				List<ProcessFormLogInfo> pfList =  flowSearchBL.searchProcessFormlog(prid, bean.getBfstatus(),
						bean.getPsdnum(),bean.getLogInfo().getExecutorid());
				noticeContnt = "";
				if(pfList!=null&&pfList.size()>0){
					for(ProcessFormLogInfo pfBean:pfList){
						if(pfBean.getValue()==null||"".equals(pfBean.getValue().trim())||"N/A".equals(pfBean.getValue().trim())){
							continue;
						}
						if(pfBean.getName().contains("������������PRID")){
							continue;
						}
						noticeContnt+=pfBean.getName()+"��"+pfBean.getValue()+"\n";
					}
					if(!"".equals(noticeContnt.trim())){
						noticeContnt = noticeContnt.replace("<br>","");
						elTB = new EmergencyLogTB();
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
					}
				}
				
				String ppString = "Ӧ�����̽���"+psInfo.getPsdname()+"״̬ ";
				elTB = new EmergencyLogTB();
				elTB.setEllidtime(noticeTime);
				elTB.setElliinfo(ppString);
				elTB.setEllitype("1");
				elTB.setElprid(prid);
				elTB.setEluserid("sys");
				elTB.setElusername("sys");
				elTB.setElpsdid(elPsdid);
				elTB.setElpsdname(elPsdName);
				emergencyLogBL.registEmergencyLog(elTB);
				
				//JSON������ϢMap����
				Map<String, Object> map = new HashMap<String, Object>();
				List<Map<String, String>> list = new LinkedList<Map<String, String>>();
				Map<String, String> mapInList = new LinkedHashMap<String, String>();
				mapInList.put("noticeId", noticeId);//��Ϣ����ID
				mapInList.put("noticeUser", "sys");//��Ϣ������
				mapInList.put("noticeTime", noticeTime.split(" ")[1]);//��Ϣ����ʱ��
				mapInList.put("noticeType", "1");//��Ϣ��������
				mapInList.put("noticeContnt", ppString.replace("<br>", "").replace("&nbsp;", " ").trim());//��Ϣ��������
				list.add(mapInList);
				map.put("data", list);
				map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
				messagePushBL.pushMessage(prid+"", gson.toJson(map));
			}
		}
	}
}
