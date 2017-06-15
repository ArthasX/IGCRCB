package com.deliverik.infogovernor.sta.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.condition.ProjectStatisticSearchCond;

public interface ProjectStatisticVWDAO extends BaseHibernateDAO<ProjectStatistic> {
    /**
     * ��ѯ��Ŀ����
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<ProjectStatistic> searchPrjRec(final ProjectStatisticSearchCond cond, int start, int count);
    
}
