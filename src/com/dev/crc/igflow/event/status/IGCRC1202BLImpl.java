/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**	
 * 概述:入库借阅流程综合管理部负责人审批节点前处理
 * 功能描述：判断组织为综合管理部的中心负责人加入参与人
 *         
 * 创建记录：taoye@deliverik.com   2014-7-17
 * 修改记录：
 */

public class IGCRC1202BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{

	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC1202BLImpl.class);
	
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
		log.debug("=================入库借阅流程综合管理部负责人审批节点前处理开始=================");
		//查询参与人定义
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		//角色信息集合
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(ParticipantInfo info:list){
			set.add(info.getRoleid());
		}
		//实例化参与人信息
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatuscode(bean.getAfstatus());
		//删除参与人定义
		flowSetBL.deleteStatusParticipant(participant);
		//查询角色用户
		for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
			Integer roleid = iter.next();
			//查询角色用户
			List<UserInfo> userList = sysManageBL.searchUserInfo(roleid, null);
			//遍历设置用户
			for(UserInfo user:userList){
				//当用户组织为科技部——综合管理部时，增加参与人
				if("0002001017001".equals(user.getOrgid())){
					participant.setRoleid(roleid);
					participant.setUserid(user.getUserid());
					flowSetBL.setStatusParticipant(participant);
				}
			}
		}
		log.debug("=================入库借阅流程综合管理部负责人审批节点前处理结束=================");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
