/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;


/**
 * 
 * 接待查询接口实现
 *
 */
public class GoodsSearchCondImpl implements GoodsSearchCond {
	
	/** 物品信息ID */
	protected Integer gid;
	
	/** 物品种类 */
	protected String gcategory;
	
	/** 物品名称 */
	protected String gname;
	
	/** 物品编号 */
	protected String gcode;
	
	/** 预警提示数量 */
	protected Integer gwarningnum;
	
	/** 物品内部转移定价（%） */
	protected BigDecimal gprice;
	
	/** 状态（0:停用 1:启用） */
	protected String gstatus;
	

	/**
	 * 物品信息ID取得
	 * @return 物品信息ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * 物品信息ID设定
	 * @param gid 物品信息ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGcategory() {
		return gcategory;
	}

	/**
	 * 物品种类设定
	 * @param gcategory 物品种类
	 */
	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}

	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGname() {
		return gname;
	}

	/**
	 * 物品名称设定
	 * @param gname 物品名称
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}

	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGcode() {
		return gcode;
	}

	/**
	 * 物品编号设定
	 * @param gcode 物品编号
	 */
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	/**
	 * 预警提示数量取得
	 * @return 预警提示数量
	 */
	public Integer getGwarningnum() {
		return gwarningnum;
	}

	/**
	 * 预警提示数量设定
	 * @param gwarningnum 预警提示数量
	 */
	public void setGwarningnum(Integer gwarningnum) {
		this.gwarningnum = gwarningnum;
	}

	/**
	 * 物品内部转移定价（%）取得
	 * @return 物品内部转移定价（%）
	 */
	public BigDecimal getGprice() {
		return gprice;
	}

	/**
	 * 物品内部转移定价（%）设定
	 * @param gprice 物品内部转移定价（%）
	 */
	public void setGprice(BigDecimal gprice) {
		this.gprice = gprice;
	}

	/**
	 * 状态（0:停用 1:启用）取得
	 * @return 状态（0:停用 1:启用）
	 */
	public String getGstatus() {
		return gstatus;
	}

	/**
	 * 状态（0:停用 1:启用）设定
	 * @param gstatus 状态（0:停用 1:启用）
	 */
	public void setGstatus(String gstatus) {
		this.gstatus = gstatus;
	}

}
