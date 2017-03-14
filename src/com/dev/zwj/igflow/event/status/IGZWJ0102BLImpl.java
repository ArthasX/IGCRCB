/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.zwj.igflow.event.status;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ0102BLImpl implements WorkFlowEventHandlerBL{
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新API */
	protected FlowSetBL flowSetBL;
	
	/** 系统类API */
	protected SysManageBL sysManageBL;

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 系统类API设定
	 * @param sysManageBL 系统类API
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//查询处理节点参与人
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "处理");
		//删除核实节点处理人
		StatusParticipant p = new StatusParticipant(bean.getLogInfo());
		p.setStatusname("核实");
		flowSetBL.deleteStatusParticipant(p);
		Set<String> set = new HashSet<String>();
		for(ParticipantInfo pp:list){
			set.add(pp.getRolename());
		}
		for(Iterator<String> iter = set.iterator();iter.hasNext();){
			String rolename = iter.next();
			Integer roleid = 0;
			if("系统组".equals(rolename)){
				roleid = 1019;
			}
			if("网络组".equals(rolename)){
				roleid = 1020;
			}
			if("设备组".equals(rolename)){
				roleid = 1021;
			}
			List<UserInfo> userList = sysManageBL.searchUserInfo(roleid, null);
			for(UserInfo user : userList){
				p.setRoleid(roleid);
				p.setUserid(user.getUserid());
				flowSetBL.setStatusParticipant(p);
			}
		}
	}

}
