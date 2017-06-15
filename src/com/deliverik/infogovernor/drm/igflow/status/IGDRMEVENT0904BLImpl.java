/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValue;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.google.gson.Gson;

/**
 * Ӧ��ָ������-�رսڵ� ǰ����
 * 
 * �ж������������������������̹ر�ʱ���������̱�������ָ���Ƿ���ɡ���ֵ
 * ���˱�ֵ��Ϊ�գ��������̲���ԾǨ���رսڵ�İ�ť
 * 
 * @author zyl
 *
 * 2015��3��19��11:22:49
 */
public class IGDRMEVENT0904BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0904BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
    private FlowSetBL flowSetBL;
    
	/**
	 * flowSetBL   �趨
	 * @param flowSetBL flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
    }
	
	/**
	 * �������������б�������ָ���Ƿ���ɡ�,��������״̬���Ƿ�����������Ϊ���ǡ�
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		//********�������̵�ǰ״̬**********
		Gson gson = new Gson();
		MessagePushBL messagePushBL = (MessagePushBL) WebApplicationSupport.getBean("messagePushBL");
		
		
		EmergencyLogBL emergencyLogBL = (EmergencyLogBL) WebApplicationSupport.getBean("emergencyLogBL");
		IG224BL ig224BL = (IG224BL) WebApplicationSupport.getBean("ig224BL");
		List<Map<String,String>> psdList = new ArrayList<Map<String,String>>(); 

		Integer prid = bean.getLogInfo().getPrid();
//		String opentime = "";
		String usetime = "00:00:00";
		//ǰ�ڵ�psdid
		String bfPsdid = bean.getBfstatus();
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		ig224cond.setPsdid(bfPsdid);
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		cond.setPrstatus("C");
		List<IG224Info> ig224CloseInfoList = ig224BL.findByCondOrderByRslopentime(cond);
		if(ig224CloseInfoList!=null&&ig224CloseInfoList.size()>0){
			
		IG224Info ig224info = ig224CloseInfoList.get(0);
		messagePushBL.pushMessage(prid+"",gson.toJson(IGDRMEmergencyTools.getProcessStatusListInit(prid)));
		//ֹͣʹ��ʱ��
		Map<String,Object> useTimeMap = new HashMap<String, Object>();
		useTimeMap.put("type", "23");
		messagePushBL.pushMessage(prid+"",gson.toJson(useTimeMap));
//		----------------------------------------
		EmergencyLogTB elTB = new EmergencyLogTB();
		
		elTB.setEllidtime(datetime);
		elTB.setElliinfo("�����ѹر�");
		elTB.setEllitype("1");	
		elTB.setElprid(prid);
		elTB.setEluserid("sys");
		elTB.setElusername("sys");
		elTB.setElpsdid(ig224info.getPsdid());
		elTB.setElpsdname("�ر�");
		EmergencyLogInfo emInfo = emergencyLogBL.registEmergencyLog(elTB);
		//JSON������ϢMap����
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		Map<String, String> mapInList = new LinkedHashMap<String, String>();
		mapInList.put("noticeId", emInfo.getElid().toString());//��Ϣ����ID
		mapInList.put("noticeUser", "sys");//��Ϣ������
		mapInList.put("noticeTime", datetime.split(" ")[1]);//��Ϣ����ʱ��
		mapInList.put("noticeType", "1");//��Ϣ��������
		mapInList.put("noticeContnt", "�����ѹر�");//��Ϣ��������
		list.add(mapInList);
		map1.put("data", list);
		map1.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		messagePushBL.pushMessage(prid+"", gson.toJson(map1));
		}
		// ��ȡ��������Ϣ
    	ProcessRecordInfo prInfo = this.flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null).get(0);
		// ��ȡӦ����������id
		String drillPrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.PRACTISE_PRID_LABEL);
		if (StringUtils.isNotEmpty(drillPrid)) {
			// ��ȡӦ����������ʵ��
			List<ProcessRecordInfo> prList = flowSearchBL.searchProcessInfo(Integer.parseInt(drillPrid), null);
			if (prList.size() > 0) {

				// �������������е� <ָ������prid>��ֵΪ�����̵�prid
				WorkFlowLog wfg = new WorkFlowLog();
				wfg.setPrid(Integer.parseInt(drillPrid));
				wfg.setExecutorid(bean.getCrtuserid());
				PublicProcessInfoValue ppiv = new PublicProcessInfoValue(wfg);
				ppiv.setFormname(IGDRMCONSTANTS.DRILL_PROCESS_FORM_NAME_DIRECTSTATUS);
				ppiv.setFormvalue("���");
				flowSetBL.setPublicProcessInfoValue(ppiv);
			}

			// ********************���³����ʲ�����**************************
			// ��ѯ�����ʲ�
			List<ProcessInfoEntityInfo> eiidList = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.SCENE_ITEM_NAME);
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
		
		log.debug("========����Ԥ�ƻָ�ʱ�����==========");
		IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		//�ж�prurgency�Ƿ�Ϊ0����Ϊ0��Ϊ��������
		if("0".equals(ig500Info.getPrurgency())){
			//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
			IGDRMEmergencyTools.changeSystemState(prid, "ҵ��ϵͳ", "0",null);
		}
		
	}
}
