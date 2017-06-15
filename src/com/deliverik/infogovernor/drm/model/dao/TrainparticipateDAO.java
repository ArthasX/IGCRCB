/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainparticipateSearchCond;

/**
  * 概述: 培训参与人DAO接口
  * 功能描述: 培训参与人DAO接口
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public interface TrainparticipateDAO extends BaseHibernateDAO<TrainparticipateInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainparticipateInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainparticipateInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final TrainparticipateSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TrainparticipateInfo> findByCond(
			final TrainparticipateSearchCond cond, final int start,
			final int count);

}