package com.deliverik.infogovernor.sta.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.condition.ContractSearchCond;

public interface ContractVWDAO extends BaseHibernateDAO<Contract> {
    /**
     * 统计查询当前年与前一年，合同额
     *
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<Contract> statisticContractAmount(final ContractSearchCond cond);
}
