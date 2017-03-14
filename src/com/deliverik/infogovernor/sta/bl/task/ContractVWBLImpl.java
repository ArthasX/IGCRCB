package com.deliverik.infogovernor.sta.bl.task;
/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.condition.ContractSearchCond;
import com.deliverik.infogovernor.sta.model.dao.ContractVWDAO;

/**
 * <p>
 * 合同统计业务逻辑实现
 * </p>
 */

public class ContractVWBLImpl  extends BaseBLImpl implements ContractVWBL{
	
	
	protected ContractVWDAO contractVWDAO;
	
	
	/**
     * contractVWDAO设定
     *
     * @param contractVWDAO contractVWDAO
     */
    public void setContractVWDAO(ContractVWDAO contractVWDAO) {
        this.contractVWDAO = contractVWDAO;
    }

    /***
     * 统计合同额
     */
	public List<Contract> statisticContractAmount(ContractSearchCond cond){
		return contractVWDAO.statisticContractAmount(cond);
	}

}
