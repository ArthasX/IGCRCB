/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;



/**
 * 概述:带有处理人的本月工作查询 
 * 功能描述：带有处理人的本月工作查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-04-19
 * 修改记录：
 */
@Entity
public class CurrentMonthWorkVW implements CurrentMonthWorkVWInfo{

	@Id
    protected Integer prid;
	
	/**
	 * 流程记录类型
	 */
	protected String prtype;	
	
	/**
	 * 流程记录状态
	 */
	protected String prstatus;
	
	/**
	 * 流程记录状态子状态
	 */
	protected String prsubstatus;
		
	/**
	 * 流程记录题目
	 */
	protected String prtitle;
	
	
	/**
	 * 流程记录建立时间
	 */
	protected String propentime;
	
	/**
	 * 流程记录关闭时间
	 */
	protected String prclosetime;
		
	/**
	 * 流程记录紧急程度
	 */
	protected String prurgency;
	
	/**
	 * 流程记录影响程度
	 */
	protected String primpact;
	/**
	 * 流程记录发起者用户ID
	 */
	protected String pruserid;
	
	/**
	 * 流程记录发起者用户姓名
	 */
	protected String prusername;
	
	/**
	 * 流程记录发起者角色ID
	 */
	protected Integer prroleid;
	
	/**
	 * 流程记录发起者角色名称
	 */
	protected String prrolename;
	
	/**
	 * 流程记录流程类型ID
	 */
	protected String prpdid;
	
	/**
	 * 流程记录流程类型名称
	 */
	protected String prpdname;
	
	
	/**
	 * 流程记录工单号
	 */
	protected String prserialnum;
		
	/**
	 * 参与者角色id
	 */
	protected String pproleid;
	
	/**
	 * 参与人合并后用户姓名
	 */
	protected String ppusername;
	
	/**
	 * 参与人合并后的角色名
	 */
	protected String pprolename;
	
	/**
	 * 参与人合并后的用户id
	 */
	protected String ppuserid;
	/**
	 * 流程记录ID取得
	 * @return流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程记录类型取得
	 * @return 流程记录类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程记录类型设定
	 * @param prtype 流程记录类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程记录状态取得
	 * @return 流程记录状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程记录状态设定
	 * @param prstatus 流程记录状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	/**
	 * 流程记录状态子状态取得
	 * @return 流程记录状态子状态
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * 流程记录状态子状态设定
	 * @param prsubstatus 流程记录状态子状态
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}
	
	/**
	 * 流程记录题目取得
	 * @return 流程记录题目
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程记录题目设定
	 * @param prtitle 流程记录题目
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}


	/**
	 * 流程记录建立时间取得
	 * @return 流程记录建立时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 流程记录建立时间设定
	 * @param propentime 流程记录建立时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 流程记录关闭时间取得
	 * @return 流程记录关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 流程记录关闭时间设定
	 * @param prclosetime 流程记录关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	

	/**
	 * 流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 流程记录紧急程度设定
	 * @param prurgency 流程记录紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * 流程记录影响程度取得
	 * @return 流程记录影响程度
	 */
	public String getPrimpact() {
		return primpact;
	}

	/**
	 * 流程记录影响程度设定
	 * @param primpact 流程记录影响程度
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}
	/**
	 * 流程记录发起者用户ID取得
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * 流程记录发起者用户ID设定
	 * @param pruserid 流程记录发起者用户ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * 流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 流程记录发起者用户姓名设定
	 * @param prusername 流程记录发起者用户姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}	

	/**
	 * 流程记录发起者角色ID取得
	 * @return 流程记录发起者角色ID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 流程记录发起者角色ID设定
	 * @param prroleid 流程记录发起者角色ID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}
	/**
	 * 流程记录发起者角色名称取得
	 * @return 流程记录发起者角色名称
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * 流程记录发起者角色名称设定
	 * @param prrolename 流程记录发起者角色名称
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}
	/**
	 * 流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程记录流程类型ID设定
	 * @param prpdid 流程记录流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程记录流程类型名称取得
	 * @return 流程记录流程类型名称
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * 流程记录流程类型名称设定
	 * @param prpdname 流程记录流程类型名称
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}


	/**
	 * 流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 流程记录工单号设定
	 * @param prserialnum 流程记录工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 参与者角色id取得
	 * @return 参与者角色id
	 */
	public String getPproleid() {
		return pproleid;
	}

	/**
	 * 参与者角色id设定
	 * @param pproleid 参与者角色id
	 */
	public void setPproleid(String pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * 参与人姓名取得
	 * @return 参与人姓名
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * 参与人姓名设定
	 * @param ppusername 参与人姓名
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * 参与人合并后的角色名取得
	 * @return 参与人合并后的角色名
	 */
	public String getPprolename() {
		return pprolename;
	}

	/**
	 * 参与人合并后的角色名设定
	 * @param pprolename 参与人合并后的角色名
	 */
	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	/**
	 * 参与人合并后的用户id取得
	 * @return 参与人合并后的用户id
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 参与人合并后的用户id设定
	 * @param ppuserid 参与人合并后的用户id
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	
	
}
