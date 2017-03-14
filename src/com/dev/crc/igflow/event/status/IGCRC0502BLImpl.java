/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * 业务服务请求流程 - （部门审批）节点前处理预置发起人角色 的部门负责人为部门审批节点的审批人
 * @author wanglei
 *
 */
public class IGCRC0502BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC0502BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
    
    /** 系统管理API类 */
    private SysManageBL sysManageBL;
    
    /** 部门审批 */
    private String SERVERS_STATUSNAME_BMSP = "部门审批";
    
    /** 业务领导审批 */
    private Integer roleid_1201 = 1201;
    
	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

    /**
     * @param 系统管理API类 the sysManagerBL to set
     */
    public void setSysManageBL(SysManageBL sysManageBL) {
        this.sysManageBL = sysManageBL;
    }
    
	/**
     * 后处理
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
	
	/**
	 * 前处理添加参与者
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========变更流程部门审批前处理设置参与者处理开始========");

	    //日志参数信息设定
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //封装流程状态名称
        participant.setStatusname(SERVERS_STATUSNAME_BMSP);
        
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(participant);
        
        // 设置部门审批人
        setParticipant(bean);
      
		log.debug("========变更流程部门审批前处理设置参与者处理结束========");
	}

	/**
	 * 设置审批人
	 * @param bean
	 * @param applevel
	 * @param roleid
	 * @throws BLException
	 */
	private void setParticipant(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
        // 根据发起人机构查询节点处理人，机构id=1201为业务领导审批
        List<UserInfo> userInfoList = this.sysManageBL.searchUserInfo(roleid_1201, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
		
	    if (userInfoList == null || userInfoList.size() == 0) {
	        throw new BLException("IGSVC0804.E001");
	    }
	    for (UserInfo userInfo : userInfoList) {
			
	        //日志参数信息设定
	        StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
	      
	        //封装流程状态名称
	        participants.setStatusname(SERVERS_STATUSNAME_BMSP);
	        
	        //封装流程处理人id
	        participants.setUserid(userInfo.getUserid());
	      
	        //封装流程处理角色id
	        participants.setRoleid(roleid_1201);
	      
	        //参与角色和参与人添加
	        flowSetBL.setStatusParticipant(participants);
	
	    }
	}
}

