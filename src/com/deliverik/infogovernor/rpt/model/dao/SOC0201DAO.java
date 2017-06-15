/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.rpt.model.dao;

 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0201Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0201SearchCond;


/**
 * 
 * @Description:自动报表生成表DAO接口
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将REPORT_GDATA_ITEMDAO表名改为SOC0201DAO
 */
public interface SOC0201DAO extends BaseHibernateDAO<SOC0201Info> {
    /**
     * 全件检索
     * @return 检索结果集
     */
    public List<SOC0201Info> findAll();
    /**
     * 主键检索处理
     * @param id 主键
     * @return 检索结果
     */
    public SOC0201Info findByPK(Serializable id);
    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(final SOC0201SearchCond cond);
    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<SOC0201Info> findByCond(final SOC0201SearchCond cond, final int start, final int count);
}

