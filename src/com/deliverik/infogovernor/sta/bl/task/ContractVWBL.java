/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.bl.task;

/**
 * <p>
 * ��ͬͳ��ҵ���߼��ӿ�
 * </p>
 */
import java.util.List;

import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.condition.ContractSearchCond;

public interface ContractVWBL {
    public List<Contract> statisticContractAmount(ContractSearchCond cond);
}
