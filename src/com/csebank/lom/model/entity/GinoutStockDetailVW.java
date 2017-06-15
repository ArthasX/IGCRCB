/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.csebank.lom.model.GinoutStockDetailVWInfo;

/**
 * 
 * 物品核销申请信息视图实体
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "GinoutStockDetailVW")
@SuppressWarnings("serial")
public class GinoutStockDetailVW implements Serializable,GinoutStockDetailVWInfo {
	
	/** 物品出库信息ID */
	@Id
	protected Integer giodid;
	
	/** 出库类型(0:入库 1:领用 2:调剂 3:核销) */
	protected String giodtype;
	
	/** 所属机构层次码 */
	protected String giodorg;
	
	/** 物品种类 */
	protected String giodcategory;
	
	/** 物品名称 */
	protected String giodname;
	
	/** 物品编号 */
	protected String giodcode;
	
	/** 入库时间 */
	protected String giodtime;

	/** 采购申请单批号 */
	protected String giodreliefnum;

	/** 入库单价 */
	protected BigDecimal giodhavocnum;
	
	/** 入库数量 */
	protected Integer giodinnum;
	
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
	
	protected Integer giodoutnum;
	
	protected String giodreqnum;
	
	protected String giodunit;
	
	protected BigDecimal giodinprice;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return giodid;
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

	public String getGiodreliefnum() {
		return giodreliefnum;
	}


	public void setGiodreliefnum(String giodreliefnum) {
		this.giodreliefnum = giodreliefnum;
	}


	public BigDecimal getGiodhavocnum() {
		return giodhavocnum;
	}


	public void setGiodhavocnum(BigDecimal giodhavocnum) {
		this.giodhavocnum = giodhavocnum;
	}

	public Integer getGsid() {
		return gsid;
	}


	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}


	public Integer getGsnum() {
		return gsnum;
	}


	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}


	public String getGsorg() {
		return gsorg;
	}


	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}


	public BigDecimal getGsavgprice() {
		return gsavgprice;
	}


	public void setGsavgprice(BigDecimal gsavgprice) {
		this.gsavgprice = gsavgprice;
	}


	public Integer getGsfreezenum() {
		return gsfreezenum;
	}


	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}


	public String getGiodtime() {
		return giodtime;
	}


	public void setGiodtime(String giodtime) {
		this.giodtime = giodtime;
	}


	public Integer getGiodinnum() {
		return giodinnum;
	}


	public void setGiodinnum(Integer giodinnum) {
		this.giodinnum = giodinnum;
	}


	public Integer getGiodoutnum() {
		return giodoutnum;
	}


	public void setGiodoutnum(Integer giodoutnum) {
		this.giodoutnum = giodoutnum;
	}


	public String getGiodreqnum() {
		return giodreqnum;
	}


	public void setGiodreqnum(String giodreqnum) {
		this.giodreqnum = giodreqnum;
	}


	public String getGiodunit() {
		return giodunit;
	}


	public void setGiodunit(String giodunit) {
		this.giodunit = giodunit;
	}


	public BigDecimal getGiodinprice() {
		return giodinprice;
	}


	public void setGiodinprice(BigDecimal giodinprice) {
		this.giodinprice = giodinprice;
	}

}
