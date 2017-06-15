/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sta.bl.task;

/**
 * <p>
 * 合同统计业务逻辑接口
 * </p>
 */
import java.util.List;

import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.condition.ContractSearchCond;

public interface ContractVWBL {
    public List<Contract> statisticContractAmount(ContractSearchCond cond);
}
