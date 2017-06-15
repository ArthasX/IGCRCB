/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Goods;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 接待工作登记变更Form
 * 
 */
public class IGLOM0201Form extends BaseForm implements Goods{

	private static final long serialVersionUID = 1L;
	/** 物品信息ID */
	protected Integer gid;
	
	/** 物品种类 */ 
	protected String gcategory;
	
	/** 物品种类名称 */
	protected String gcategoryname;
	
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
	
	/** 接待工作ID*/
	protected Integer rid;
	
	/** 主键*/
	protected Integer[] gids;
	
	/** 物品种类*/
	protected String[] gcategorys;
	
	/** 物品名称*/
	protected String[] gnames;
	
	/** 物品编号*/
	protected String[] gcodes;
	
	/** 预警提示数量*/
	protected Integer[] gwarningnums;
	
	/** 物品内部转移定价（%）*/
	protected BigDecimal[] gprices;
	
	/** 状态（0:停用 1:启用）*/
	protected String[] gstatuss;
	
	/** 单位 */
	protected String gunit;
	
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
	
	protected String mode;
	
	/** 原因 */
	protected String greason;
	
	
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
	 * @return the gids
	 */
	public Integer[] getGids() {
		return gids;
	}

	/**
	 * @param gids the gids to set
	 */
	public void setGids(Integer[] gids) {
		this.gids = gids;
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
	 * @return the gwarningnums
	 */
	public Integer[] getGwarningnums() {
		return gwarningnums;
	}

	/**
	 * @param gwarningnums the gwarningnums to set
	 */
	public void setGwarningnums(Integer[] gwarningnums) {
		this.gwarningnums = gwarningnums;
	}

	/**
	 * @return the gprices
	 */
	public BigDecimal[] getGprices() {
		return gprices;
	}

	/**
	 * @param gprices the gprices to set
	 */
	public void setGprices(BigDecimal[] gprices) {
		this.gprices = gprices;
	}

	/**
	 * @return the gstatuss
	 */
	public String[] getGstatuss() {
		return gstatuss;
	}

	/**
	 * @param gstatuss the gstatuss to set
	 */
	public void setGstatuss(String[] gstatuss) {
		this.gstatuss = gstatuss;
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

	public String getFingerPrint() {
		return null;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getGunit() {
		return gunit;
	}

	public void setGunit(String gunit) {
		this.gunit = gunit;
	}

	public String getGcategoryname() {
		return gcategoryname;
	}

	public void setGcategoryname(String gcategoryname) {
		this.gcategoryname = gcategoryname;
	}

	public String getGreason() {
		return greason;
	}

	public void setGreason(String greason) {
		this.greason = greason;
	}

	
}
