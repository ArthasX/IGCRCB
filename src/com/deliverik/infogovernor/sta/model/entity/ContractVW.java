/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sta.model.Contract;

/**
 * 
 * 合同统计实体
 * 
 */
@SuppressWarnings("serial")
@Entity
public class ContractVW implements Serializable,Cloneable, Contract{

	/** ID */
	@Id
	protected String eid;
	
	/** 合同类型 */
	protected String ename;
	
	/** 合同类型码 */
	protected String esyscoding;
	
	/** 当前年合同额总计 */
	protected String currentinvestment;
	
	/** 前一年合同额总计*/
	protected String lastinvestment;
	
	/** 两年合同额差 */
	protected String diff;

    /**
     * ID取得
     *
     * @return eid ID
     */
    public String getEid() {
        return eid;
    }

    /**
     * 合同类型取得
     *
     * @return ename 合同类型
     */
    public String getEname() {
        return ename;
    }

    /**
     * 当前年合同额总计取得
     *
     * @return currentinvestment 当前年合同额总计
     */
    public String getCurrentinvestment() {
        return currentinvestment;
    }

    /**
     * 前一年合同额总计取得
     *
     * @return lastinvestment 前一年合同额总计
     */
    public String getLastinvestment() {
        return lastinvestment;
    }

    /**
     * 两年合同额差取得
     *
     * @return diff 两年合同额差
     */
    public String getDiff() {
        return diff;
    }

    /**
     * ID设定
     *
     * @param eid ID
     */
    public void setEid(String eid) {
        this.eid = eid;
    }

    /**
     * 合同类型设定
     *
     * @param ename 合同类型
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * 当前年合同额总计设定
     *
     * @param currentinvestment 当前年合同额总计
     */
    public void setCurrentinvestment(String currentinvestment) {
        this.currentinvestment = currentinvestment;
    }

    /**
     * 前一年合同额总计设定
     *
     * @param lastinvestment 前一年合同额总计
     */
    public void setLastinvestment(String lastinvestment) {
        this.lastinvestment = lastinvestment;
    }

    /**
     * 两年合同额差设定
     *
     * @param diff 两年合同额差
     */
    public void setDiff(String diff) {
        this.diff = diff;
    }

    /**
     * 合同类型码取得
     *
     * @return esyscoding 合同类型码
     */
    public String getEsyscoding() {
        return esyscoding;
    }

    /**
     * 合同类型码设定
     *
     * @param esyscoding 合同类型码
     */
    public void setEsyscoding(String esyscoding) {
        this.esyscoding = esyscoding;
    }
	

}
