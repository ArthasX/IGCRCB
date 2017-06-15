/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * 流程定义信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01011VO extends BaseVO implements Serializable{
	
	/** 流程定义信息检索结果 */
	protected List<IG380Info> processDefinitionList;
	
	/**
	 * 构造函数
	 * @param processDefinition　流程定义信息检索结果
	 */
	public IGPRD01011VO(List<IG380Info> processDefinitionList) {
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


