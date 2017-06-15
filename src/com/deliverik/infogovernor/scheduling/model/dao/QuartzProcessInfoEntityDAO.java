/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCond;

/**
 * 
 * 流程资产关系DAO接口
 *
 */
public interface QuartzProcessInfoEntityDAO extends BaseHibernateDAO<QuartzProcessInfoEntity> {
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<QuartzProcessInfoEntity> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public QuartzProcessInfoEntity findByPK(Serializable psidid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final QuartzProcessInfoEntitySearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<QuartzProcessInfoEntity> findByCond(final QuartzProcessInfoEntitySearchCond cond, final int start, final int count);
	
}
