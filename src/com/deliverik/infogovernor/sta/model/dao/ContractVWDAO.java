package com.deliverik.infogovernor.sta.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.condition.ContractSearchCond;

public interface ContractVWDAO extends BaseHibernateDAO<Contract> {
    /**
     * ͳ�Ʋ�ѯ��ǰ����ǰһ�꣬��ͬ��
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Contract> statisticContractAmount(final ContractSearchCond cond);
}
