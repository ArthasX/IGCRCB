/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * 机房机柜统计分析信息检索条件实现
 * 
 */
public class SOC0604SearchCondImpl implements SOC0604SearchCond {

	/** 机房ID */
	protected Integer roomeiid_q;

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getRoomeiid_q() {
		return roomeiid_q;
	}

	/**
	 * 机房ID设定
	 *
	 * @param room_eiid 机房ID
	 */
	public void setRoomeiid_q(Integer roomeiid_q) {
		this.roomeiid_q = roomeiid_q;
	}

	

}
