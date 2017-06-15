/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;



/**
 * 
 * 物品入出库明细信息查询接口实现
 *
 */
public class GinoutstockdetailSearchCondImpl implements GinoutstockdetailSearchCond {
	
	/** 物品入出库明细信息ID */
	protected Integer giodid;
	
	/** 入出库类型(0:入库 1:领用 2:调剂 3:核销) */
	protected String giodtype;
	
	/** 所属机构层次码 */
	protected String giodorg;
	
	/** 物品种类 */
	protected String giodcategory;
	
	/** 物品名称 */
	protected String giodname;
	
	/** 物品编号 */
	protected String giodcode;
	
	/** 入出库时间 */
	protected String giodtime;

	/** 采购申请单批号 */
	protected String giodreqnum;

	/** 入库单价 */
	protected BigDecimal giodinprice;

//	/** 出库单价 */
//	protected BigDecimal giodoutprice;
	
	/** 入出库数量 */
	protected Integer giodinnum;
	
	/** 计量单位 */
	protected String giodunit;
	
	/** 供应商*/
	protected String giodprovider;
	
	/** 购买人*/
	protected String giodpurchaser;

	/** 调剂价格*/
	protected BigDecimal giodreliefprice;
	
	/** 调剂数量*/
	protected Integer giodreliefnum;
	
	/** 入出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)*/
	protected String giodstatus;
	
	/** 领用机构/调剂机构层次码*/
	protected String giodreqorg;
	
	/** 领用人/调剂人ID*/
	protected String giodrequser;
	
	/** 领用人/调剂人姓名*/
	protected String giodrequsername;
	
	/** 登记人*/
	protected String gioduser;
	
	/** 登记人姓名*/
	protected String giodusername;
	
	/** 审批数量*/
	protected Integer giodchknum;
	
	/** 审批人ID*/
	protected String giodchkid;
	
	/** 审批人姓名*/
	protected String giodchkkname;
	
	/**物品出库信息ID */
	protected Integer goid;

	/** 物品入库记录ID */
	protected Integer gioid;
	/** 入出库时间 */
	protected String giotime_f;
	/** 入出库时间 */
	protected String giotime_t;
	
	protected String giodoutype;
	
	public String getGiodoutype() {
		return giodoutype;
	}


	public void setGiodoutype(String giodoutype) {
		this.giodoutype = giodoutype;
	}


	public String getGiotime_f() {
		return giotime_f;
	}


	public void setGiotime_f(String giotime_f) {
		this.giotime_f = giotime_f;
	}


	public String getGiotime_t() {
		return giotime_t;
	}


	public void setGiotime_t(String giotime_t) {
		this.giotime_t = giotime_t;
	}


	/**
	 * 物品入出库明细信息ID取得
	 * @return 物品入出库明细信息ID
	 */
	public Integer getGiodid() {
		return giodid;
	}


	/**
	 * 物品入库记录ID取得
	 * @return 物品入库记录ID
	 */
	public Integer getGioid() {
		return gioid;
	}




	/**
	 * 物品入库记录ID设定
	 * @param gioid 物品入库记录ID
	 */
	public void setGioid(Integer gioid) {
		this.gioid = gioid;
	}


	/**
	 * 物品入出库明细信息ID设定
	 * @param giodid 物品入出库明细信息ID
	 */
	public void setGiodid(Integer giodid) {
		this.giodid = giodid;
	}




	/**
	 * 入出库类型(0:入库 1:领用 2:调剂 3:核销)取得
	 * @return 入出库类型(0:入库 1:领用 2:调剂 3:核销)
	 */
	public String getGiodtype() {
		return giodtype;
	}




	/**
	 * 入出库类型(0:入库 1:领用 2:调剂 3:核销)设定
	 * @param giodtype 入出库类型(0:入库 1:领用 2:调剂 3:核销)
	 */
	public void setGiodtype(String giodtype) {
		this.giodtype = giodtype;
	}




	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGiodorg() {
		return giodorg;
	}




