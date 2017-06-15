/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.csebank.lom.model.GoutstockVWInfo;

/**
 * 
 * 物品领用信息视图实体
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "GoutstockVW")
@SuppressWarnings("serial")
public class GoutstockVW implements Serializable,GoutstockVWInfo {
	
	/** 物品出库信息ID */
	@Id
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

	/** 出库单价 */
	protected BigDecimal gooutprice;
	
	/** 出库数量 */
	protected Integer goinnum;
	
	/** 计量单位 */
	protected String gounit;
	
	/** 供应商*/
	protected String goprovider;
	
	/** 购买人*/
	protected String gopurchaser;

	/** 调剂价格*/
	protected BigDecimal goreliefprice;
	
	/** 调剂数量*/
	protected Integer goreliefnum;
	
	/** 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)*/
	protected String gostatus;
	
	/** 领用机构/调剂机构层次码*/
	protected String goreqorg;
	
	/** 领用人/调剂人ID*/
	protected String gorequser;
	
	/** 领用人/调剂人姓名*/
	protected String gorequsername;
	
	/** 登记人*/
	protected String gouser;
	
	/** 登记人姓名*/
	protected String gousername;
	
	/** 审批数量*/
	protected Integer gochknum;
	
	/** 审批人ID*/
	protected String gochkid;
	
	/** 审批人姓名*/
	protected String gochkkname;
	
	/** 说明*/
	protected String goreason;
	
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
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return goid;
	}

	/**
	 * 说明取得
	 * @return 说明
	 */
	public String getGoreason() {
		return goreason;
	}


	/**
	 * 说明设定
	 * @param goreason 说明
	 */
	public void setGoreason(String goreason) {
		this.goreason = goreason;
	}


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
	 * 出库单价取得
	 * @return 出库单价
	 */
	public BigDecimal getGooutprice() {
		return gooutprice;
	}




	/**
	 * 出库单价设定
	 * @param gooutprice 出库单价
	 */
	public void setGooutprice(BigDecimal gooutprice) {
		this.gooutprice = gooutprice;
	}




	/**
	 * 出库数量取得
	 * @return 出库数量
	 */
	public Integer getGoinnum() {
		return goinnum;
	}




	/**
	 * 出库数量设定
	 * @param goinnum 出库数量
	 */
	public void setGoinnum(Integer goinnum) {
		this.goinnum = goinnum;
	}



	/**
	 * 计量单位取得
	 * @return 计量单位
	 */
	public String getGounit() {
		return gounit;
	}




	/**
	 * 计量单位设定
	 * @param gounit 计量单位
	 */
	public void setGounit(String gounit) {
		this.gounit = gounit;
	}




	/**
	 * 供应商取得
	 * @return 供应商
	 */
	public String getGoprovider() {
		return goprovider;
	}




	/**
	 * 供应商设定
	 * @param goprovider 供应商
	 */
	public void setGoprovider(String goprovider) {
		this.goprovider = goprovider;
	}




	/**
	 * 购买人取得
	 * @return 购买人
	 */
	public String getGopurchaser() {
		return gopurchaser;
	}




	/**
	 * 购买人设定
	 * @param gopurchaser 购买人
	 */
	public void setGopurchaser(String gopurchaser) {
		this.gopurchaser = gopurchaser;
	}




	/**
	 * 调剂价格取得
	 * @return 调剂价格
	 */
	public BigDecimal getGoreliefprice() {
		return goreliefprice;
	}




	/**
	 * 调剂价格设定
	 * @param goreliefprice 调剂价格
	 */
	public void setGoreliefprice(BigDecimal goreliefprice) {
		this.goreliefprice = goreliefprice;
	}




	/**
	 * 调剂数量取得
	 * @return 调剂数量
	 */
	public Integer getGoreliefnum() {
		return goreliefnum;
	}




	/**
	 * 调剂数量设定
	 * @param goreliefnum 调剂数量
	 */
	public void setGoreliefnum(Integer goreliefnum) {
		this.goreliefnum = goreliefnum;
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
	 * 领用人/调剂人ID取得
	 * @return 领用人/调剂人ID
	 */
	public String getGorequser() {
		return gorequser;
	}




	/**
	 * 领用人/调剂人ID设定
	 * @param gorequser 领用人/调剂人ID
	 */
	public void setGorequser(String gorequser) {
		this.gorequser = gorequser;
	}




	/**
	 * 领用人/调剂人姓名取得
	 * @return 领用人/调剂人姓名
	 */
	public String getGorequsername() {
		return gorequsername;
	}




	/**
	 * 领用人/调剂人姓名设定
	 * @param gorequsername 领用人/调剂人姓名
	 */
	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}




	/**
	 * 登记人取得
	 * @return 登记人
	 */
	public String getGouser() {
		return gouser;
	}




	/**
	 * 登记人设定
	 * @param gouser 登记人
	 */
	public void setGouser(String gouser) {
		this.gouser = gouser;
	}




	/**
	 * 登记人姓名取得
	 * @return 登记人姓名
	 */
	public String getGousername() {
		return gousername;
	}




	/**
	 * 登记人姓名设定
	 * @param gousername 登记人姓名
	 */
	public void setGousername(String gousername) {
		this.gousername = gousername;
	}




	/**
	 * 审批数量取得
	 * @return 审批数量
	 */
	public Integer getGochknum() {
		return gochknum;
	}




	/**
	 * 审批数量设定
	 * @param gochknum 审批数量
	 */
	public void setGochknum(Integer gochknum) {
		this.gochknum = gochknum;
	}




	/**
	 * 审批人ID取得
	 * @return 审批人ID
	 */
	public String getGochkid() {
		return gochkid;
	}




	/**
	 * 审批人ID设定
	 * @param gochkid 审批人ID
	 */
	public void setGochkid(String gochkid) {
		this.gochkid = gochkid;
	}




	/**
	 * 审批人姓名取得
	 * @return 审批人姓名
	 */
	public String getGochkkname() {
		return gochkkname;
	}




	/**
	 * 审批人姓名设定
	 * @param gochkkname 审批人姓名
	 */
	public void setGochkkname(String gochkkname) {
		this.gochkkname = gochkkname;
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
