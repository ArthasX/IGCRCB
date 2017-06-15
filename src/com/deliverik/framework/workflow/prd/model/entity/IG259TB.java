package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG259Info;


/**
 * 流程模板信息实体
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG259")
public class IG259TB extends BaseEntity implements Serializable, Cloneable, IG259Info {
	/**
	 * 流程模板ID
	 */
	@Id
	@TableGenerator(
		    name="IG259_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG259_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG259_TABLE_GENERATOR")
	protected Integer ptid;

	/**
	 * 流程模板名称
	 */
	protected String ptname;

	/**
	 * 流程模板类型
	 */
	protected String pttype;

	/**
	 * 流程模板发起页URL
	 */
	protected String ptstartpg;

	/**
	 * 流程模板创建时间
	 */
	protected String ptcrtdate;

	/**
	 * 流程模板信息
	 */
	protected String ptpicinfo;

	/**
	 * 流程模板状态（a启用，i停用）
	 */
	protected String ptstatus;
	
	/**
	 * 流程模板查看页URL
	 */
	protected String ptdetailpg;
	
	/**
	 * 通过流程模版所跳转的发起页的URL（平台保留）
	 */
	protected String ptsavepg;

	/**
	 * 流程模板使用位置标识（平台保留）
	 */
	protected String ptqrtzflag;
	
	/** 首位置标识 */
	protected String firstsite;
	
	/** 序列定义 */
	protected String pdsequence;
	
	
	/**
	 * 主键取得
	 * @return ptid
	 */
	public Serializable getPK() {
		return ptid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG259TB))
			return false;
		IG259Info target = (IG259Info) obj;
		if (!(getPtid()==target.getPtid()))
			return false;
		return true;
	}

	/**
	 * 流程模板ID取得
	 * @return 流程模板ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程模板ID设定
	  * @param ptid 流程模板ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * 流程模板名称取得
	 * @return 流程模板名称
	 */
	public String getPtname() {
		return ptname;
	}

	/**
	 * 流程模板名称设定
	  * @param ptname 流程模板名称
	 */
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

	/**
	 * 流程模板类型取得
	 * @return 流程模板类型
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * 流程模板类型设定
	  * @param pttype 流程模板类型
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * 流程模板发起页URL取得
	 * @return 流程模板发起页URL
	 */
	public String getPtstartpg() {
		return ptstartpg;
	}

	/**
	 * 流程模板发起页URL设定
	  * @param ptstartpg 流程模板发起页URL
	 */
	public void setPtstartpg(String ptstartpg) {
		this.ptstartpg = ptstartpg;
	}

	/**
	 * 流程模板创建时间取得
	 * @return 流程模板创建时间
	 */
	public String getPtcrtdate() {
		return ptcrtdate;
	}

	/**
	 * 流程模板创建时间设定
	  * @param ptcrtdate 流程模板创建时间
	 */
	public void setPtcrtdate(String ptcrtdate) {
		this.ptcrtdate = ptcrtdate;
	}

	/**
	 * 流程模板信息取得
	 * @return 流程模板信息
	 */
	public String getPtpicinfo() {
		return ptpicinfo;
	}

	/**
	 * 流程模板信息设定
	  * @param ptpicinfo 流程模板信息
	 */
	public void setPtpicinfo(String ptpicinfo) {
		this.ptpicinfo = ptpicinfo;
	}

	/**
	 * 流程模板状态取得
	 * @return 流程模板状态
	 */
	public String getPtstatus() {
		return ptstatus;
	}

	/**
	 * 流程模板状态设定
	  * @param ptstatus 流程模板状态
	 */
	public void setPtstatus(String ptstatus) {
		this.ptstatus = ptstatus;
	}

	/**
	 * 流程模板查看页URL取得
	 * @return 流程模板查看页URL
	 */
	public String getPtdetailpg() {
		return ptdetailpg;
	}

	/**
	 * 流程模板查看页URL设定
	  * @param ptdetailpg 流程模板查看页URL
	 */
	public void setPtdetailpg(String ptdetailpg) {
		this.ptdetailpg = ptdetailpg;
	}

	/**
	 * 通过流程模版所跳转的发起页的URL（平台保留）取得
	 * @return 通过流程模版所跳转的发起页的URL
	 */
	public String getPtsavepg() {
		return ptsavepg;
	}

	/**
	 * 通过流程模版所跳转的发起页的URL（平台保留）设定
	  * @param pdid 通过流程模版所跳转的发起页的URL
	 */
	public void setPtsavepg(String ptsavepg) {
		this.ptsavepg = ptsavepg;
	}

	/**
	 * 流程模板使用位置标识（平台保留）取得
	 * @return 流程模板使用位置标识
	 */
	public String getPtqrtzflag() {
		return ptqrtzflag;
	}

	/**
	 * 流程模板使用位置标识（平台保留）设定
	  * @param ptqrtzflag 流程模板使用位置标识
	 */
	public void setPtqrtzflag(String ptqrtzflag) {
		this.ptqrtzflag = ptqrtzflag;
	}


	/**
	 * 首位置标识取得
	 * @return firstsite 首位置标识
	 */
	public String getFirstsite() {
		return firstsite;
	}


	/**
	 * 首位置标识设定
	 * @param firstsite 首位置标识
	 */
	public void setFirstsite(String firstsite) {
		this.firstsite = firstsite;
	}


	/**
	 * 序列定义取得
	 * @return pdsequence 序列定义
	 */
	public String getPdsequence() {
		return pdsequence;
	}


	/**
	 * 序列定义设定
	 * @param pdsequence 序列定义
	 */
	public void setPdsequence(String pdsequence) {
		this.pdsequence = pdsequence;
	}
	
}
