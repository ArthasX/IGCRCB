/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;



/**
 * 
 * 库存预警信息视图查询接口实现
 *
 */
public class GstockVWSearchCondImpl implements GstockVWSearchCond {
	
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
	protected Double gprice;
	
	/** 状态（0:停用 1:启用） */
	protected String gstatus;
	

	
	/** 物品库存信息ID */
	protected Integer gsid;
	
	/** 总数量 */
	protected Integer gsnum;
	
	/** 所属机构层次码 */
	protected String gsorg;
	
	/** 采购平均价 */
	protected String gsavgprice;
	
	/** 冻结数量 */
	protected Integer gsfreezenum;
	
	/** 预警查询类型 */
	protected String warntype;
	
	/** 临界数量 */
	protected Integer warnnum;

	
	
	/**
	 * 临界数量取得
	 * @return 临界数量
	 */
	public Integer getWarnnum() {
		return warnnum;
	}



	/**
	 * 临界数量设定
	 * @param warnnum 临界数量
	 */
	public void setWarnnum(Integer warnnum) {
		this.warnnum = warnnum;
	}


	/**
	 * 预警查询类型取得
	 * @return 预警查询类型
	 */
	public String getWarntype() {
		return warntype;
	}


	/**
	 * 预警查询类型设定
	 * @param warntype 预警查询类型
	 */
	public void setWarntype(String warntype) {
		this.warntype = warntype;
	}

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
	public Double getGprice() {
		return gprice;
	}

	/**
	 * 物品内部转移定价（%）设定
	 * @param gprice 物品内部转移定价（%）
	 */
	public void setGprice(Double gprice) {
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


	
	/**
	 * 物品库存信息ID取得
	 * @return 物品库存信息ID
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * 物品库存信息ID
	 * @param gsid 物品库存信息ID
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	
	/**
	 * 总数量取得
	 * @return 总数量
	 */
	public Integer getGsnum() {
		return gsnum;
	}
	/**
	 * 总数量
	 * @param 总数量
	 */
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}
	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGsorg() {
		return gsorg;
	}
	/**
	 * 所属机构层次码
	 * @param 所属机构层次码
	 */
	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}
	/**
	 * 采购平均价取得
	 * @return 采购平均价
	 */
	public String getGsavgprice() {
		return gsavgprice;
	}
	/**
	 * 采购平均价
	 * @param 主采购平均价
	 */
	public void setGsavgprice(String gsavgprice) {
		this.gsavgprice = gsavgprice;
	}
	/**
	 * 冻结数量取得
	 * @return 冻结数量
	 */
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}
	/**
	 * 冻结数量
	 * @param 冻结数量
	 */
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}
}
