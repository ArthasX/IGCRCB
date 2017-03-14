/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
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
 * 科技服务请求流程 - （部门审批）节点前处理预置发起人角色 的部门负责人为部门审批节点的审批人
 * @author wanglei
 *
 */
public class IGCRC0501BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC0501BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
    
    /** 系统管理API类 */
    private SysManageBL sysManageBL;
    
    /** 部门审批 */
    private String SERVERS_STATUSNAME_BMSP = "部门审批";
    
    /** 数据运行中心负责人 */
    private Integer roleid_1227 = 1227;
    
    /** 系统网络中心负责人 */
    private Integer roleid_1228 = 1228;
    
    /** 软件开发中心负责人 */
    private Integer roleid_1229 = 1229;
    
    /** 综合管理部负责人 */
    private Integer roleid_1230 = 1230;
    
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
	    
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		Integer roleid = null;
        // 根据发起人机构查询节点处理人，机构id=1227为数据运行中心负责人
        List<UserInfo> userInfoList1227 = this.sysManageBL.searchUserInfo(roleid_1227, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
        if(userInfoList1227 != null && userInfoList1227.size() != 0){
        	roleid = roleid_1227;
        	userInfoList.addAll(userInfoList1227);
        }
        // 根据发起人机构查询节点处理人，机构id=1228为系统网络中心负责人
        List<UserInfo> userInfoList1228 = this.sysManageBL.searchUserInfo(roleid_1228, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
        if(userInfoList1228 != null && userInfoList1228.size() != 0){
        	roleid = roleid_1228;
        	userInfoList.addAll(userInfoList1228);
        }
        // 根据发起人机构查询节点处理人，机构id=1229为软件开发中心负责人
        List<UserInfo> userInfoList1229 = this.sysManageBL.searchUserInfo(roleid_1229, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
        if(userInfoList1229 != null && userInfoList1229.size() != 0){
        	roleid = roleid_1229;
        	userInfoList.addAll(userInfoList1229);
        }
        // 根据发起人机构查询节点处理人，机构id=1230为综合管理部负责人
        List<UserInfo> userInfoList1230 = this.sysManageBL.searchUserInfo(roleid_1230, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
        if(userInfoList1230 != null && userInfoList1230.size() != 0){
        	roleid = roleid_1230;
        	userInfoList.addAll(userInfoList1230);
        }
		
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
	        participants.setRoleid(roleid);
	      
	        //参与角色和参与人添加
	        flowSetBL.setStatusParticipant(participants);
	
	    }
	}
}

