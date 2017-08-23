/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;

@SuppressWarnings("serial")
@Entity
public class IGCRC0301VW implements Serializable,Cloneable,IGCRC0301VWInfo{
	
	@Id
	protected Integer prid;
	
	/**
	 * 流程记录类型
	 */
	protected String prtype;
	
	/**
	 * 流程记录工单号
	 */
	protected String prserialnum;
	
	/**
	 * 流程记录题目
	 */
	protected String prtitle;
	
	
	/**
	 * 流程记录发起者用户姓名
	 */
	protected String prusername;
	
	
	
	

	
	
	/**
	 * 流程记录建立时间
	 */
	protected String propentime;
	
	/**
	 * 流程记录关闭时间
	 */
	protected String prclosetime;
	
	/**
	 * 流程记录状态
	 */
	protected String prstatus;
	

	/**
	 * 流程记录状态子状态
	 */
	protected String prsubstatus;
	
	/**
	 * 流程记录流程类型ID
	 */
	protected String prpdid;
	
	/**
	 * 问题描述
	 */
	protected String pbcontent;
	
	/**
	 * 问题描述
	 */
	protected String afterplan;
	
	/**
	 * 问题描述
	 */
	protected String planstime;
	
	/**
	 * 问题描述
	 */
	protected String dutypersion;
	
	
	
	/**
	 * 节点名称
	 */
	protected String orderstatus;

	/**
	 * 节点id
	 */
	protected String psdid;
	
	
	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrusername() {
		return prusername;
	}

	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPrsubstatus() {
		return prsubstatus;
	}

	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPbcontent() {
		return pbcontent;
	}

	public void setPbcontent(String pbcontent) {
		this.pbcontent = pbcontent;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getAfterplan() {
		return afterplan;
	}

	public void setAfterplan(String afterplan) {
		this.afterplan = afterplan;
	}

	public String getPlanstime() {
		return planstime;
	}

	public void setPlanstime(String planstime) {
		this.planstime = planstime;
	}

	public String getDutypersion() {
		return dutypersion;
	}

	public void setDutypersion(String dutypersion) {
		this.dutypersion = dutypersion;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	
	
	
	
	
}
