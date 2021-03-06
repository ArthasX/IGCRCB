/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0211Form extends BaseForm implements GinoutstockdetailSearchCond{

	private static final long serialVersionUID = -9166241878591311552L;
	
	/** 物品入出库明细信息ID */
	protected Integer giodid;
	
	/** 入出库类型(0:入库 1:领用 2:调剂 3:核销) */
	protected String giodtype;
	
	/** 所属机构层次码 */
	protected String giodorg;
	
	/** 物品种类 */
	protected String giodcategory;
	
	/** 物品种类名称 */
	protected String giodcategoryname;
	
	
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

	/** 出库单价 */
	protected BigDecimal giodoutprice;
	
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
	
	protected Integer[] selectids;
	protected Integer[] giodhavocnums;
	
	/** 说明*/
	protected String[] goreasons;
	
	/** 说明*/
	protected String goreason;
	
	

	
	/**
	 * @return the goreason
	 */
	public String getGoreason() {
		return goreason;
	}

	/**
	 * @param goreason the goreason to set
	 */
	public void setGoreason(String goreason) {
		this.goreason = goreason;
	}

	/**
	 * @return the goreasons
	 */
	public String[] getGoreasons() {
		return goreasons;
	}

	/**
	 * @param goreasons the goreasons to set
	 */
	public void setGoreasons(String[] goreasons) {
		this.goreasons = goreasons;
	}
	
	public Integer[] getSelectids() {
		return selectids;
	}
	public void setSelectids(Integer[] selectids) {
		this.selectids = selectids;
	}

	public Integer[] getGiodhavocnums() {
		return giodhavocnums;
	}
	public void setGiodhavocnums(Integer[] giodhavocnums) {
		this.giodhavocnums = giodhavocnums;
	}
	public Integer getGiodid() {
		return giodid;
	}
	public void setGiodid(Integer giodid) {
		this.giodid = giodid;
	}
	public String getGiodtype() {
		return giodtype;
	}
	public void setGiodtype(String giodtype) {
		this.giodtype = giodtype;
	}
	public String getGiodorg() {
		return giodorg;
	}
	public void setGiodorg(String giodorg) {
		this.giodorg = giodorg;
	}
	public String getGiodcategory() {
		return giodcategory;
	}
	public void setGiodcategory(String giodcategory) {
		this.giodcategory = giodcategory;
	}
	public String getGiodname() {
		return giodname;
	}
	public void setGiodname(String giodname) {
		this.giodname = giodname;
	}
	public String getGiodcode() {
		return giodcode;
	}
	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}
	public String getGiodtime() {
		return giodtime;
	}
	public void setGiodtime(String giodtime) {
		this.giodtime = giodtime;
	}
	public String getGiodreqnum() {
		return giodreqnum;
	}
	public void setGiodreqnum(String giodreqnum) {
		this.giodreqnum = giodreqnum;
	}
	public BigDecimal getGiodinprice() {
		return giodinprice;
	}
	public void setGiodinprice(BigDecimal giodinprice) {
		this.giodinprice = giodinprice;
	}
	public BigDecimal getGiodoutprice() {
		return giodoutprice;
	}
	public void setGiodoutprice(BigDecimal giodoutprice) {
		this.giodoutprice = giodoutprice;
	}
	public Integer getGiodinnum() {
		return giodinnum;
	}
	public void setGiodinnum(Integer giodinnum) {
		this.giodinnum = giodinnum;
	}
	public String getGiodunit() {
		return giodunit;
	}
	public void setGiodunit(String giodunit) {
		this.giodunit = giodunit;
	}
	public String getGiodprovider() {
		return giodprovider;
	}
	public void setGiodprovider(String giodprovider) {
		this.giodprovider = giodprovider;
	}
	public String getGiodpurchaser() {
		return giodpurchaser;
	}
	public void setGiodpurchaser(String giodpurchaser) {
		this.giodpurchaser = giodpurchaser;
	}
	public BigDecimal getGiodreliefprice() {
		return giodreliefprice;
	}
	public void setGiodreliefprice(BigDecimal giodreliefprice) {
		this.giodreliefprice = giodreliefprice;
	}
	public Integer getGiodreliefnum() {
		return giodreliefnum;
	}
	public void setGiodreliefnum(Integer giodreliefnum) {
		this.giodreliefnum = giodreliefnum;
	}
	public String getGiodstatus() {
		return giodstatus;
	}
	public void setGiodstatus(String giodstatus) {
		this.giodstatus = giodstatus;
	}
	public String getGiodreqorg() {
		return giodreqorg;
	}
	public void setGiodreqorg(String giodreqorg) {
		this.giodreqorg = giodreqorg;
	}
	public String getGiodrequser() {
		return giodrequser;
	}
	public void setGiodrequser(String giodrequser) {
		this.giodrequser = giodrequser;
	}
	public String getGiodrequsername() {
		return giodrequsername;
	}
	public void setGiodrequsername(String giodrequsername) {
		this.giodrequsername = giodrequsername;
	}
	public String getGioduser() {
		return gioduser;
	}
	public void setGioduser(String gioduser) {
		this.gioduser = gioduser;
	}
	public String getGiodusername() {
		return giodusername;
	}
	public void setGiodusername(String giodusername) {
		this.giodusername = giodusername;
	}
	public Integer getGiodchknum() {
		return giodchknum;
	}
	public void setGiodchknum(Integer giodchknum) {
		this.giodchknum = giodchknum;
	}
	public String getGiodchkid() {
		return giodchkid;
	}
	public void setGiodchkid(String giodchkid) {
		this.giodchkid = giodchkid;
	}
	public String getGiodchkkname() {
		return giodchkkname;
	}
	public void setGiodchkkname(String giodchkkname) {
		this.giodchkkname = giodchkkname;
	}
	public Integer getGoid() {
		return goid;
	}
	public void setGoid(Integer goid) {
		this.goid = goid;
	}
	public Integer getGioid() {
		return gioid;
	}
	public void setGioid(Integer gioid) {
		this.gioid = gioid;
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
	public String getGiodoutype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodcategoryname() {
		return giodcategoryname;
	}

	public void setGiodcategoryname(String giodcategoryname) {
		this.giodcategoryname = giodcategoryname;
	}

	
	
}
