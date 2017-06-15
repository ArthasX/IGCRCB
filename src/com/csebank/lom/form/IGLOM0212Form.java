/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.form;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0212Form extends BaseForm implements GoutstockSearchCond,GoutstockVWSearchCond{

	private static final long serialVersionUID = -9166241878591311552L;
	
	protected String gcategory;
	
	protected String gcategoryname;
	
	/**物品出库信息ID */
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
	
	protected Integer[] selectids;
	
	/** 是否有礼品code*/
	protected boolean hascategory;
	
	/** 说明*/
	protected String goreason;
	
	/** 出库类型集合 */
	protected List<String> gotypeList;


	
	
	/** 物品入出库明细信息ID */
	protected Integer giodid;
	
	/** 入出库类型 */
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
	
	/** 入出库状态 */
	protected String giodstatus;

	/** 物品库存信息ID */
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
	 * 物品入出库明细信息ID取得
	 * @return 物品入出库明细信息ID
	 */
	public Integer getGiodid() {
		return giodid;
	}


	/**
	 * 物品入出库明细信息ID设定
	 * @param giodid 物品入出库明细信息ID
	 */
	public void setGiodid(Integer giodid) {
		this.giodid = giodid;
	}

	/**
	 * 入出库类型取得
	 * @return 入出库类型 
	 */
	public String getGiodtype() {
		return giodtype;
	}


	/**
	 * 入出库类型设定
	 * @param giodtype 入出库类型 
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
	 * 入出库状态取得
	 * @return 入出库状态
	 */
	public String getGiodstatus() {
		return giodstatus;
	}

	/**
	 * 入出库状态设定
	 * @param giodstatus 入出库状态
	 */
	public void setGiodstatus(String giodstatus) {
		this.giodstatus = giodstatus;
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

	/**
	 * @return the gotypeList
	 */
	public List<String> getGotypeList() {
		return gotypeList;
	}

	/**
	 * @param gotypeList the gotypeList to set
	 */
	public void setGotypeList(List<String> gotypeList) {
		this.gotypeList = gotypeList;
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
	 * @return the hascategory
	 */
	public boolean isHascategory() {
		return hascategory;
	}
	
	/**
	 * @param hascategory to set
	 */
	public void setHascategory(boolean hascategory) {
		this.hascategory = hascategory;
	}
	public Integer[] getSelectids() {
		return selectids;
	}

	public void setSelectids(Integer[] selectids) {
		this.selectids = selectids;
	}

	public Integer getGoid() {
		return goid;
	}

	public void setGoid(Integer goid) {
		this.goid = goid;
	}

	public String getGotype() {
		return gotype;
	}

	public void setGotype(String gotype) {
		this.gotype = gotype;
	}

	public String getGoorg() {
		return goorg;
	}

	public void setGoorg(String goorg) {
		this.goorg = goorg;
	}

	public String getGocategory() {
		return gocategory;
	}

	public void setGocategory(String gocategory) {
		this.gocategory = gocategory;
	}

	public String getGoname() {
		return goname;
	}

	public void setGoname(String goname) {
		this.goname = goname;
	}

	public String getGocode() {
		return gocode;
	}

	public void setGocode(String gocode) {
		this.gocode = gocode;
	}

	public String getGotime() {
		return gotime;
	}

	public void setGotime(String gotime) {
		this.gotime = gotime;
	}

	public String getGoreqnum() {
		return goreqnum;
	}

	public void setGoreqnum(String goreqnum) {
		this.goreqnum = goreqnum;
	}

	public BigDecimal getGooutprice() {
		return gooutprice;
	}

	public void setGooutprice(BigDecimal gooutprice) {
		this.gooutprice = gooutprice;
	}

	public Integer getGoinnum() {
		return goinnum;
	}

	public void setGoinnum(Integer goinnum) {
		this.goinnum = goinnum;
	}

	public String getGounit() {
		return gounit;
	}

	public void setGounit(String gounit) {
		this.gounit = gounit;
	}

	public String getGoprovider() {
		return goprovider;
	}

	public void setGoprovider(String goprovider) {
		this.goprovider = goprovider;
	}

	public String getGopurchaser() {
		return gopurchaser;
	}

	public void setGopurchaser(String gopurchaser) {
		this.gopurchaser = gopurchaser;
	}

	public BigDecimal getGoreliefprice() {
		return goreliefprice;
	}

	public void setGoreliefprice(BigDecimal goreliefprice) {
		this.goreliefprice = goreliefprice;
	}

	public Integer getGoreliefnum() {
		return goreliefnum;
	}

	public void setGoreliefnum(Integer goreliefnum) {
		this.goreliefnum = goreliefnum;
	}

	public String getGostatus() {
		return gostatus;
	}

	public void setGostatus(String gostatus) {
		this.gostatus = gostatus;
	}

	public String getGoreqorg() {
		return goreqorg;
	}

	public void setGoreqorg(String goreqorg) {
		this.goreqorg = goreqorg;
	}

	public String getGorequser() {
		return gorequser;
	}

	public void setGorequser(String gorequser) {
		this.gorequser = gorequser;
	}

	public String getGorequsername() {
		return gorequsername;
	}

	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}

	public String getGouser() {
		return gouser;
	}

	public void setGouser(String gouser) {
		this.gouser = gouser;
	}

	public String getGousername() {
		return gousername;
	}

	public void setGousername(String gousername) {
		this.gousername = gousername;
	}

	public Integer getGochknum() {
		return gochknum;
	}

	public void setGochknum(Integer gochknum) {
		this.gochknum = gochknum;
	}

	public String getGochkid() {
		return gochkid;
	}

	public void setGochkid(String gochkid) {
		this.gochkid = gochkid;
	}

	public String getGochkkname() {
		return gochkkname;
	}

	public void setGochkkname(String gochkkname) {
		this.gochkkname = gochkkname;
	}

	public String getGotime_f() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGotime_t() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGcategory() {
		return gcategory;
	}

	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}

	public String getGcategoryname() {
		return gcategoryname;
	}

	public void setGcategoryname(String gcategoryname) {
		this.gcategoryname = gcategoryname;
	}

	
	
}
