/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainrecordSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainrecordTB;

/**
  * 概述: 培训记录DAO实现
  * 功能描述: 培训记录DAO实现
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public class TrainrecordDAOImpl extends
		BaseHibernateDAOImpl<TrainrecordInfo> implements TrainrecordDAO {

	/**
	 * 构造函数
	 */
	public TrainrecordDAOImpl(){
		super(TrainrecordTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainrecordInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainrecordInfo findByPK(Serializable pk) {
		TrainrecordInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final TrainrecordSearchCond cond){
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
	public List<TrainrecordInfo> findByCond(final TrainrecordSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(TrainrecordSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getTrname())){
			c.add(Restrictions.like("trname", "%"+cond.getTrname()+"%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getTrstimeFrom())){
			c.add(Restrictions.ge("trstime", cond.getTrstimeFrom()));
		}
		
		if(StringUtils.isNotEmpty(cond.getTrstimeTo())){
			c.add(Restrictions.le("trstime", cond.getTrstimeTo()));
		}
		
		return c;
	}

}