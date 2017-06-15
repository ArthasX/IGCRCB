/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM07Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM07SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;

/**
  * 概述: CRM07DAO实现
  * 功能描述: CRM07DAO实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CRM07DAOImpl extends
		BaseHibernateDAOImpl<CRM07Info> implements CRM07DAO {

	/**
	 * 构造函数
	 */
	public CRM07DAOImpl(){
		super(CRM07TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM07Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM07Info findByPK(Serializable pk) {
		CRM07Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CRM07SearchCond cond){
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
	public List<CRM07Info> findByCond(final CRM07SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CRM07SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRuletempid()!=null){
			c.add(Expression.eq("ruletempid", cond.getRuletempid()));
		}
		return c;
	}

}