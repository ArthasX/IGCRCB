/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

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
 * Description: 核实审批参与人机构过滤
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0204BLImpl implements WorkFlowEventHandlerBL{
	
	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类api */
	protected FlowSetBL flowSetBL;
	
	/** 系统类api */
	protected SysManageBL sysManageBL;

	/**
	 * 查询类api设定
	 * @param flowSearchBL 查询类api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类api设定
	 * @param flowSetBL 更新类api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * 系统类api设定
	 * @param sysManageBL 系统类api
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		UserInfo userInfo = sysManageBL.searchUserInfo(bean.getLogInfo().getExecutorid());
		String orgid = userInfo.getOrgid().length() > 7 ?  userInfo.getOrgid().substring(0,7) : userInfo.getOrgid();
		List<ParticipantInfo> participants = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		
		//第一次指定到角色下的人
		Boolean isFirstHandled = true;
		ParticipantInfo participantInfo = null;
		
		if(CollectionUtils.isNotEmpty(participants)){
			for(ParticipantInfo pp : participants){
				if(StringUtils.isNotEmpty(pp.getPpproctime())){
					isFirstHandled = false;
					participantInfo = pp;
				}
			}
		}
		
		if(participants != null){
			StatusParticipant del = new StatusParticipant(bean.getLogInfo());
			del.setStatuscode(bean.getAfstatus());
			flowSetBL.deleteStatusParticipant(del);
			
			if(isFirstHandled){
				
				for(ParticipantInfo pp : participants){
					
					List<UserInfo> users = sysManageBL.searchUserInfo(pp.getRoleid(), orgid);
					if(users != null){
						for(UserInfo user:users){
							StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
							participant.setRoleid(pp.getRoleid());
							participant.setUserid(user.getUserid());
							participant.setStatuscode(bean.getAfstatus());
							flowSetBL.setStatusParticipant(participant);
						}
					}
				}
			}else{
			//添加上次处理过的人为处理人
				if(participantInfo != null){
					
					StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
					participant.setRoleid(participantInfo.getRoleid());
					participant.setUserid(participantInfo.getUserid());
					participant.setStatuscode(bean.getAfstatus());
					flowSetBL.setStatusParticipant(participant);
				}
				
			}
			
			
		}
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
