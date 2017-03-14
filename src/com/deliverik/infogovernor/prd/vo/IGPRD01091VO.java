/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;

/**
 * 规则定义信息检索结果ＶＯ
 * 
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01091VO extends BaseVO implements Serializable {

	/** 规则定义信息检索结果 */
	protected List<IG273Info> processTransitionDefList;

	/** 流程状态信息 */
	protected IG333Info processStatusDef;

	/** 流程状态_参与者集合 */
	protected List<IG222Info> processParticipantDefList;
	
	protected List<IG725Info> participantDefaultButtonDefInfoList;
	
	public List<IG725Info> getParticipantDefaultButtonDefInfoList() {
		return participantDefaultButtonDefInfoList;
	}

	public void setParticipantDefaultButtonDefInfoList(
			List<IG725Info> participantDefaultButtonDefInfoList) {
		this.participantDefaultButtonDefInfoList = participantDefaultButtonDefInfoList;
	}

	/**
	 * 构造函数
	 * 
	 * @param processTransitionDef
	 *            　规则定义信息检索结果
	 * @param processStatusDef
	 *            　流程状态信息
	 */
	public IGPRD01091VO(List<IG273Info> processTransitionDefList,
			IG333Info processStatusDef,
			List<IG222Info> processParticipantDefList) {
		this.processTransitionDefList = processTransitionDefList;
		this.processStatusDef = processStatusDef;
		this.processParticipantDefList = processParticipantDefList;
	}

	/**
	 * 规则定义信息检索结果取得
	 * 
	 * @return 规则定义信息检索结果
	 */
	public List<IG273Info> getProcessTransitionDefList() {
		return processTransitionDefList;
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
	 * 流程状态参与者集合取得
	 * 
	 * @return 流程状态参与者集合
	 */
	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}
	
	public Map<String, List<IG132Info>> processParticipantButtonDefMap;

	public Map<String, List<IG132Info>> getProcessParticipantButtonDefMap() {
		return processParticipantButtonDefMap;
	}

	public void setProcessParticipantButtonDefMap(
			Map<String, List<IG132Info>> processParticipantButtonDefMap) {
		this.processParticipantButtonDefMap = processParticipantButtonDefMap;
	}
}
