/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 流程关系查询条件实现
 */
public class IG512SearchCondImpl implements IG512SearchCond {

	/** 主动流程ID */
	protected Integer parprid;

	/** 被动流程ID */
	protected Integer cldprid;
	
	/**
	 * 主动流程ID取得
	 * 
	 * @return 主动流程ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * 主动流程ID取得
	 * 
	 * @param parprid 主动流程ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * 被动流程ID取得
	 * 
	 * @return 被动流程ID
	 */
	public Integer getCldprid() {
		return cldprid;
	}

	/**
	 * 被动流程ID取得
	 * 
	 * @param cldprid 被动流程ID
	 */
	public void setCldprid(Integer cldprid) {
		this.cldprid = cldprid;
	}

}
