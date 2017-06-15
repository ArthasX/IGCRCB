/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.EEOrg;


/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂招待部门汇总实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class EEOrgVW implements Serializable, Cloneable, EEOrg {
	
	/** 接待数量 */
	protected Integer rnum;
	
	/** 费用总额 */
	protected BigDecimal amount;
	
	/** 主要申请部门层次码 */
	@Id
	protected String rapporgid;

	/** 部门 */
	public String rapporgname;
	
	

	/**
	 * 接待数量取得
	 * @return 接待数量
	 */
	public Integer getRnum() {
		return rnum;
	}

	/**
	 * 接待数量设定
	 * @param rnum 接待数量
	 */
	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}

	/**
	 * 费用总额取得
	 * @return 费用总额
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * 费用总额设定
	 * @param amount 费用总额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * 主要申请部门层次码取得
	 * @return 主要申请部门层次码
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * 主要申请部门层次码设定
	 * @param rapporgid 主要申请部门层次码
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	public String getRapporgname() {
		return rapporgname;
	}

	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}


//	public String getRapporgname() {
//		return rapporgname;
//	}
//
//	public void setRapporgname(String rapporgname) {
//		this.rapporgname = rapporgname;
//	}






}
