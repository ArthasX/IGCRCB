/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCondImpl;

/**
 * 应急演练流程-关闭节点前处理
 * 
 * 更新演练计划表和计划任务表 修改状态为已演练
 * 
 * @author zyl
 *
 * 2015年3月16日13:34:06
 */
public class IGDRMEVENT0301BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0301BLImpl.class);
    
    /**流程API*/
    private FlowSearchBL flowSearchBL;
    
    private FlowSetBL flowSetBL;
    
    private WorkFlowDefinitionBL workFlowDefinitionBL;
    
    private EmergencyRelationBL emergencyRelationBL;
    
    private IG898BL ig898BL;
    
    private UserRoleBL userRoleBL;
    
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setEmergencyRelationBL(EmergencyRelationBL emergencyRelationBL) {
		this.emergencyRelationBL = emergencyRelationBL;
	}
    
    public void setIg898BL(IG898BL ig898bl) {
		ig898BL = ig898bl;
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
	
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
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
    	log.debug("========场景相关流程赋值处理人开始========");
		// 获取本流程信息
    	ProcessRecordInfo prInfo = this.flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null).get(0);
    	String psdid = bean.getAfstatus();
		// 查询出关联的应急演练
		EmergencyRelationSearchCondImpl erCond = new EmergencyRelationSearchCondImpl();
		erCond.setCldprid(prInfo.getPrid());
		erCond.setRelatetype(IGDRMCONSTANTS.DRILL_RELATE_SCENE);
		List<EmergencyRelationInfo> drillList = emergencyRelationBL.searchEmergencyRelationInfo(erCond, 0, 0);
		// 查询与其相关的指挥流程
		erCond.setRelatetype(IGDRMCONSTANTS.DIRECT_RELATE_SCENE);
		List<EmergencyRelationInfo> ecpList = emergencyRelationBL.searchEmergencyRelationInfo(erCond, 0, 0);
        
    	//关闭节点 演练流程表单赋值
    	if((bean.getPdid()+"002").equals(psdid)){
			// 如果关联了演练流程并且没有关联的指挥流程说明是演练直接发起的技术恢复流程,则 给关联的演练流程表单赋值
			if (drillList != null && drillList.size() > 0 && (ecpList == null || ecpList.size() == 0)) {
    			for(EmergencyRelationInfo info : drillList){
    				//设定loginfo
    				WorkFlowLog logInfo = new WorkFlowLog();
    				logInfo.setExecutorid(bean.getLogInfo().getExecutorid());
    				logInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
    				logInfo.setPrid(info.getParprid());
    				logInfo.setComment(bean.getLogInfo().getComment());
    				//设置表单值
    				PublicProcessInfoValue ptInfo = new PublicProcessInfoValue(logInfo);
    				ptInfo.setFormname(IGDRMCONSTANTS.DRILL_PROCESS_FORM_NAME_DIRECTSTATUS);
    				ptInfo.setFormvalue("完成");
    				//保存
    				flowSetBL.setPublicProcessInfoValue(ptInfo);
    			}
    		}
    		
    	}else{

    		IG898SearchCondImpl ig898Cond = new IG898SearchCondImpl();
			Integer prid = 0;
			if (CollectionUtils.isNotEmpty(drillList)) {
				prid = drillList.get(0).getParprid();
			} else if (CollectionUtils.isNotEmpty(ecpList)) {
				prid = ecpList.get(0).getParprid();
			}
			ig898Cond.setPrid(prid);
            ig898Cond.setPvalue(psdid);
            List<IG898Info> participantList =  ig898BL.searchIG898(ig898Cond);
            if(participantList != null && participantList.size() > 0){
            	IG333Info ig333Info = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
            	//添加流程实施处理人
           	 	StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
           		//节点状态
           	 	participant.setStatusname(ig333Info.getPsdname());
           	    //删除跃迁节点的原有参与者
                flowSetBL.deleteStatusParticipant(participant);
                
                //添加处理人
				String rownumber = "";

				IG898Info curParticipantForm = null;

				for (IG898Info ig898Info : participantList) {
					if ("流程节点id".equals(ig898Info.getPvcolname()) && psdid.equals(ig898Info.getPvalue())) {
						rownumber = ig898Info.getPvrownumber();
						break;
					}
				}
				for (IG898Info ig898Info : participantList) {
					if (rownumber.equals(ig898Info.getPvrownumber()) && IGDRMCONSTANTS.DIRECT_ADJUST_PARTIC.equals(ig898Info.getPvcolname())) {
						curParticipantForm = ig898Info;
						break;
					}
				}
				if (curParticipantForm != null) {
					// IG898Info info = list.get(0);
					if (StringUtils.isNotBlank(curParticipantForm.getPvalue())) {
						String[] roleuser = curParticipantForm.getPvalue().split("_roleuser_");
                		for(String roleuserInfo : roleuser){
                			String[] roleur =  roleuserInfo.split("_role_");
                			if(roleur != null){
                				String role = roleuserInfo.split("_role_")[0];
                				//指定到人
                				if(roleur.length > 1){
									String user = roleuserInfo.split("_role_")[1];
                        			String[] userlist = user.split("_user_");
                        			participant.setRoleid(Integer.parseInt(role.split("#")[0]));
                        			
                        			for(String userinfo : userlist){
										String userid = userinfo.split("#")[0];
										if (userid.startsWith("_")) {
											userid = userid.substring(1);
										}
                        				participant.setUserid(userid);
                        				flowSetBL.setStatusParticipant(participant);
                        			}
                    			}
                				//指定到角色，查询角色下所有人
                				else if(roleur != null && roleur.length == 1){
                    				String roleid = role.split("#")[0];
    								UserRoleSearchCondImpl userroleCond = new UserRoleSearchCondImpl();
    								userroleCond.setRoleid(Integer.parseInt(roleid));
    								List<UserRole> userRoleList = userRoleBL.searchUserRole(userroleCond);
    								if(userRoleList != null && userRoleList.size() > 0){
    									for(UserRole userRole : userRoleList){
    										participant.setUserid(userRole.getUserid());
                            				flowSetBL.setStatusParticipant(participant);
    									}
    								}
                    			}
                			}
                			
                		}
                	}
                }
            }
    	}
		log.debug("========场景相关流程赋值处理人结束========");
    }
    
}
