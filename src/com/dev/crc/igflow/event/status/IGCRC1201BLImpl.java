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

/**	
 * 概述:入库借阅流程待发起节点后处理
 * 功能描述：判断文档分类，为文档管理员审批和归还节点配置参与人
 *         
 * 创建记录：taoye@deliverik.com   2014-7-11
 * 修改记录：
 */

public class IGCRC1201BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{

	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC1201BLImpl.class);
	
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
		
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=====================入库借阅流程待发起节点后处理开始=====================");
		
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
		
		//首先删除节点的参与者
		StatusParticipant statusParticipant_del = new StatusParticipant(bean.getLogInfo());
		statusParticipant_del.setStatusname("文档管理员审批");
		flowSetBL.deleteStatusParticipant(statusParticipant_del);
		statusParticipant_del.setStatusname("归还");
		flowSetBL.deleteStatusParticipant(statusParticipant_del);
		
		for(RoleInfo info : roleinfos){
			//获取用户信息
			List<UserInfo> userInfos = sysManageBL.searchUserInfo(info.getRoleid(),"");
			for(UserInfo user : userInfos){
				//状态参与者信息设置
				StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
				statusParticipant.setRoleid(info.getRoleid());
				statusParticipant.setUserid(user.getUserid());
				statusParticipant.setStatusname("文档管理员审批");
				flowSetBL.setStatusParticipant(statusParticipant);
			
				statusParticipant.setStatusname("归还");
				flowSetBL.setStatusParticipant(statusParticipant);
			}
		}
		
		log.debug("=====================入库借阅流程待发起节点后处理结束=====================");
	}

}
