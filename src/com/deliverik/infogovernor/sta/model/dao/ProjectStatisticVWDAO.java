package com.deliverik.infogovernor.sta.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.condition.ProjectStatisticSearchCond;

public interface ProjectStatisticVWDAO extends BaseHibernateDAO<ProjectStatistic> {
    /**
     * 查询项目流程
     *
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<ProjectStatistic> searchPrjRec(final ProjectStatisticSearchCond cond, int start, int count);
    
}
