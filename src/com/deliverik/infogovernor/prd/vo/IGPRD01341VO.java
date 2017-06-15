/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:参与者支持机构选择VO 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01341VO extends BaseVO{
	
	/** 未添加参与者对象List */
	protected List<IG123Info> orgList;
	
	/** 已添加参与者对象List */
	protected List<IG222Info> processParticipantDefList;

	/** 流程状态信息 */
	protected IG333Info processStatusDef;
	
	/** 已添加参与者对象ListSize */
	protected Integer processParticipantDefListSize;

	/**
	 * 未添加参与者对象List取得
	 * @return 未添加参与者对象List
	 */
	public List<IG123Info> getOrgList() {
		return orgList;
	}

	/**
	 * 未添加参与者对象List设定
	 * @param orgList 未添加参与者对象List
	 */
	public void setOrgList(List<IG123Info> orgList) {
		this.orgList = orgList;
	}

	/**
	 * 已添加参与者对象List取得
	 * @return 已添加参与者对象List
	 */
	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}

	/**
	 * 已添加参与者对象List设定
	 * @param processParticipantDefList 已添加参与者对象List
	 */
	public void setProcessParticipantDefList(
			List<IG222Info> processParticipantDefList) {
		this.processParticipantDefList = processParticipantDefList;
	}
	
	/**
	 * 流程状态信息取得
	 * @return 流程状态信息
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 流程状态信息设定
	 * @param processStatusDef 流程状态信息
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * 已添加参与者对象ListSize取得
	 * @return 已添加参与者对象ListSize
	 */
	public Integer getProcessParticipantDefListSize() {
		return processParticipantDefListSize;
	}

	/**
	 * 已添加参与者对象ListSize设定
	 * @param processParticipantDefListSize 已添加参与者对象ListSize
	 */
	public void setProcessParticipantDefListSize(
			Integer processParticipantDefListSize) {
		this.processParticipantDefListSize = processParticipantDefListSize;
	}
	
}
