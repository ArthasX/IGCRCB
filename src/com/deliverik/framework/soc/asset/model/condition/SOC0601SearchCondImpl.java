/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * 机房信息检索条件实现
 * 
 */
public class SOC0601SearchCondImpl implements SOC0601SearchCond {

	/** 机房ID */
	protected String eiid;
	
	/** 关联机房 */
	protected String relateroom;

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 机房ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getRelateroom() {
		return relateroom;
	}

	public void setRelateroom(String relateroom) {
		this.relateroom = relateroom;
	}
}
