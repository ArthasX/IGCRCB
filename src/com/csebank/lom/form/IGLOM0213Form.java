/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Ginoutstockdetail;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0213Form extends BaseForm implements Ginoutstockdetail{

	private static final long serialVersionUID = 1L;

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
	
	/** GStock主键 */
	protected Integer gsid;
	
	/** 物品种类 */
	protected String gscategory;
	
	/** 物品名称 */
	protected String gsname;
	
	/** 物品编号 */
	protected String gscode;
	
	/** 总数量 */
	protected Integer gsnum;
	
	/** 所属机构层次码 */
	protected String gsorg;
	
	/** 采购平均价 */
	protected BigDecimal gsavgprice;
	
	/** 冻结数量 */
	protected Integer gsfreezenum;
	
	
	/** 物品种类*/
	protected String[] gcategorys;
	
	/** 物品名称*/
	protected String[] gnames;
	
	/** 物品编号*/
	protected String[] gcodes;
	
	/** 领用数量*/
	protected Integer[] goinnums;

	/** 领用机构层次码 */
	protected String goorg;
	
	/** 领用机构名称*/
	protected String goorgname;
	
	/** 领用人*/
	protected String gorequsername;
	
	/** 采购申请单编号*/
	protected String goreqnum;
	
	/** 接待工作ID*/
	protected Integer rid;
	
	/** 查询类型*/
	protected String warntype;
	
	/** 临界数量*/
	protected Integer warnnum;
	
	
	

	/**
	 * @return the warnnum
	 */
	public Integer getWarnnum() {
		if(warnnum == null){
			return 0;
		}
		return warnnum;
	}

	/**
	 * @param warnnum the warnnum to set
	 */
	public void setWarnnum(Integer warnnum) {
		this.warnnum = warnnum;
	}

	/**
	 * @return the warntype
	 */
	public String getWarntype() {
		return warntype;
	}

	/**
	 * @param warntype the warntype to set
	 */
	public void setWarntype(String warntype) {
		this.warntype = warntype;
	}

	/**
	 * @return the gsid
	 */
	public Integer getGsid() {
		return gsid;
	}

	/**
	 * @param gsid the gsid to set
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}

	/**
	 * @return the gscategory
	 */
	public String getGscategory() {
		return gscategory;
	}

	/**
	 * @param gscategory the gscategory to set
	 */
	public void setGscategory(String gscategory) {
		this.gscategory = gscategory;
	}

	/**
	 * @return the gsname
	 */
	public String getGsname() {
		return gsname;
	}

	/**
	 * @param gsname the gsname to set
	 */
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}

	/**
	 * @return the gscode
	 */
	public String getGscode() {
		return gscode;
	}

	/**
	 * @param gscode the gscode to set
	 */
	public void setGscode(String gscode) {
		this.gscode = gscode;
	}

	/**
	 * @return the gsnum
	 */
	public Integer getGsnum() {
		return gsnum;
	}

	/**
	 * @param gsnum the gsnum to set
	 */
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}

	/**
	 * @return the gsorg
	 */
	public String getGsorg() {
		return gsorg;
	}

	/**
	 * @param gsorg the gsorg to set
	 */
	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}

	/**
	 * @return the gsavgprice
	 */
	public BigDecimal getGsavgprice() {
		return gsavgprice;
	}

	/**
	 * @param gsavgprice the gsavgprice to set
	 */
	public void setGsavgprice(BigDecimal gsavgprice) {
		this.gsavgprice = gsavgprice;
	}

	/**
	 * @return the gsfreezenum
	 */
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}

	/**
	 * @param gsfreezenum the gsfreezenum to set
	 */
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}

	/**
	 * @return the gcategorys
	 */
	public String[] getGcategorys() {
		return gcategorys;
	}

	/**
	 * @param gcategorys the gcategorys to set
	 */
	public void setGcategorys(String[] gcategorys) {
		this.gcategorys = gcategorys;
	}

	/**
	 * @return the gnames
	 */
	public String[] getGnames() {
		return gnames;
	}

	/**
	 * @param gnames the gnames to set
	 */
	public void setGnames(String[] gnames) {
		this.gnames = gnames;
	}

	/**
	 * @return the gcodes
	 */
	public String[] getGcodes() {
		return gcodes;
	}

	/**
	 * @param gcodes the gcodes to set
	 */
	public void setGcodes(String[] gcodes) {
		this.gcodes = gcodes;
	}

	/**
	 * @return the goinnums
	 */
	public Integer[] getGoinnums() {
		return goinnums;
	}

	/**
	 * @param goinnums the goinnums to set
	 */
	public void setGoinnums(Integer[] goinnums) {
		this.goinnums = goinnums;
	}

	/**
	 * @return the goorg
	 */
	public String getGoorg() {
		return goorg;
	}

	/**
	 * @param goorg the goorg to set
	 */
	public void setGoorg(String goorg) {
		this.goorg = goorg;
	}

	/**
	 * @return the goorgname
	 */
	public String getGoorgname() {
		return goorgname;
	}

	/**
	 * @param goorgname the goorgname to set
	 */
	public void setGoorgname(String goorgname) {
		this.goorgname = goorgname;
	}

	/**
	 * @return the gorequsername
	 */
	public String getGorequsername() {
		return gorequsername;
	}

	/**
	 * @param gorequsername the gorequsername to set
	 */
	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}

	/**
	 * @return the goreqnum
	 */
	public String getGoreqnum() {
		return goreqnum;
	}

	/**
	 * @param goreqnum the goreqnum to set
	 */
	public void setGoreqnum(String goreqnum) {
		this.goreqnum = goreqnum;
	}

	/**
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getGiodid() {
		return giodid;
	}

	public String getGiodcode() {
		return giodcode;
	}

	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}

	public String getGiodname() {
		return giodname;
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

	public void setGiodname(String giodname) {
		this.giodname = giodname;
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

	public String getFingerPrint() {
		return null;
	}

	public Integer getGiodhavocnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGiodoutnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGioid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGoid() {
		// TODO Auto-generated method stub
		return null;
	}

}
