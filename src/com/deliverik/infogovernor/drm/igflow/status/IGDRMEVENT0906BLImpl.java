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
	
	/**消息推送BL*/
	protected MessagePushBL messagePushBL;
	
	/**流程API*/
	protected FlowSearchBL flowSearchBL;

	/**推送日志*/
	protected EmergencyLogBL emergencyLogBL;
	
	protected IG333BL ig333BL;
	
	
	public void setEmergencyLogBL(EmergencyLogBL emergencyLogBL) {
		this.emergencyLogBL = emergencyLogBL;
	}

	/**
	 * 消息推送BL
	 * @param MessagePushBL messagePushBL
	 */
	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}
	
	/**
	 * 流程API
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
		//事件上报人信息推送
		messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getEmergencyProcessInfo(prid)));
		messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getRelPlanProcessInfo(prid)));
		messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getProcessStatusListInit(prid)));
		if("0138601006".equals(bean.getBfstatus())){
			messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getSocMap(prid)));
		}
		//****推送处理记录日志
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
			//********刚发起流程，特殊处理
			if (bean.getBfstatus().endsWith("001")) {
				noticeTime = plBean.getCommittime();
				noticeUser = plBean.getUsername();
				noticeUserid = plBean.getUserid();
				noticeContnt = ""+noticeTime.split(" ")[1]+"已接到事件上报，具体信息如下：\n\n";
				noticeId = String.valueOf(plBean.getPlid());
				//推送表单信息
				List<ProcessFormLogInfo> pfList =  flowSearchBL.searchProcessFormlog(prid, bean.getBfstatus(),
						bean.getPsdnum(),bean.getLogInfo().getExecutorid());
				if(pfList!=null&&pfList.size()>0){
					for(ProcessFormLogInfo pfBean:pfList){
						if(pfBean.getValue()==null||"".equals(pfBean.getValue().trim())||"N/A".equals(pfBean.getValue().trim())){
							continue;
						}
						if(pfBean.getName().contains("演练方案流程PRID")){
							continue;
						}
						noticeContnt+=pfBean.getName()+"："+pfBean.getValue()+"\n";
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
						//JSON传递信息Map设置
						Map<String, Object> map = new HashMap<String, Object>();
						List<Map<String, String>> list = new LinkedList<Map<String, String>>();
						Map<String, String> mapInList = new LinkedHashMap<String, String>();
						mapInList.put("noticeId", noticeId);//信息发布ID
						mapInList.put("noticeUser", noticeUser);//信息发布人
						mapInList.put("noticeTime", noticeTime.split(" ")[1]);//信息发布时间
						mapInList.put("noticeType", "1");//信息发布类型
						mapInList.put("noticeContnt", noticeContnt.replace("<br>", "").replace("&nbsp;", " ").trim());//信息发布内容
						list.add(mapInList);
						map.put("data", list);
						map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
						messagePushBL.pushMessage(prid+"", gson.toJson(map));
					}
				}
				
				ProcessStatusInfo psInfo = flowSearchBL.searchProcessStatus(bean.getAfstatus());
				String ppString = "应急流程进入"+psInfo.getPsdname()+"状态 ";
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
				//JSON传递信息Map设置
				Map<String, Object> map = new HashMap<String, Object>();
				List<Map<String, String>> list = new LinkedList<Map<String, String>>();
				Map<String, String> mapInList = new LinkedHashMap<String, String>();
				mapInList.put("noticeId", noticeId);//信息发布ID
				mapInList.put("noticeUser", noticeUser);//信息发布人
				mapInList.put("noticeTime", noticeTime.split(" ")[1]);//信息发布时间
				mapInList.put("noticeType", "1");//信息发布类型
				mapInList.put("noticeContnt", ppString.replace("<br>", "").replace("&nbsp;", " ").trim());//信息发布内容
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

				//推送处理记录
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
					
					//JSON传递信息Map设置
					Map<String, Object> map = new HashMap<String, Object>();
					List<Map<String, String>> list = new LinkedList<Map<String, String>>();
					Map<String, String> mapInList = new LinkedHashMap<String, String>();
					mapInList.put("noticeId", noticeId);//信息发布ID
					mapInList.put("noticeUser", noticeUser);//信息发布人
					mapInList.put("noticeTime", noticeTime.split(" ")[1]);//信息发布时间
					mapInList.put("noticeType", "1");//信息发布类型
					mapInList.put("noticeContnt", noticeContnt.replace("<br>", "").replace("&nbsp;", " ").trim());//信息发布内容
					list.add(mapInList);
					map.put("data", list);
					map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
					messagePushBL.pushMessage(prid+"", gson.toJson(map));
				}
				//推送表单信息
				List<ProcessFormLogInfo> pfList =  flowSearchBL.searchProcessFormlog(prid, bean.getBfstatus(),
						bean.getPsdnum(),bean.getLogInfo().getExecutorid());
				noticeContnt = "";
				if(pfList!=null&&pfList.size()>0){
					for(ProcessFormLogInfo pfBean:pfList){
						if(pfBean.getValue()==null||"".equals(pfBean.getValue().trim())||"N/A".equals(pfBean.getValue().trim())){
							continue;
						}
						if(pfBean.getName().contains("演练方案流程PRID")){
							continue;
						}
						noticeContnt+=pfBean.getName()+"："+pfBean.getValue()+"\n";
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
						
						//JSON传递信息Map设置
						Map<String, Object> map = new HashMap<String, Object>();
						List<Map<String, String>> list = new LinkedList<Map<String, String>>();
						Map<String, String> mapInList = new LinkedHashMap<String, String>();
						mapInList.put("noticeId", noticeId);//信息发布ID
						mapInList.put("noticeUser", noticeUser);//信息发布人
						mapInList.put("noticeTime", noticeTime.split(" ")[1]);//信息发布时间
						mapInList.put("noticeType", "1");//信息发布类型
						mapInList.put("noticeContnt", noticeContnt.replace("<br>", "").replace("&nbsp;", " ").trim());//信息发布内容
						list.add(mapInList);
						map.put("data", list);
						map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
						messagePushBL.pushMessage(prid+"", gson.toJson(map));
					}
				}
				
				String ppString = "应急流程进入"+psInfo.getPsdname()+"状态 ";
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
				
				//JSON传递信息Map设置
				Map<String, Object> map = new HashMap<String, Object>();
				List<Map<String, String>> list = new LinkedList<Map<String, String>>();
				Map<String, String> mapInList = new LinkedHashMap<String, String>();
				mapInList.put("noticeId", noticeId);//信息发布ID
				mapInList.put("noticeUser", "sys");//信息发布人
				mapInList.put("noticeTime", noticeTime.split(" ")[1]);//信息发布时间
				mapInList.put("noticeType", "1");//信息发布类型
				mapInList.put("noticeContnt", ppString.replace("<br>", "").replace("&nbsp;", " ").trim());//信息发布内容
				list.add(mapInList);
				map.put("data", list);
				map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
				messagePushBL.pushMessage(prid+"", gson.toJson(map));
			}
		}
	}
}
