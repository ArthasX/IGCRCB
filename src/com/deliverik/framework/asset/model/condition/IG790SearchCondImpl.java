package com.deliverik.framework.asset.model.condition;

/**
 * 机房机柜统计分析信息检索条件实现
 * 
 */
public class IG790SearchCondImpl implements IG790SearchCond {

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
