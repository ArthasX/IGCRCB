/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 未指定到人的情况，查询角色下的所有人并设置成参与人
 * 				   指定到人的情况，指定人为参与人
 * </p>
 * 
 * @author ZYL
 * @version 1.0
 */
public class IGDRMEVENT0104BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGDRMEVENT0104BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;
	
	/** 系统类BL */
	protected SysManageBL sysManageBL;
	
	/** 系统类BL */
	protected IG337BL ig337BL;
	
	/** 流程参与人BL */
	protected IG222BL ig222BL;

	/**
	 * @param ig337bl the 系统类BL to set
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

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
	 * @param ig222bl the 流程参与人BL to set
	 */
	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=================设置执行人开始=================");
		//实例化操作参数信息
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatuscode(bean.getAfstatus());
		//查询当前结点所有参与人
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		if(list!=null){
		Set<Integer> set = new HashSet<Integer>();
		for(ParticipantInfo info:list){
			//把所有指定到角色的参与人信息过滤处理，将角色放入集合，并删除当前角色的参与人信息
			if(StringUtils.isEmpty(info.getUserid())){
				set.add(info.getRoleid());
				participant.setRoleid(info.getRoleid());
				flowSetBL.deleteStatusParticipant(participant);
			}
		}
		//遍历角色集合，将原来只到角色的参与人信息增加至具体
		for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
			Integer roleid = iter.next();
			//查询角色下的所有用户 
			List<UserInfo> userList = sysManageBL.searchUserInfo(roleid, null);
			participant.setRoleid(roleid);
			//遍历用户添加参与人 
			for(UserInfo info:userList){
				participant.setUserid(info.getUserid());
				flowSetBL.setStatusParticipant(participant);;
			}
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
