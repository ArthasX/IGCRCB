/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCond;

/**
 * 概述:优先级DAO接口
 * 功能描述：1. 全件检索
 * 			2.条件检索结果件数取得
 * 			3.条件检索处理
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 */
public interface PriorityDAO extends BaseHibernateDAO<Priority> {
    /**
     * 全件检索
     * @return 检索结果集
     */
    public List<Priority> findAll();

    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(final PrioritySearchCond cond);
    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<Priority> findByCond(final PrioritySearchCond cond, final int start, final int count);
}

