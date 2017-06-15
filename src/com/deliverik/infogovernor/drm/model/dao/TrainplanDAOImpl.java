/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainplanSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainplanTB;

/**
  * 概述: 培训计划表DAO实现
  * 功能描述: 培训计划表DAO实现
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public class TrainplanDAOImpl extends
		BaseHibernateDAOImpl<TrainplanInfo> implements TrainplanDAO {

	/**
	 * 构造函数
	 */
	public TrainplanDAOImpl(){
		super(TrainplanTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainplanInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainplanInfo findByPK(Serializable pk) {
		TrainplanInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final TrainplanSearchCond cond){
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
	public List<TrainplanInfo> findByCond(final TrainplanSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(TrainplanSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTporgname() != null && !"".equals(cond.getTporgname())){
		
			c.add(Restrictions.like("tporgname", "%"+cond.getTporgname()+"%"));
		}
		
		if(cond.getTpusername() != null && !"".equals(cond.getTpusername())){
			
			c.add(Restrictions.like("tpusername", "%"+cond.getTpusername()+"%"));
		}
		
		if( cond.getStartTimeBegin() != null && !"".equals(cond.getStartTimeBegin())){
			c.add(Restrictions.ge("tptime", cond.getStartTimeBegin()));
		}
		
		if( cond.getStartTimeEnd() != null && !"".equals(cond.getStartTimeEnd())){
			c.add(Restrictions.le("tptime", cond.getStartTimeEnd()));
		}
		return c;
	}

}