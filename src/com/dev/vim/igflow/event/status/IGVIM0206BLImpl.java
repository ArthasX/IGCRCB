/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.vim.igflow.event.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;

/**
 * 资源调整调整中前处理设置参与者
 * 
 * @author DLK)Administrator
 * @version 1.0.0
 */
public class IGVIM0206BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGVIM0206BLImpl.class);
    private FlowSearchBL flowSearchBL;
    
    /** 更新功能API类 */
    private FlowSetBL flowSetBL;

    /** 用户角色处理BL */
    private UserRoleBL userRoleBL;

    /** 资源申请虚机信息表业务逻辑 */
    protected VIM03BL vim03BL;
    
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * 设置更新功能API类
     * @param flowSetBL 更新功能API类
     */
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    /**
     * 设置用户角色处理BL
     * @param userRoleBL 用户角色处理BL
     */
    public void setUserRoleBL(UserRoleBL userRoleBL) {
        this.userRoleBL = userRoleBL;
    }

    /**
     * 设置资源申请虚机信息表业务逻辑
     * @param vim03BL 资源申请虚机信息表业务逻辑
     */
    public void setVim03BL(VIM03BL vim03bl) {
        vim03BL = vim03bl;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        
    }

    /**
     * 前处理设置参与者 
     */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

        log.debug("======== 资源调整调整中状态节点前处理设置参与者处理开始========");
        
      //日志参数信息设定
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //封装流程状态名称
        participant.setStatusname("调整中");
        
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(participant);
        
        List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "待调整");
        
        for(ParticipantInfo info :pInfoList){
            //日志参数信息设定
            StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
            
            //封装流程处理人id
            participants.setUserid(info.getUserid());
            
            //封装流程处理角色id
            participants.setRoleid(info.getRoleid());
            
            //封装流程状态名称
            participants.setStatusname("调整中");
            
            //参与角色和参与人添加
            flowSetBL.setStatusParticipant(participants);
        }
        
        log.debug("========资源调整调整中状态节点前处理设置参与者处理结束========");
    }
}
