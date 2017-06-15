/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * 概述: 流程定义信息检索结果ＶＯ
 * 功能描述：流程定义信息检索结果ＶＯ
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM17011VO extends BaseVO implements Serializable{
	
	/** 流程定义信息检索结果 */
	protected List<IG380Info> processDefinitionList;

	/**
	 * 构造函数
	 * @param processDefinition　流程定义信息检索结果
	 */
	public IGSYM17011VO(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}
	
	/**
	 * 流程定义信息检索结果取得
	 * @return 流程定义信息检索结果
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

}


