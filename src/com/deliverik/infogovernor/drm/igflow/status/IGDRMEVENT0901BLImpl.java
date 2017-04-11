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
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * 应急指挥流程-应急处置节点前处理
 * 
 * 发起相关场景流程
 * 
 * @author 张剑
 *
 * 2015-3-11 上午10:24:34
 */
public class IGDRMEVENT0901BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0901BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
    private FlowOptBL flowOptBL;

    private FlowSetBL flowSetBL;

    
    private EmergencyRelationBL emergencyRelationBL;
    
    private SigninBL signinBL;
    
    
    private WorkFlowOperationBL workFlowOperationBL;
    
    public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
    
	public void setEmergencyRelationBL(EmergencyRelationBL emergencyRelationBL) {
		this.emergencyRelationBL = emergencyRelationBL;
	}

	/**
	 * signinBL   设定
	 * @param signinBL signinBL
	 */
	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}


	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
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

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
	
	/**
	 * 
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========发起场景中的技术恢复步骤开始========");
    	
    	//获取场景资产eiid
    	Integer eiid = 0;
    	// 获取本流程信息
    	ProcessRecordInfo prInfo = this.flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null).get(0);
    	
    	//查询场景资产
    	List<ProcessInfoEntityInfo> eiidList = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.SCENE_ITEM_NAME);
    	
    	//技术恢复流程id
    	Integer cldPrid = null;
    	
    	if(eiidList!=null&&eiidList.size()>0){
    		
    		eiid = eiidList.get(0).getEiid();
    		
			EmergencyRelationTB erTb = new EmergencyRelationTB();
            erTb.setParprid(prInfo.getPrid());
            
			//获取场景中的流程定义id
        	String pdid = flowSearchBL.searchEntityItemConfigValue(eiid, IGDRMCONSTANTS.PROCESS_DEF_ID);
        	if(StringUtils.isEmpty(pdid)){
    	         throw new BLException("IGEXTERNAL.E001","未查询到场景中关联的流程模版");
        	}
        	// 获取应急演练流程id
        	String drillPrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.PRACTISE_PRID_LABEL);    
    	    // 发起技术恢复流程信息
            WorkFlowLog logInfo = new WorkFlowLog();
            logInfo.setAuthuserid(null);
            logInfo.setExecutorid(bean.getLogInfo().getExecutorid());
            logInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
            ProcessRecord processRecord = new ProcessRecord(logInfo);
			// 获取本流程信息
			if (StringUtils.isEmpty(drillPrid)) {
				processRecord.setTitle(prInfo.getPrtitle() + "-" + "应急恢复");
			} else {
				processRecord.setTitle(prInfo.getPrtitle() + "-" + "演练恢复");
			}
            processRecord.setDescription(prInfo.getPrdesc());
            processRecord.setDefid(pdid);
            processRecord.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
            //发起子(技术恢复步骤)流程
			cldPrid = this.flowOptBL.saveProcessAction(processRecord);
			erTb.setCldType(IGDRMCONSTANTS.DIRECT_RELATE_SCENE);
			
			//*********************初始化场景的人**************************

			
			// 如果不是演练发起的指挥流程则初始场景的签到信息
			// if (StringUtils.isEmpty(drillPrid)) {
				signinBL.updateSigninForRestoreByDirectPrid(bean.getLogInfo().getPrid(), cldPrid);
			// }
            
            //*********************发送邮件给技术回复人员*********************
            //专项预案
	        String emcproeiname= this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.PLAN_NAME).get(0).getEiname();
	        //演练场景
	        String sceneeiname = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.SCENE_ITEM_NAME).get(0).getEiname();
	        //发送邮件
	        workFlowOperationBL.send(prInfo.getPrid(), emcproeiname, sceneeiname, pdid, IGStringUtils.getCurrentDateTime());
	        
	        
            //****************更新应急指挥(本流程中表单)*********************
            
            //设置指挥流程中的 <场景流程prid>表单值为技术恢复步骤的prid
			WorkFlowLog wfg = new WorkFlowLog();
			wfg.setPrid(prInfo.getPrid());
			wfg.setExecutorid(bean.getCrtuserid());
			PublicProcessInfoValue ppiv = new PublicProcessInfoValue(wfg);
			
			ppiv.setFormname(IGDRMCONSTANTS.DIRECT_FROM_NAME_SCENE_PRID);
			ppiv.setFormvalue(""+cldPrid);
			flowSetBL.setPublicProcessInfoValue(ppiv);
			
			
			//***************建立应急指挥流程和技术恢复流程关系**********************
            erTb.setCldprid(cldPrid);
            erTb.setRelatetype(IGDRMCONSTANTS.DIRECT_RELATE_SCENE);
            erTb.setPrrinstime(IGStringUtils.getCurrentDateTime());
            emergencyRelationBL.registEmergencyRelationInfo(erTb);
			// ***************建立演练流程和技术恢复流程关系**********************
			// 获取应急演练流程id
			if (StringUtils.isNotEmpty(drillPrid)) {
				erTb = new EmergencyRelationTB();
				erTb.setCldprid(cldPrid);
				erTb.setParprid(Integer.valueOf(drillPrid));
				erTb.setCldType("1");
				erTb.setPrrinstime(DateUtils.getCurrentTime());
				erTb.setRelatetype(IGDRMCONSTANTS.DRILL_RELATE_SCENE);
				emergencyRelationBL.registEmergencyRelationInfo(erTb);
				
				//设置处置流程与指挥流程相同的类型 (应急/演练)
				Map<String, Object> map = new HashMap<String, Object>();
	 			IG500BL i500BL = (IG500BL)WebApplicationSupport.getBean("ig500BL");
	 			
	 			map.put("prurgency", i500BL.searchIG500InfoByKey(prInfo.getPrid()).getPrurgency());
	 			flowSetBL.updateProcessRecord(cldPrid, map);
			}
			this.flowOptBL.transitionProcess(cldPrid, bean.getLogInfo().getExecutorid(), "提交", IGStringUtils.getCurrentDateTime());
    	}
    	

        log.debug("========发起场景中的技术恢复步骤开始========");
    	
    	
    }
}
