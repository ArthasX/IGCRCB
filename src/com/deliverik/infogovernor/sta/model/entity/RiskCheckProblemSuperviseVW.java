/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sta.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;

/**
  * 概述: 问题整改监督视图实体
  * 功能描述: 问题整改监督视图实体
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class RiskCheckProblemSuperviseVW implements Serializable, RiskCheckProblemSuperviseVWInfo {

	/** 主键流程ID */
	@Id
	protected String prid;
	
	/** 流程定义Id */
	protected String prpdid;
	
	/** 问题名称 */
	protected String prtitle;
	
	/** 问题描述 */
	protected String prdesc;
	
	/** 流程发起者id */
	protected String pruserid;
	
	/** 流程发起者名字 */
	protected String prusername;
	
	/** 问题发起时间 */
	protected String propentime;
	
	/** 问题结束时间 */
	protected String prclosetime; 
	
	/** 问题状态 */
	protected String prstatus; 
	
	/** 检查项类别 */
	protected String riskprype;
	
	/** 问题来源 */
	protected String problemsource;

	/**
	 * 主键流程ID取得
	 * @return prid 主键流程ID
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * 主键流程ID设定
	 * @param prid 主键流程ID
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * 流程定义Id取得
	 * @return prpdid 流程定义Id
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程定义Id设定
	 * @param prpdid 流程定义Id
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 问题名称取得
	 * @return prtitle 问题名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 问题名称设定
	 * @param prtitle 问题名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 问题描述取得
	 * @return prdesc 问题描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 问题描述设定
	 * @param prdesc 问题描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 流程发起者id取得
	 * @return pruserid 流程发起者id
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * 流程发起者id设定
	 * @param pruserid 流程发起者id
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * 流程发起者名字取得
	 * @return prusername 流程发起者名字
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 流程发起者名字设定
	 * @param prusername 流程发起者名字
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 问题发起时间取得
	 * @return propentime 问题发起时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 问题发起时间设定
	 * @param propentime 问题发起时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 问题结束时间取得
	 * @return prclosetime 问题结束时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 问题结束时间设定
	 * @param prclosetime 问题结束时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 问题状态取得
	 * @return prstatus 问题状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 问题状态设定
	 * @param prstatus 问题状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 检查项类别取得
	 * @return riskprype 检查项类别
	 */
	public String getRiskprype() {
		return riskprype;
	}

	/**
	 * 检查项类别设定
	 * @param riskprype 检查项类别
	 */
	public void setRiskprype(String riskprype) {
		this.riskprype = riskprype;
	}

	/**
	 * 问题来源取得
	 * @return problemsource 问题来源
	 */
	public String getProblemsource() {
		return problemsource;
	}

	/**
	 * 问题来源设定
	 * @param problemsource 问题来源
	 */
	public void setProblemsource(String problemsource) {
		this.problemsource = problemsource;
	} 


}