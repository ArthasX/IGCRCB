/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**
 * 应急演练流程-演练实施前处理
 * 
 * 更新演练计划表和计划任务表 修改状态为已演练
 * 
 * @author zyl
 *
 * 2015年3月16日13:34:06
 */
public class IGDRMEVENT0704BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0704BLImpl.class);
    
    /**流程API*/
    private FlowSearchBL flowSearchBL;
    
    private FlowOptBL flowOptBL;
    
    private FlowSetBL flowSetBL;
    
    private EmergencyRelationBL emergencyRelationBL;
    

	/** 签到表BL */
	private SigninBL signinBL;

	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}
	/**
	 * flowOptBL   设定
	 * @param flowOptBL flowOptBL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	/**
	 * flowSetBL   设定
	 * @param FlowSetBL flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	/**
	 * @param 流程API the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	public void setEmergencyRelationBL(EmergencyRelationBL emergencyRelationBL) {
		this.emergencyRelationBL = emergencyRelationBL;
	}
	
    /**
     * 演练计划发起后处理
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
	
	/**
	 * 演练计划发起前处理
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========演练实现前发起相关流程开始========");
		// 获取本流程信息
    	ProcessRecordInfo prInfo = this.flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null).get(0);
		//查询需发起的流程
		String relateVal = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),IGDRMCONSTANTS.DRILL_RELATE_PROCESS_FORM_NAME);
		
		WorkFlowLog logInfo = new WorkFlowLog();
        logInfo.setAuthuserid(null);
        logInfo.setExecutorid(bean.getLogInfo().getExecutorid());
        logInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
        ProcessRecord processRecord = new ProcessRecord(logInfo);
        processRecord.setTitle(prInfo.getPrtitle());
        processRecord.setDescription(prInfo.getPrdesc());
        
        Integer prid = null;
        
        String relatetype = "";
        
		//应急指挥
		if(IGDRMCONSTANTS.DRILL_RELATE_PROCESS_FORM_DIRECT.equals(relateVal)){
		
			Map<String,String> formvalue = new HashMap<String,String>();
			processRecord.setTitle(prInfo.getPrtitle() + "-" + "演练指挥");
			formvalue.put(IGDRMCONSTANTS.PLAN_NAME, "N/A");
			formvalue.put(IGDRMCONSTANTS.SCENE_ITEM_NAME, "N/A");
			formvalue.put(IGDRMCONSTANTS.ITEM_SYSTEM_FORM_NAME, "N/A");
			formvalue.put(IGDRMCONSTANTS.DIRECT_PARTICIPANT_ADJUST_FORM_NAME, "tab");
			formvalue.put(IGDRMCONSTANTS.PRACTISE_PRID_LABEL,prInfo.getPrid().toString());
			formvalue.put("事件名称", prInfo.getPrtitle() + "-" + "演练指挥");
			processRecord.setFormvalue(formvalue);
			//流程定义
			processRecord.setDefid(IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID);
			//发起流程
	        prid = this.flowOptBL.saveProcessAction(processRecord);
	        
	        //演练流程表单赋值
	        PublicProcessInfoValue ptInfo = new PublicProcessInfoValue(bean.getLogInfo());
	        ptInfo.setFormname(IGDRMCONSTANTS.DRILL_FROM_NAME_DIRECT_PRID);
	        ptInfo.setFormvalue(prid+"");
	        flowSetBL.setPublicProcessInfoValue(ptInfo);
	        
	        //*********************应急指挥流程*********************
			//专项预案
	        Integer emcproeiid = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.SPECIAL_PLAN_NAME).get(0).getEiid();
			//演练场景
	        Integer sceneeiiid = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.EMERGENCY_SCENE_NAME).get(0).getEiid();
			//业务系统
			List<ProcessInfoEntityInfo> list = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.DRILL_SYSTEM_FORM_NAME);
			//设置流程-资产关联关系
			flowSetBL.setProcessEntityRelation(prid, IGDRMCONSTANTS.PLAN_NAME, emcproeiid, null);
			flowSetBL.setProcessEntityRelation(prid, IGDRMCONSTANTS.SCENE_ITEM_NAME, sceneeiiid, null);
			flowSetBL.setProcessEntityItem(prid,IGDRMCONSTANTS.ITEM_SYSTEM_FORM_NAME,list);
			//设置表格关系
			flowSetBL.setProcessSceneParticipant(prInfo.getPrid(), IGDRMCONSTANTS.DRILL_PARTICIPANT_ADJUST_FORM_NAME, prid, IGDRMCONSTANTS.DIRECT_PARTICIPANT_ADJUST_FORM_NAME, IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID);

			// 设置指挥流程类型为演练发起
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("prurgency", "1");
			flowSetBL.updateProcessRecord(prid, map);
			
			//-----------------初始化签到信息----
			signinBL.updateSigninForEcp(prInfo.getPrid(), prid);

			relatetype = IGDRMCONSTANTS.DRILL_RELATE_DIRECT;
		}
		//场景
		else if(IGDRMCONSTANTS.DRILL_RELATE_PROCESS_FORM_SCENE.equals(relateVal)){
			
			processRecord.setTitle(prInfo.getPrtitle() + "-" + "演练处置");
            processRecord.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
            
			//查询场景资产
	    	List<ProcessInfoEntityInfo> eiidList = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.EMERGENCY_SCENE_NAME);
			//获取场景中的流程定义id
        	String pdid = flowSearchBL.searchEntityItemConfigValue(eiidList.get(0).getEiid(), IGDRMCONSTANTS.PROCESS_DEF_ID);
        	if(StringUtils.isEmpty(pdid)){
 	            throw new BLException("IGEXTERNAL.E001","未查询到场景中关联的流程模版");
        	}	
        	//流程定义
        	processRecord.setDefid(pdid);
    		//发起流程
            prid = this.flowOptBL.initProcessAction(processRecord);
            
            //演练流程表单赋值
	        PublicProcessInfoValue ptInfo = new PublicProcessInfoValue(bean.getLogInfo());
	        ptInfo.setFormname(IGDRMCONSTANTS.DRILL_FROM_NAME_SCENE_PRID);
	        ptInfo.setFormvalue(prid+"");
	        flowSetBL.setPublicProcessInfoValue(ptInfo);
			
	        relatetype = IGDRMCONSTANTS.DRILL_RELATE_SCENE;
	        
			// -----------------初始化签到信息----
			signinBL.updateSigninForRestore(prInfo.getPrid(), prid);
			
		}
		//建立关联关系
		if(prid != null){
			EmergencyRelationTB erTb = new EmergencyRelationTB();
			erTb.setParprid(prInfo.getPrid());
			erTb.setCldprid(prid);
			erTb.setCldType("1");
			erTb.setRelatetype(relatetype);
			erTb.setPrrinstime(IGStringUtils.getCurrentDateTime());
	        emergencyRelationBL.registEmergencyRelationInfo(erTb);
		}
		
		log.debug("========演练实现前发起相关流程结束========");
		//请求地址通过业务系统ID更新业务系统应急演练状态
		String desc = IGDRMEmergencyTools.getDesc(bean.getLogInfo().getPrid());
		IGDRMEmergencyTools.changeSystemState(prid, "业务系统", "2",desc);
    }
}
