package com.deliverik.infogovernor.sta.bl.task;
/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.condition.ContractSearchCond;
import com.deliverik.infogovernor.sta.model.dao.ContractVWDAO;

/**
 * <p>
 * ��ͬͳ��ҵ���߼�ʵ��
 * </p>
 */

public class ContractVWBLImpl  extends BaseBLImpl implements ContractVWBL{
	
	
	protected ContractVWDAO contractVWDAO;
	
	
	/**
     * contractVWDAO�趨
     *
     * @param contractVWDAO contractVWDAO
     */
    public void setContractVWDAO(ContractVWDAO contractVWDAO) {
        this.contractVWDAO = contractVWDAO;
    }

    /***
     * ͳ�ƺ�ͬ��
     */
	public List<Contract> statisticContractAmount(ContractSearchCond cond){
		return contractVWDAO.statisticContractAmount(cond);
	}

}
