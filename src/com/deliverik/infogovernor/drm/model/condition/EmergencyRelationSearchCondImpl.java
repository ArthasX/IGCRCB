/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * 流程关系查询条件实现
 */
public class EmergencyRelationSearchCondImpl implements EmergencyRelationSearchCond {

	/** 主动流程ID */
	protected Integer parprid;

	/** 被动流程ID */
	protected Integer cldprid;
	
	protected String relatetype;
	/** 关联关系 */
	public String getRelatetype() {
		return relatetype;
	}

	public void setRelatetype(String relatetype) {
		this.relatetype = relatetype;
	}

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
