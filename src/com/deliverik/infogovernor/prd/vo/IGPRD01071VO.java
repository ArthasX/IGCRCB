/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * 流程定义_参与者Vo
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01071VO extends BaseVO implements Serializable {

	/** 未添加参与者对象List */
	protected List<Role> roleList;
	
	/** 已添加参与者对象List  */
	protected List<IG222Info> processParticipantDefList;
	
	/** 流程状态信息 */
	protected IG333Info processStatusDef;
	
	/** 已添加参与者对象ListSize */
	protected Integer processParticipantDefListSize;
	
	/** 流程状态_参与者集合 */
	protected Map<Integer, List<IG222Info>> processParticipantDefMap;

	/**
	 * 构造方法
	 * @param roleList List<Role>,processParticipantDefList List<ProcessParticipantDef>
	 */
	
	public IGPRD01071VO(List<Role> roleList,List<IG222Info> processParticipantDefList) {
		this.roleList = roleList;
		this.processParticipantDefList = processParticipantDefList;
		if(processParticipantDefList == null) {
			processParticipantDefListSize = 0;
		} else {
			processParticipantDefListSize = processParticipantDefList.size();
		}
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public void setProcessParticipantDefList(
			List<IG222Info> processParticipantDefList) {
		this.processParticipantDefList = processParticipantDefList;
	}
	

	/**
	 * 获取未添加参与者对象List
	 * @return List<Role>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}

	
	/**
	 * 获取已添加参与者对象List
	 * @return List<ProcessParticipant>
	 */

	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}

	/**
	 * 流程状态信息取得
	 * 
	 * @return 流程状态信息
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}
	
	/**
	 * 流程状态信息设定
	 *
	 * @param processStatusDef 流程状态信息
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * 已添加参与者对象ListSize
	 * 
	 * @return 已添加参与者对象ListSize
	 */
	public Integer getProcessParticipantDefListSize() {
		return processParticipantDefListSize;
	}
	
	/**
	 * 流程状态_参与者集合取得
	 * @return 流程状态_参与者集合
	 */
	public Map<Integer, List<IG222Info>> getProcessParticipantDefMap() {
		return processParticipantDefMap;
	}

	/**
	 * 流程状态_参与者集合设定
	 * @param processParticipantDefMap 流程状态_参与者集合
	 */
	public void setProcessParticipantDefMap(
			Map<Integer, List<IG222Info>> processParticipantDefMap) {
		this.processParticipantDefMap = processParticipantDefMap;
	}
}
