/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.cyb.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

public class IGCYB0135BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0135BLImpl.class);
    /** 更新功能API类 */
    private FlowSetBL flowSetBL;
    
    /**用户角色处理BL*/
    private UserRoleBL userRoleBL;

    /**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    /**
     * @param 用户角色处理BL the userRoleBL to set
     */
    public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	 log.debug("========机房进出管理流程岗位负责人审批节点添加发起人角色负责人为参与者开始========");

         //日志参数信息设定
         StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
         
         //封装流程状态名称
         participant.setStatusname("岗位负责人审批");
         //删除跃迁节点的原有参与者
         flowSetBL.deleteStatusParticipant(participant);
         
         UserRoleVWSearchCondImpl urVWCond =  new UserRoleVWSearchCondImpl();
         if(bean.getCrtroleid().equals(1024)){
        	 urVWCond.setRoleid(1021);
         }
         if(bean.getCrtroleid().equals(1023)){
        	 urVWCond.setRoleid(1020);
         }
         if(bean.getCrtroleid().equals(1022)){
        	 urVWCond.setRoleid(1019);
         }
         List<UserRoleInfo> urList = userRoleBL.searchUserRoleVW(urVWCond);
         for (UserRoleInfo userRoleInfo : urList) {
        	 StatusParticipant participant1 = new StatusParticipant(bean.getLogInfo());
        	 participant1.setStatusname("岗位负责人审批");
        	 participant1.setUserid(userRoleInfo.getUserid());		// 角色负责人id
        	 participant1.setRoleid(userRoleInfo.getRoleid());
        	 this.flowSetBL.setStatusParticipant(participant1);
		}
        log.debug("========机房进出管理流程岗位负责人审批节点添加发起人角色负责人为参与者结束========");
    }
}
