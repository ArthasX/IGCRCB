/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;

/**
 * 概述: 日常维护DAO接口
 * 功能描述: 日常维护DAO接口
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
public interface OnDutyPersonRecordDAO extends BaseHibernateDAO<OnDutyPersonRecordInfo> {
    
    /**
     * 全件检索
     * @return 检索结果集
     */
    public List<OnDutyPersonRecordInfo> findAll();

    /**
     * 主键检索处理
     * @param ODPRID 主键
     * @return 检索结果
     */
    public OnDutyPersonRecordInfo findByPK(Serializable ODPRID);
    

    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(final OnDutyPersonRecordSearchCond cond);

    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<OnDutyPersonRecordInfo> findByCond(final OnDutyPersonRecordSearchCond cond, final int start, final int count);
}
