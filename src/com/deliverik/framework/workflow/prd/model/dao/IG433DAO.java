/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.framework.workflow.prd.model.dao;


 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG433Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;


 /**
  * 概述:流程评审dao接口
  * 功能描述：针对流程评审实体进行操作
  *           
  * 创建记录：宋海洋    2010/11/26
  */
public interface IG433DAO extends BaseHibernateDAO<IG433Info> {
    /**
     * 全件检索
     * @return 检索结果集
     */
    public List<IG433Info> findAll();
    /**
     * 主键检索处理
     * @param id 主键
     * @return 检索结果
     */
    public IG433Info findByPK(Serializable id);
    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(final IG433SearchCond cond);
    /**
     * 条件检索处理(视图)
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<IG433Info> findByCond(final IG433SearchCond cond, final int start, final int count);
    
    /**
     * 条件检索处理(实体)
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<IG433Info> findByCond_Entity(final IG433SearchCond cond, final int start, final int count);
}