	/**
	 * 所属机构层次码设定
	 * @param giodorg 所属机构层次码
	 */
	public void setGiodorg(String giodorg) {
		this.giodorg = giodorg;
	}




	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGiodcategory() {
		return giodcategory;
	}




	/**
	 * 物品种类设定
	 * @param giodcategory 物品种类
	 */
	public void setGiodcategory(String giodcategory) {
		this.giodcategory = giodcategory;
	}




	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGiodname() {
		return giodname;
	}




	/**
	 * 物品名称设定
	 * @param giodname 物品名称
	 */
	public void setGiodname(String giodname) {
		this.giodname = giodname;
	}




	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGiodcode() {
		return giodcode;
	}




	/**
	 * 物品编号设定
	 * @param giodcode 物品编号
	 */
	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}




	/**
	 * 入出库时间取得
	 * @return 入出库时间
	 */
	public String getGiodtime() {
		return giodtime;
	}




	/**
	 * 入出库时间设定
	 * @param giodtime 入出库时间
	 */
	public void setGiodtime(String giodtime) {
		this.giodtime = giodtime;
	}




	/**
	 * 采购申请单批号取得
	 * @return 采购申请单批号
	 */
	public String getGiodreqnum() {
		return giodreqnum;
	}




	/**
	 * 采购申请单批号设定
	 * @param giodreqnum 采购申请单批号
	 */
	public void setGiodreqnum(String giodreqnum) {
		this.giodreqnum = giodreqnum;
	}




	/**
	 * 入库单价取得
	 * @return 入库单价
	 */
	public BigDecimal getGiodinprice() {
		return giodinprice;
	}




	/**
	 * 入库单价设定
	 * @param giodinprice 入库单价
	 */
	public void setGiodinprice(BigDecimal giodinprice) {
		this.giodinprice = giodinprice;
	}




