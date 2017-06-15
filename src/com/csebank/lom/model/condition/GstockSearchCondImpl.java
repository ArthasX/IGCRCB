/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 物品查询接口实现
 *
 */
public class GstockSearchCondImpl implements GstockSearchCond {
	
	/** GStock主键 */
	protected Integer gsid;
	
	/** 物品种类 */
	protected String gscategory;
	
	/** 物品名称 */
	protected String gsname;
	
	/** 物品编号 */
	protected String gscode;

	/** 所属机构层次码 */
	protected String gsorg;
	
	
	
	/** 总数量 */
	protected Integer gsnum;
	
	/** 采购平均价 */
	protected String gsavgprice;
	/** 冻结数量 */
	protected Integer gsfreezenum;
	/** 最后一次更新人ID */
	protected String gsuserid;
	/** 最后一次更新人姓名 */
	protected String gsusername;
	/** 最后一次更新时间 */
	protected String gsdate;
	
	/** 预警数量 */
	protected String wnum;
	
	
	/**
	 * @return the wnum
	 */
	public String getWnum() {
		return wnum;
	}
	/**
	 * @param wnum the wnum to set
	 */
	public void setWnum(String wnum) {
		this.wnum = wnum;
	}
	public Integer getGsnum() {
		return gsnum;
	}
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}
	
	public String getGsavgprice() {
		return gsavgprice;
	}
	public void setGsavgprice(String gsavgprice) {
		this.gsavgprice = gsavgprice;
	}
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}
	public String getGsuserid() {
		return gsuserid;
	}
	public void setGsuserid(String gsuserid) {
		this.gsuserid = gsuserid;
	}
	public String getGsusername() {
		return gsusername;
	}
	public void setGsusername(String gsusername) {
		this.gsusername = gsusername;
	}
	public String getGsdate() {
		return gsdate;
	}
	public void setGsdate(String gsdate) {
		this.gsdate = gsdate;
	}
	
	

	/**
	 * 主键ID取得
	 * @return 主键ID
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * 主键ID
	 * @param gsid 主键ID
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGscategory() {
		return gscategory;
	}
	/**
	 * 物品种类
	 * @param 物品种类
	 */
	public void setGscategory(String gscategory) {
		this.gscategory = gscategory;
	}
	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGsname() {
		return gsname;
	}
	/**
	 * 物品名称
	 * @param 物品名称
	 */
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}
	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGscode() {
		return gscode;
	}
	/**
	 * 物品编号
	 * @param 物品编号
	 */
	public void setGscode(String gscode) {
		this.gscode = gscode;
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

}
