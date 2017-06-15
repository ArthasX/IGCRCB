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
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

public class IGCYB0106BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0106BLImpl.class);
    /** 更新功能API类 */
    private FlowSetBL flowSetBL;
    
    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
    /**用户角色处理BL*/
    private UserRoleBL userRoleBL;
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * 注入用户角色处理BL
     * 
     * @param userRoleBL
     */
    public void setUserRoleBL(UserRoleBL userRoleBL) {
        this.userRoleBL = userRoleBL;
    }
    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
       
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========问题分派节点添加所有流程分派人员为 参与者开始========");

        List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "问题分派");
        
        Integer roleid = pInfoList.get(0).getRoleid(); 
        
        //封装查询条件对象设定
        UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
        
        //封装查询条件为角色id
        cond.setRoleid(roleid);
        
        //根据roleid获得角色下的所有人
        List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(cond);
        
        //日志参数信息设定
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //封装流程状态名称
        participant.setStatusname("问题分派");
        
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(participant);
        
        for(UserRoleInfo info :roleList){
            //日志参数信息设定
            StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
            
            //封装流程处理人id
            participants.setUserid(info.getUserid());
            
            //封装流程处理角色id
            participants.setRoleid(info.getRoleid());
            
            //封装流程状态名称
            participants.setStatusname("问题分派");
            
            //参与角色和参与人添加
            flowSetBL.setStatusParticipant(participants);
        }
        
        log.debug("========问题分派节点添加所有流程分派人员为 参与者结束========");
    }
}
