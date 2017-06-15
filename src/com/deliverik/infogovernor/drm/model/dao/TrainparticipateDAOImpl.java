/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainparticipateSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainparticipateTB;

/**
  * 概述: 培训参与人DAO实现
  * 功能描述: 培训参与人DAO实现
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public class TrainparticipateDAOImpl extends
		BaseHibernateDAOImpl<TrainparticipateInfo> implements TrainparticipateDAO {

	/**
	 * 构造函数
	 */
	public TrainparticipateDAOImpl(){
		super(TrainparticipateTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainparticipateInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainparticipateInfo findByPK(Serializable pk) {
		TrainparticipateInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final TrainparticipateSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TrainparticipateInfo> findByCond(final TrainparticipateSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(TrainparticipateSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTrid() != null && cond.getTrid() > 0){
			c.add(Restrictions.eq("trid", cond.getTrid()));
		}
		return c;
	}

}