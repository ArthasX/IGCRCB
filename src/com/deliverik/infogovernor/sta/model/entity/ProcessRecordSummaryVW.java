/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;

/**
 * 
 * 检查问题统计实体
 * 
 */
@SuppressWarnings("serial")
@Entity
public class ProcessRecordSummaryVW implements Serializable,Cloneable, ProcessRecordSummary{

	/** ID */
	@Id
	protected Integer prsid;
	
	/** 问题种类名称 */
	protected String pname;
	
	/** 问题种类 */
	protected String pcode;
	
	/** 问题来源 */
	protected String prassetname;
	
	/** 等待制定计划数量 */
	protected Integer initials;
	
	/** 等待制定计划数量 */
	protected Integer dispatch;
	
	/** 等待审批计划数量 */
	protected Integer appoval;
	
	/** 等待整改执行数量 */
	protected Integer implement;
	
	/** 等待验证数量 */
	protected Integer verify;
	
	/** 关闭数量 */
	protected Integer close;
	
	public boolean equals(Object obj) {
		if (!(obj instanceof ProcessRecordSummaryVW))
			return false;
		ProcessRecordSummary target = (ProcessRecordSummary) obj;
		if (!(getPrsid().equals(target.getPrsid())))
			return false;
		return true;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */	
	public Integer getPrsid() {
		return prsid;
	}

	/**
	 * 主键设定
	 * @param prsid 主键
	 */
	public void setPrsid(Integer prsid) {
		this.prsid = prsid;
	}

	/**
	 * 问题种类名称取得
	 * @return 问题种类名称
	 */	
	public String getPname() {
		return pname;
	}
	
	/**
	 * 问题种类名称设定
	 * @param pname 问题种类名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * 问题种类取得
	 * @return 问题种类
	 */	
	public String getPcode() {
		return pcode;
	}

	/**
	 * 问题种类设定
	 * @param pcode 问题种类
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 问题来源取得
	 * @return 问题来源
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * 问题来源设定
	 * @param prassetname 问题来源
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}


	/**
     * 等待制定计划数量取得
     *
     * @return initials 等待制定计划数量
     */
    public Integer getInitials() {
        return initials;
    }

    /**
     * 等待制定计划数量设定
     *
     * @param initials 等待制定计划数量
     */
    public void setInitials(Integer initials) {
        this.initials = initials;
    }

    /**
	 * 等待审批计划数量取得
	 * @return 等待审批计划数量
	 */	
	public Integer getAppoval() {
		return appoval;
	}

	/**
	 * 等待审批计划数量设定
	 * @param appoval 等待审批计划数量
	 */
	public void setAppoval(Integer appoval) {
		this.appoval = appoval;
	}

	/**
	 * 等待整改执行数量取得
	 * @return 等待整改执行数量
	 */	
	public Integer getImplement() {
		return implement;
	}

	/**
	 * 问等待整改执行数量设定
	 * @param implement 等待整改执行数量
	 */
	public void setImplement(Integer implement) {
		this.implement = implement;
	}

	/**
	 * 等待验证数量取得
	 * @return 等待验证数量
	 */	
	public Integer getVerify() {
		return verify;
	}

	/**
	 * 等待验证数量设定
	 * @param verify 等待验证数量
	 */
	public void setVerify(Integer verify) {
		this.verify = verify;
	}

	/**
	 * 关闭数量取得
	 * @return 关闭数量
	 */	
	public Integer getClose() {
		return close;
	}

	/**
	 * 关闭数量设定
	 * @param close 关闭数量
	 */
	public void setClose(Integer close) {
		this.close = close;
	}
	
	/**
	 * 等待制定计划数量取得
	 * @return 等待制定计划数量
	 */
	public Integer getDispatch() {
		return dispatch;
	}
	
	/**
	 * 等待制定计划数量设定
	 * @param dispatch 等待制定计划数量
	 */
	public void setDispatch(Integer dispatch) {
		this.dispatch = dispatch;
	}

}
