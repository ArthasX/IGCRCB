/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.status;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
 * Description: 查询角色下的所有人并设置成参与人
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public class IGFXK0604BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGFXK0604BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;
	
	/** 系统类BL */
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
	 * 系统类BL设定
	 * @param sysManageBL 系统类BL
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=================设置执行人开始=================");
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
				participant.setRoleid(roleid);
				participant.setUserid(user.getUserid());
				flowSetBL.setStatusParticipant(participant);
			}
		}
		log.debug("=================设置执行人结束=================");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
