/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * 流程并行节点规则定义信息检索结果ＶＯ
 * 
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01151VO extends BaseVO implements Serializable {

	/** 规则定义信息检索结果 */
	protected List<IG273Info> processTransitionDefList;

	/** 流程状态信息 */
	protected IG333Info processStatusDef;

	/**
	 * 构造函数
	 * 
	 * @param processTransitionDef规则定义信息检索结果
	 * @param processStatusDef流程状态信息
	 */
	public IGPRD01151VO(List<IG273Info> processTransitionDefList,
			IG333Info processStatusDef) {
		this.processTransitionDefList = processTransitionDefList;
		this.processStatusDef = processStatusDef;
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

}
