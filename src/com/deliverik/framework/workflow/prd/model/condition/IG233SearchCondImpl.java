/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 自定义流程分派定义表检索条件实现
  * 功能描述: 自定义流程分派定义表检索条件实现
  * 创建记录: 2013/03/12
  * 修改记录: 
  */
public class IG233SearchCondImpl implements IG233SearchCond {

	/** 被分派节点ID */
	protected String psdid;
	
	/** 流程定义主键 */
	protected String pdid;

	/**
	 * 被分派节点id取得
	 * @return 被分派节点id
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 被分派节点id设定
	 * @param psdid 被分派节点id
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程定义主键取得
	 * @return 流程定义主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义主键设定
	 * @param pdid 流程定义主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
}