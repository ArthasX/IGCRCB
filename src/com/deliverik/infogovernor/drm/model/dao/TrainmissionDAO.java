/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCond;

/**
  * 概述: 培训任务表DAO接口
  * 功能描述: 培训任务表DAO接口
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public interface TrainmissionDAO extends BaseHibernateDAO<TrainmissionInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainmissionInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainmissionInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final TrainmissionSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TrainmissionInfo> findByCond(
			final TrainmissionSearchCond cond, final int start,
			final int count);
	public List<Map<String, Object>> getList(final String [] sqlKeys, final Map<String, String> paramMap);
}