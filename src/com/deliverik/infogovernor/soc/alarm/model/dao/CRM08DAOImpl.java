/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM08SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM08TB;

/**
  * 概述: CRM08DAO实现
  * 功能描述: CRM08DAO实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CRM08DAOImpl extends
		BaseHibernateDAOImpl<CRM08Info> implements CRM08DAO {

	/**
	 * 构造函数
	 */
	public CRM08DAOImpl(){
		super(CRM08TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM08Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM08Info findByPK(Serializable pk) {
		CRM08Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CRM08SearchCond cond){
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
	public List<CRM08Info> findByCond(final CRM08SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("typecid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CRM08SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getTypeccid_eq())){
			c.add(Expression.eq("typeccid", cond.getTypeccid_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getTypecid_eq())){
			c.add(Expression.eq("typecid", cond.getTypecid_eq()));
		}
		if(cond.getRuletempids() != null && cond.getRuletempids().size() != 0){
			c.add(Expression.in("ruletempid", cond.getRuletempids()));
		}
		if(StringUtils.isNotEmpty(cond.getRuletempname())){
			c.add(Expression.like("ruletempname", "%"+cond.getRuletempname()+"%"));
		}
		if(cond.getTempstate()!=null){
			c.add(Expression.eq("tempstate", cond.getTempstate()));
		}
		return c;
	}

}