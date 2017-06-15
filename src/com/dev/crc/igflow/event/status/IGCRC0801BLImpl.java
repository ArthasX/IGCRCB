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
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * 入库申请流程入库审批分类节点前处理
 * @time 2014/06/25
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGCRC0801BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC0801BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
    /** 流程查询功能API */
    private SysManageBL sysManageBL;
    
	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 注入查询功能API类
	 * 
	 * @param flowSearchBL
	 */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
      
    /**
     * 注入流程查询功能API
     * @param sysManageBL 流程查询功能API
     */
    public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
     * 前处理
     */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=====================入库申请流程入库审批分类的前置处理开始=====================");
		
		//获取文档分类值
		String documentSort = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),"文档分类");
		//初始化角色名称
		String rolename = "";
		//文档分类为不同分类时，由不同的文档管理员审批
		if( documentSort.indexOf("科技管理类") > 0 ){
			rolename = "科技管理类文档管理员";
		}else if( documentSort.indexOf("软件开发类") > 0 ){
			rolename = "软件开发类文档管理员";
		}else if( documentSort.indexOf("生产运行类") > 0 ){
			rolename = "生产运行类文档管理员";
		}
		//获取角色列表
		List<RoleInfo> roleinfos = sysManageBL.searchRoleInfo(rolename);
		
		//实例化参与人信息
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("入库审批分类 ");
		
		//删除参与人定义
		flowSetBL.deleteStatusParticipant(participant);
		
		for(RoleInfo info : roleinfos){
			//获取用户信息
			List<UserInfo> userInfos = sysManageBL.searchUserInfo(info.getRoleid(),"");
			for(UserInfo user : userInfos){
				//状态参与者信息设置
				StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
				statusParticipant.setRoleid(info.getRoleid());
				statusParticipant.setUserid(user.getUserid());
				statusParticipant.setStatusname("入库审批分类 ");
				//添加参与者
				flowSetBL.setStatusParticipant(statusParticipant);
			}
		}
		
		log.debug("=====================入库申请流程入库审批分类的前置处理开始=====================");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}