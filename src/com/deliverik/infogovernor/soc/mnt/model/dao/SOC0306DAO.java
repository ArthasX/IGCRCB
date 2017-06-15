/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.soc.mnt.model.dao;

 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;


/**
 * 
 * @Description:软件部署信息视图DAO接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface SOC0306DAO extends BaseHibernateDAO<SOC0306Info> {
    /**
     * 全件检索
     * @return 检索结果集
     */
    public List<SOC0306Info> findAll();
    /**
     * 主键检索处理
     * @param id 主键
     * @return 检索结果
     */
    public SOC0306Info findByPK(Serializable id);
    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(final SOC0306SearchCond cond);
    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<SOC0306Info> findByCond(final SOC0306SearchCond cond, final int start, final int count);
    
    /**
     * 查询缺失的性能导入数据
     * @param yestoday 昨天的日期
     * @return 检索结果列表
     */
    @SuppressWarnings("unchecked")
    public List searchSymmetrixAlarm(final String yestoday);
}

