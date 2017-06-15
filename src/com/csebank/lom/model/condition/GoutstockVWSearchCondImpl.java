/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;






/**
 * 
 * 物品出库信息视图查询接口实现
 *
 */
public class GoutstockVWSearchCondImpl implements GoutstockVWSearchCond {
	
	/** 物品出库信息ID */
	protected Integer goid;
	
	/** 出库类型(0:入库 1:领用 2:调剂 3:核销) */
	protected String gotype;
	
	
	/** 所属机构层次码 */
	protected String goorg;
	
	/** 物品种类 */
	protected String gocategory;
	
	/** 物品名称 */
	protected String goname;
	
	/** 物品编号 */
	protected String gocode;
	
	/** 出库时间 */
	protected String gotime;

	/** 采购申请单批号 */
	protected String goreqnum;
	
	/** 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)*/
	protected String gostatus;
	
	/** 领用机构/调剂机构层次码*/
	protected String goreqorg;
	
	/** GStock主键 */
	protected Integer gsid;
	
	/** 总数量 */
	protected Integer gsnum;
	
	/** 所属机构层次码 */
	protected String gsorg;
	
	/** 采购平均价 */
	protected BigDecimal gsavgprice;
	
	/** 冻结数量 */
	protected Integer gsfreezenum;
	

	/**
	 *物品出库信息ID取得
	 * @return 物品出库信息ID
	 */
	public Integer getGoid() {
		return goid;
	}




	/**
	 *物品出库信息ID设定
	 * @param godid物品出库信息ID
	 */
	public void setGoid(Integer goid) {
		this.goid = goid;
	}




	/**
	 * 出库类型(0:入库 1:领用 2:调剂 3:核销)取得
	 * @return 出库类型(0:入库 1:领用 2:调剂 3:核销)
	 */
	public String getGotype() {
		return gotype;
	}




	/**
	 * 出库类型(0:入库 1:领用 2:调剂 3:核销)设定
	 * @param godtype 出库类型(0:入库 1:领用 2:调剂 3:核销)
	 */
	public void setGotype(String gotype) {
		this.gotype = gotype;
	}



	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGoorg() {
		return goorg;
	}




	/**
	 * 所属机构层次码设定
	 * @param goorg 所属机构层次码
	 */
	public void setGoorg(String goorg) {
		this.goorg = goorg;
	}




	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGocategory() {
		return gocategory;
	}




	/**
	 * 物品种类设定
	 * @param gocategory 物品种类
	 */
	public void setGocategory(String gocategory) {
		this.gocategory = gocategory;
	}




	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGoname() {
		return goname;
	}




	/**
	 * 物品名称设定
	 * @param goname 物品名称
	 */
	public void setGoname(String goname) {
		this.goname = goname;
	}




	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGocode() {
		return gocode;
	}




	/**
	 * 物品编号设定
	 * @param godcode 物品编号
	 */
	public void setGocode(String gocode) {
		this.gocode = gocode;
	}




	/**
	 * 出库时间取得
	 * @return 出库时间
	 */
	public String getGotime() {
		return gotime;
	}




	/**
	 * 出库时间设定
	 * @param godtime 出库时间
	 */
	public void setGotime(String gotime) {
		this.gotime = gotime;
	}




	/**
	 * 采购申请单批号取得
	 * @return 采购申请单批号
	 */
	public String getGoreqnum() {
		return goreqnum;
	}




	/**
	 * 采购申请单批号设定
	 * @param goreqnum 采购申请单批号
	 */
	public void setGoreqnum(String goreqnum) {
		this.goreqnum = goreqnum;
	}

	/**
	 * 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)取得
	 * @return 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)
	 */
	public String getGostatus() {
		return gostatus;
	}




	/**
	 * 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)设定
	 * @param gostatus 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)
	 */
	public void setGostatus(String gostatus) {
		this.gostatus = gostatus;
	}




	/**
	 * 领用机构/调剂机构层次码取得
	 * @return 领用机构/调剂机构层次码
	 */
	public String getGoreqorg() {
		return goreqorg;
	}




	/**
	 * 领用机构/调剂机构层次码设定
	 * @param goreqorg 领用机构/调剂机构层次码
	 */
	public void setGoreqorg(String goreqorg) {
		this.goreqorg = goreqorg;
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
	public BigDecimal getGsavgprice() {
		return gsavgprice;
	}
	/**
	 * 采购平均价
	 * @param 主采购平均价
	 */
	public void setGsavgprice(BigDecimal gsavgprice) {
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
