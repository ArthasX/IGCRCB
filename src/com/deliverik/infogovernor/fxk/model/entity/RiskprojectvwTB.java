/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;

/**
  * 概述: 风险计划查询实体
  * 功能描述: 风险计划查询实体
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="riskprojectvw")
public class RiskprojectvwTB extends BaseEntity implements Serializable,
		Cloneable, RiskprojectvwInfo {

	/** 流程记录ID */
	@Id
	protected Integer prid ;

	/** 流程记录状态 */
	protected String prstatus;

	/** 流程记录题目 */
	protected String prtitle ;

	/** 流程记录建立时间 */
	protected String propentime;

	/** 流程记录计划执行时间 */
	protected String prplantime;

	/** 流程记录发起者角色名称 */
	protected String prrolename;

	/** 流程记录工单号 */
	protected String prserialnum;

	/** 风险计划类型 */
	protected String risktype;

	/** 流程记录发起者所属机构名称 */
	protected String prorgname;

	/** 计划完成情况 */
	protected String riskcompletion;

//	/** 风险计划状态 */
//	protected String riskstatus;

	/** 流程记录发起者所属机构层次码 */
	protected String prorgid;

	/** 流程记录描述 */
	protected String prdesc;

	/** 风险编号 */
	protected String risknum;

	/** 流程记录流程类型名称 */
	protected String prpdname;

	/** 流程记录流程类型ID */
	protected String prpdid;

	/** 流程记录发起者角色ID */
	protected String prroleid;

	/** 流程记录发起者用户姓名 */
	protected String prusername;

	/** 流程记录发起者用户ID */
	protected String pruserid;

	/** 流程记录关闭时间 */
	protected String prclosetime;
	/**计划开始时间*/
	protected String riskstart;
	/**计划结束时间*/
	protected String riskend;

	
	public String getRiskstart() {
        return riskstart;
    }

    public void setRiskstart(String riskstart) {
        this.riskstart = riskstart;
    }

    public String getRiskend() {
        return riskend;
    }

    public void setRiskend(String riskend) {
        this.riskend = riskend;
    }

    /**
	 * 流程记录ID取得
	 *
	 * @return 流程记录ID
	 */
	public Integer getPrid () {
		return prid ;
	}

	/**
	 * 流程记录ID设定
	 *
	 * @param prid  流程记录ID
	 */
	public void setPrid (Integer prid ) {
		this.prid  = prid ;
	}

	/**
	 * 流程记录状态取得
	 *
	 * @return 流程记录状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程记录状态设定
	 *
	 * @param prstatus 流程记录状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 流程记录题目取得
	 *
	 * @return 流程记录题目
	 */
	public String getPrtitle () {
		return prtitle ;
	}

	/**
	 * 流程记录题目设定
	 *
	 * @param prtitle  流程记录题目
	 */
	public void setPrtitle (String prtitle ) {
		this.prtitle  = prtitle ;
	}

	/**
	 * 流程记录建立时间取得
	 *
	 * @return 流程记录建立时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 流程记录建立时间设定
	 *
	 * @param propentime 流程记录建立时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 流程记录计划执行时间取得
	 *
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * 流程记录计划执行时间设定
	 *
	 * @param prplantime 流程记录计划执行时间
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * 流程记录发起者角色名称取得
	 *
	 * @return 流程记录发起者角色名称
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * 流程记录发起者角色名称设定
	 *
	 * @param prrolename 流程记录发起者角色名称
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * 流程记录工单号取得
	 *
	 * @return 流程记录工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 流程记录工单号设定
	 *
	 * @param prserialnum 流程记录工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 风险计划类型取得
	 *
	 * @return 风险计划类型
	 */
	public String getRisktype() {
		return risktype;
	}

	/**
	 * 风险计划类型设定
	 *
	 * @param risktype 风险计划类型
	 */
	public void setRisktype(String risktype) {
		this.risktype = risktype;
	}

	/**
	 * 流程记录发起者所属机构名称取得
	 *
	 * @return 流程记录发起者所属机构名称
	 */
	public String getProrgname() {
		return prorgname;
	}

	/**
	 * 流程记录发起者所属机构名称设定
	 *
	 * @param prorgname 流程记录发起者所属机构名称
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	/**
	 * 计划完成情况取得
	 *
	 * @return 计划完成情况
	 */
	public String getRiskcompletion() {
		return riskcompletion;
	}

	/**
	 * 计划完成情况设定
	 *
	 * @param riskcompletion 计划完成情况
	 */
	public void setRiskcompletion(String riskcompletion) {
		this.riskcompletion = riskcompletion;
	}
//
//	/**
//	 * 风险计划状态取得
//	 *
//	 * @return 风险计划状态
//	 */
//	public String getRiskstatus() {
//		return riskstatus;
//	}

//	/**
//	 * 风险计划状态设定
//	 *
//	 * @param riskstatus 风险计划状态
//	 */
//	public void setRiskstatus(String riskstatus) {
//		this.riskstatus = riskstatus;
//	}

	/**
	 * 流程记录发起者所属机构层次码取得
	 *
	 * @return 流程记录发起者所属机构层次码
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * 流程记录发起者所属机构层次码设定
	 *
	 * @param prorgid 流程记录发起者所属机构层次码
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * 流程记录描述取得
	 *
	 * @return 流程记录描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 流程记录描述设定
	 *
	 * @param prdesc 流程记录描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 风险编号取得
	 *
	 * @return 风险编号
	 */
	public String getRisknum() {
		return risknum;
	}

	/**
	 * 风险编号设定
	 *
	 * @param risknum 风险编号
	 */
	public void setRisknum(String risknum) {
		this.risknum = risknum;
	}

	/**
	 * 流程记录流程类型名称取得
	 *
	 * @return 流程记录流程类型名称
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * 流程记录流程类型名称设定
	 *
	 * @param prpdname 流程记录流程类型名称
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * 流程记录流程类型ID取得
	 *
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程记录流程类型ID设定
	 *
	 * @param prpdid 流程记录流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程记录发起者角色ID取得
	 *
	 * @return 流程记录发起者角色ID
	 */
	public String getPrroleid() {
		return prroleid;
	}

	/**
	 * 流程记录发起者角色ID设定
	 *
	 * @param prroleid 流程记录发起者角色ID
	 */
	public void setPrroleid(String prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * 流程记录发起者用户姓名取得
	 *
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 流程记录发起者用户姓名设定
	 *
	 * @param prusername 流程记录发起者用户姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 流程记录发起者用户ID取得
	 *
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * 流程记录发起者用户ID设定
	 *
	 * @param pruserid 流程记录发起者用户ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * 流程记录关闭时间取得
	 *
	 * @return 流程记录关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 流程记录关闭时间设定
	 *
	 * @param prclosetime 流程记录关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
    public Serializable getPK() {
		return prid ;
	}

}