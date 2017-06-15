/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectHistorySearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectHistoryTB;

/**
  * 概述: 对比对象历史表DAO实现
  * 功能描述: 对比对象历史表DAO实现
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CompareobjectHistoryDAOImpl extends
		BaseHibernateDAOImpl<CompareobjectHistoryInfo> implements CompareobjectHistoryDAO {

	/**
	 * 构造函数
	 */
	public CompareobjectHistoryDAOImpl(){
		super(CompareobjectHistoryTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<CompareobjectHistoryInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
	public CompareobjectHistoryInfo findByPK(Serializable pk) {
		CompareobjectHistoryInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareobjectHistorySearchCond cond){
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
	public List<CompareobjectHistoryInfo> findByCond(final CompareobjectHistorySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CompareobjectHistorySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (null != cond.getFkCrid_eq()) {
		    c.add(Restrictions.eq("fkCrid", cond.getFkCrid_eq()));
		}
		
		if (null != cond.getCrversion_eq()) {
		    c.add(Restrictions.eq("crversion", cond.getCrversion_eq()));
		}
		if(null!=cond.getCoid_eq()){
			c.add(Restrictions.eq("coid", cond.getCoid_eq()));
		}
		return c;
	}

}