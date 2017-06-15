/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCond;
import com.deliverik.infogovernor.drm.model.entity.OptionSencesTB;

/**
  * 概述: 备选场景DAO实现
  * 功能描述: 备选场景DAO实现
  * 创建记录: 2016/10/09
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class OptionSencesDAOImpl extends
		BaseHibernateDAOImpl<OptionSencesInfo> implements OptionSencesDAO {

	/**
	 * 构造函数
	 */
	public OptionSencesDAOImpl(){
		super(OptionSencesTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OptionSencesInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public OptionSencesInfo findByPK(Serializable pk) {
		OptionSencesInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final OptionSencesSearchCond cond){
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
	public List<OptionSencesInfo> findByCond(final OptionSencesSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(OptionSencesSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getPrid_eq() != null && cond.getPrid_eq() > 0) {
			
			c.add(Restrictions.eq("prid", cond.getPrid_eq()));
		}
		return c;
	}

}