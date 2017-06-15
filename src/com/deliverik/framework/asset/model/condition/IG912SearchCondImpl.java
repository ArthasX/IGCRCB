package com.deliverik.framework.asset.model.condition;

/**
 * 设备资产信息检索条件实现
 * 
 */
public class IG912SearchCondImpl implements IG912SearchCond {

	/** 设备资产ID */
	protected Integer eiid;
	
	/** 机柜ID */
	protected Integer container_eiid;
	
	/** 设备资产编号 */
	protected String eilabel;
	
	/** 设备资产名称 */
	protected String einame;
	
	/** 设备资产高度（U） */
	protected String u_total;
	
	/** 是否已经上架 */
	protected String inJiguiFlg;
	
	/** 设备层次码 */
	protected String esyscoding;
	
	/** 是否是机房设备 */
	protected String inroomFlg;
	
	/** 设备状态 */
	protected String[] eiStatuses;
	
	/**
	 * 设备资产ID取得
	 * @return 设备资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设备资产ID设定
	 *
	 * @param eiid 设备资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public Integer getContainer_eiid() {
		return container_eiid;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param container_eiid 机柜ID
	 */
	public void setContainer_eiid(int container_eiid) {
		this.container_eiid = container_eiid;
	}

	/**
	 * 设备资产编号取得
	 * @return 设备资产编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 设备资产编号设定
	 *
	 * @param eilabel 设备资产编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 设备资产名称取得
	 * @return 设备资产名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设备资产名称设定
	 *
	 * @param einame 设备资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 设备资产高度（U）取得
	 * @return 设备资产高度（U）
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * 设备资产高度（U）设定
	 *
	 * @param u_total 设备资产高度（U）
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}
	
	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getInJiguiFlg() {
		return inJiguiFlg;
	}

	public void setInJiguiFlg(String inJiguiFlg) {
		this.inJiguiFlg = inJiguiFlg;
	}
	/**
	 * 是否是机房设备标志位取得
	 * @return 是否是机房设备标志位
	 */
	public String getInroomFlg() {
		return inroomFlg;
	}
	
	/**
	 * 是否是机房设备标志位设定
	 *
	 * @param esyscoding 是否是机房设备标志位
	 */
	public void setInroomFlg(String inroomFlg) {
		this.inroomFlg = inroomFlg;
	}

	/**
	 * @return 设备状态
	 */
	public String[] getEiStatuses() {
		return eiStatuses;
	}

	/**
	 * @param 设备状态
	 */
	public void setEiStatuses(String[] eiStatuses) {
		this.eiStatuses = eiStatuses;
	}

}
