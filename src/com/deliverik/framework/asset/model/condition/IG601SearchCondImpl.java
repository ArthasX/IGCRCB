package com.deliverik.framework.asset.model.condition;

/**
 * 机房信息检索条件实现
 * 
 */
public class IG601SearchCondImpl implements IG601SearchCond {

	/** 机房ID */
	protected Integer eiid;
	
	/** 关联机房 */
	protected String relateroom;

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 机房ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getRelateroom() {
		return relateroom;
	}

	public void setRelateroom(String relateroom) {
		this.relateroom = relateroom;
	}
}
