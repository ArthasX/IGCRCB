/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao;

 import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_InfoDAO;


/**
 * 
 * @Description:存储基本信息DAO接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_InfoDAO extends BaseHibernateDAO<Collect_Symmetrix_Info> {
    /**
     * 全件检索
     * @return 检索结果集
     */
    public List<Collect_Symmetrix_Info> findAll();
    /**
     * 主键检索处理
     * @param id 主键
     * @return 检索结果
     */
    public Collect_Symmetrix_Info findByPK(Serializable id);
    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(final Collect_Symmetrix_InfoSearchCond cond);
    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<Collect_Symmetrix_Info> findByCond(final Collect_Symmetrix_InfoSearchCond cond, final int start, final int count);
}

