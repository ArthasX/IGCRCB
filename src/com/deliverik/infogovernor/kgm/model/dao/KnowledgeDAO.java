/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.kgm.model.dao;

 import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;

/**
 * 概述: 知识库信息DAO接口
 * 功能描述：知识库信息信息DAO接口
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public interface KnowledgeDAO extends BaseHibernateDAO<Knowledge> {
    /**
     * 全件检索
     * @return 检索结果集
     */
    public List<Knowledge> findAll();
    /**
     * 主键检索处理
     * @param id 主键
     * @return 检索结果
     */
    public Knowledge findByPK(Serializable id);
    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(final KnowledgeSearchCond cond);
    
    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchNotCheckCount(final KnowledgeSearchCond cond);
    
	/**
	 * 功能：获取指定ID当前最大id号
	 * @param knid流程定义ID
	 * @return 最大id号
	 */
	public Integer getMaxgKnid();
	
	/**
	 * 功能：获取指定ID当前最大id号
	 * @param knid流程定义ID
	 * @return 最大id号
	 */
	public Integer getMaxVersion(Integer knid);
	
    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<Knowledge> findByCond(final KnowledgeSearchCond cond, final int start, final int count);
    
    /**
     * 条件检索处理（知识库历史版本查询）
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<Knowledge> findByCond_History(final KnowledgeSearchCond cond, final int start, final int count);
    
    /**
     * 根据知识id检索当前有效知识处理
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public Knowledge findByKnid(final KnowledgeSearchCond cond);
    
    /**
     * 知识序列号取得取得
     * @return 知识序列号取得
     */
    public String getKnserial();
}

