/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.Eentertainment;


/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂招待部门汇总详细实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class EEOrgDetail implements Serializable, Cloneable, Eentertainment {
	@Id
	/** 自增无意义主键 */
	protected Integer eeid;
	
	/** 接待工作ID */
	protected Integer rid;
	
	/** 主陪人 */
	protected String eeuser;
	
	/** 每桌菜价格 */
	protected BigDecimal eetableprice;
	
	/** 桌数 */
	protected Integer eetablenum;
	
	/** 酒价 */
	protected BigDecimal eedrinkprice;
	
	/** 烟价 */
	protected BigDecimal eesmokeprice;
	
	/** 其他用品价格 */
	protected BigDecimal eeotherprice;
	protected String rname;
	protected String orgname;
	
	/** 日期 */
	protected String eedate;
	
	//protected RecptionTB recptionTB;

	public Integer getEeid() {
		return eeid;
	}

	public void setEeid(Integer eeid) {
		this.eeid = eeid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getEeuser() {
		return eeuser;
	}

	public void setEeuser(String eeuser) {
		this.eeuser = eeuser;
	}

	public BigDecimal getEetableprice() {
		return eetableprice;
	}

	public void setEetableprice(BigDecimal eetableprice) {
		this.eetableprice = eetableprice;
	}

	public Integer getEetablenum() {
		return eetablenum;
	}

	public void setEetablenum(Integer eetablenum) {
		this.eetablenum = eetablenum;
	}

	public BigDecimal getEedrinkprice() {
		return eedrinkprice;
	}

	public void setEedrinkprice(BigDecimal eedrinkprice) {
		this.eedrinkprice = eedrinkprice;
	}

	public BigDecimal getEesmokeprice() {
		return eesmokeprice;
	}

	public void setEesmokeprice(BigDecimal eesmokeprice) {
		this.eesmokeprice = eesmokeprice;
	}

	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}

	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}

	public String getEedate() {
		return eedate;
	}

	public void setEedate(String eedate) {
		this.eedate = eedate;
	}

//	public RecptionTB getRecptionTB() {
//		return recptionTB;
//	}
//
//	public void setRecptionTB(RecptionTB recptionTB) {
//		this.recptionTB = recptionTB;
//	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public RecptionTB getRecptionTB() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	






}
