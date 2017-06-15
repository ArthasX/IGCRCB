/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 应急指挥流程-关闭节点 前处理
 * 
 * 判断如果是演练发起的流程在流程关闭时给演练流程表单“演练指挥是否完成”赋值
 * 当此表单值不为空，演练流程才有跃迁到关闭节点的按钮
 * 
 * @author zyl
 *
 * 2015年3月19日11:22:49
 */
public class IGDRMEVENT0904BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0904BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
    private FlowSetBL flowSetBL;
    
	/**
	 * flowSetBL   设定
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
	 * 保存演练流程中表单“演练指挥是否完成”,关联场景状态“是否已演练”改为“是”
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		//********推送流程当前状态**********
		Gson gson = new Gson();
		MessagePushBL messagePushBL = (MessagePushBL) WebApplicationSupport.getBean("messagePushBL");
		
		
		EmergencyLogBL emergencyLogBL = (EmergencyLogBL) WebApplicationSupport.getBean("emergencyLogBL");
		IG224BL ig224BL = (IG224BL) WebApplicationSupport.getBean("ig224BL");
		List<Map<String,String>> psdList = new ArrayList<Map<String,String>>(); 

		Integer prid = bean.getLogInfo().getPrid();
//		String opentime = "";
		String usetime = "00:00:00";
		//前节点psdid
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
		//停止使用时间
		Map<String,Object> useTimeMap = new HashMap<String, Object>();
		useTimeMap.put("type", "23");
		messagePushBL.pushMessage(prid+"",gson.toJson(useTimeMap));
//		----------------------------------------
		EmergencyLogTB elTB = new EmergencyLogTB();
		
		elTB.setEllidtime(datetime);
		elTB.setElliinfo("流程已关闭");
		elTB.setEllitype("1");	
		elTB.setElprid(prid);
		elTB.setEluserid("sys");
		elTB.setElusername("sys");
		elTB.setElpsdid(ig224info.getPsdid());
		elTB.setElpsdname("关闭");
		EmergencyLogInfo emInfo = emergencyLogBL.registEmergencyLog(elTB);
		//JSON传递信息Map设置
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		Map<String, String> mapInList = new LinkedHashMap<String, String>();
		mapInList.put("noticeId", emInfo.getElid().toString());//信息发布ID
		mapInList.put("noticeUser", "sys");//信息发布人
		mapInList.put("noticeTime", datetime.split(" ")[1]);//信息发布时间
		mapInList.put("noticeType", "1");//信息发布类型
		mapInList.put("noticeContnt", "流程已关闭");//信息发布内容
		list.add(mapInList);
		map1.put("data", list);
		map1.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		messagePushBL.pushMessage(prid+"", gson.toJson(map1));
		}
		// 获取本流程信息
    	ProcessRecordInfo prInfo = this.flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null).get(0);
		// 获取应急演练流程id
		String drillPrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.PRACTISE_PRID_LABEL);
		if (StringUtils.isNotEmpty(drillPrid)) {
			// 获取应急演练流程实例
			List<ProcessRecordInfo> prList = flowSearchBL.searchProcessInfo(Integer.parseInt(drillPrid), null);
			if (prList.size() > 0) {

				// 设置演练流程中的 <指挥流程prid>表单值为本流程的prid
				WorkFlowLog wfg = new WorkFlowLog();
				wfg.setPrid(Integer.parseInt(drillPrid));
				wfg.setExecutorid(bean.getCrtuserid());
				PublicProcessInfoValue ppiv = new PublicProcessInfoValue(wfg);
				ppiv.setFormname(IGDRMCONSTANTS.DRILL_PROCESS_FORM_NAME_DIRECTSTATUS);
				ppiv.setFormvalue("完成");
				flowSetBL.setPublicProcessInfoValue(ppiv);
			}

			// ********************更新场景资产属性**************************
			// 查询场景资产
			List<ProcessInfoEntityInfo> eiidList = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.SCENE_ITEM_NAME);
			if (eiidList != null && eiidList.size() > 0) {
				Integer eiid = eiidList.get(0).getEiid();
				// 更新场景资产属性”是否已演练“
				List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
				// soc0107->
				EntityItemConfigValue entityConfig = null;
				entityConfig = new EntityItemConfigValue();
				entityConfig.setEiid(eiid);
				entityConfig.setName(IGDRMCONSTANTS.DRILL_FINISED_FORM_NAME);
				entityConfig.setValue("是");
				configItems.add(entityConfig);
				// false- >update 不升版
				flowSetBL.setEntityItemConfigValue(configItems, false);
			}
		}
		
		log.debug("========计算预计恢复时间结束==========");
		IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		//判断prurgency是否为0，不为0则为演练发起
		if("0".equals(ig500Info.getPrurgency())){
			//请求地址通过业务系统ID更新业务系统应急演练状态
			IGDRMEmergencyTools.changeSystemState(prid, "业务系统", "0",null);
		}
		
	}
}
