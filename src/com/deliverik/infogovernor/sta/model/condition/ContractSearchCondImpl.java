/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * 合同统计查询条件实现
 */
public class ContractSearchCondImpl implements ContractSearchCond{
	
	/** 统计年 */
	protected String curYear;
	
	/** 服务商 */
	protected String facilitator;
	
	/** 合同类型*/
	protected String contractType;

    /**
     * 统计年取得
     *
     * @return curYear 统计年
     */
    public String getCurYear() {
        return curYear;
    }

    /**
     * 服务商取得
     *
     * @return facilitator 服务商
     */
    public String getFacilitator() {
        return facilitator;
    }

    /**
     * 合同类型取得
     *
     * @return contractType 合同类型
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * 统计年设定
     *
     * @param curYear 统计年
     */
    public void setCurYear(String curYear) {
        this.curYear = curYear;
    }

    /**
     * 服务商设定
     *
     * @param facilitator 服务商
     */
    public void setFacilitator(String facilitator) {
        this.facilitator = facilitator;
    }

    /**
     * 合同类型设定
     *
     * @param contractType 合同类型
     */
    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
	
	
}