//	/**
//	 * 出库单价取得
//	 * @return 出库单价
//	 */
//	public BigDecimal getGiodoutprice() {
//		return giodoutprice;
//	}
//
//
//
//
//	/**
//	 * 出库单价设定
//	 * @param giodoutprice 出库单价
//	 */
//	public void setGiodoutprice(BigDecimal giodoutprice) {
//		this.giodoutprice = giodoutprice;
//	}




	/**
	 * 入出库数量取得
	 * @return 入出库数量
	 */
	public Integer getGiodinnum() {
		return giodinnum;
	}




	/**
	 * 入出库数量设定
	 * @param giodinnum 入出库数量
	 */
	public void setGiodinnum(Integer giodinnum) {
		this.giodinnum = giodinnum;
	}



	/**
	 * 计量单位取得
	 * @return 计量单位
	 */
	public String getGiodunit() {
		return giodunit;
	}




	/**
	 * 计量单位设定
	 * @param giodunit 计量单位
	 */
	public void setGiodunit(String giodunit) {
		this.giodunit = giodunit;
	}




	/**
	 * 供应商取得
	 * @return 供应商
	 */
	public String getGiodprovider() {
		return giodprovider;
	}




	/**
	 * 供应商设定
	 * @param giodprovider 供应商
	 */
	public void setGiodprovider(String giodprovider) {
		this.giodprovider = giodprovider;
	}




	/**
	 * 购买人取得
	 * @return 购买人
	 */
	public String getGiodpurchaser() {
		return giodpurchaser;
	}




	/**
	 * 购买人设定
	 * @param giodpurchaser 购买人
	 */
	public void setGiodpurchaser(String giodpurchaser) {
		this.giodpurchaser = giodpurchaser;
	}




	/**
	 * 调剂价格取得
	 * @return 调剂价格
	 */
	public BigDecimal getGiodreliefprice() {
		return giodreliefprice;
	}




	/**
	 * 调剂价格设定
	 * @param giodreliefprice 调剂价格
	 */
	public void setGiodreliefprice(BigDecimal giodreliefprice) {
		this.giodreliefprice = giodreliefprice;
	}




	/**
	 * 调剂数量取得
	 * @return 调剂数量
	 */
	public Integer getGiodreliefnum() {
		return giodreliefnum;
	}




	/**
	 * 调剂数量设定
	 * @param giodreliefnum 调剂数量
	 */
	public void setGiodreliefnum(Integer giodreliefnum) {
		this.giodreliefnum = giodreliefnum;
	}




	/**
	 * 入出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)取得
	 * @return 入出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)
	 */
	public String getGiodstatus() {
		return giodstatus;
	}




	/**
	 * 入出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)设定
	 * @param giodstatus 入出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)
	 */
	public void setGiodstatus(String giodstatus) {
		this.giodstatus = giodstatus;
	}




	/**
	 * 领用机构/调剂机构层次码取得
	 * @return 领用机构/调剂机构层次码
	 */
	public String getGiodreqorg() {
		return giodreqorg;
	}




	/**
	 * 领用机构/调剂机构层次码设定
	 * @param giodstatus 领用机构/调剂机构层次码
	 */
	public void setGiodreqorg(String giodreqorg) {
		this.giodreqorg = giodreqorg;
	}




	/**
	 * 领用人/调剂人ID取得
	 * @return 领用人/调剂人ID
	 */
	public String getGiodrequser() {
		return giodrequser;
	}




	/**
	 * 领用人/调剂人ID设定
	 * @param giodrequser 领用人/调剂人ID
	 */
	public void setGiodrequser(String giodrequser) {
		this.giodrequser = giodrequser;
	}




	/**
	 * 领用人/调剂人姓名取得
	 * @return 领用人/调剂人姓名
	 */
	public String getGiodrequsername() {
		return giodrequsername;
	}




	/**
	 * 领用人/调剂人姓名设定
	 * @param giodrequsername 领用人/调剂人姓名
	 */
	public void setGiodrequsername(String giodrequsername) {
		this.giodrequsername = giodrequsername;
	}




	/**
	 * 登记人取得
	 * @return 登记人
	 */
	public String getGioduser() {
		return gioduser;
	}




	/**
	 * 登记人设定
	 * @param gioduser 登记人
	 */
	public void setGioduser(String gioduser) {
		this.gioduser = gioduser;
	}




	/**
	 * 登记人姓名取得
	 * @return 登记人姓名
	 */
	public String getGiodusername() {
		return giodusername;
	}




	/**
	 * 登记人姓名设定
	 * @param giodusername 登记人姓名
	 */
	public void setGiodusername(String giodusername) {
		this.giodusername = giodusername;
	}




	/**
	 * 审批数量取得
	 * @return 审批数量
	 */
	public Integer getGiodchknum() {
		return giodchknum;
	}




	/**
	 * 审批数量设定
	 * @param giodchknum 审批数量
	 */
	public void setGiodchknum(Integer giodchknum) {
		this.giodchknum = giodchknum;
	}




	/**
	 * 审批人ID取得
	 * @return 审批人ID
	 */
	public String getGiodchkid() {
		return giodchkid;
	}




	/**
	 * 审批人ID设定
	 * @param giodchkid 审批人ID
	 */
	public void setGiodchkid(String giodchkid) {
		this.giodchkid = giodchkid;
	}




	/**
	 * 审批人姓名取得
	 * @return 审批人姓名
	 */
	public String getGiodchkkname() {
		return giodchkkname;
	}




	/**
	 * 审批人姓名设定
	 * @param giodchkkname 审批人姓名
	 */
	public void setGiodchkkname(String giodchkkname) {
		this.giodchkkname = giodchkkname;
	}
	
	/**
	 * 物品出库信息ID取得
	 * @return 物品出库信息ID
	 */
	public Integer getGoid() {
		return goid;
	}




	/**
	 * 物品出库信息ID设定
	 * @param goid 物品出库信息ID
	 */
	public void setGoid(Integer goid) {
		this.goid = goid;
	}

}
