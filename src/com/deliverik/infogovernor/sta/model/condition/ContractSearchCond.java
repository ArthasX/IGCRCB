/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * 合同统计查询条件接口
 */
public interface ContractSearchCond {
    
    /**
     * 统计年取得
     *
     * @return curYear 统计年
     */
    public String getCurYear();

    /**
     * 服务商取得
     *
     * @return facilitator 服务商
     */
    public String getFacilitator();

    /**
     * 合同类型取得
     *
     * @return contractType 合同类型
     */
    public String getContractType();
    
}
