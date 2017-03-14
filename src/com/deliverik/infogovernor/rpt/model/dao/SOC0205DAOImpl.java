/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0205TB;

/**
  * 概述: 报告管理表DAO实现
  * 功能描述: 报告管理表DAO实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportManageDAOImpl表名修改为SOC0205DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0205DAOImpl extends
		BaseHibernateDAOImpl<SOC0205Info> implements SOC0205DAO {

	/**
	 * 构造函数
	 */
	public SOC0205DAOImpl(){
		super(SOC0205TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0205Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0205Info findByPK(Serializable pk) {
		SOC0205Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0205SearchCond cond){
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
	public List<SOC0205Info> findByCond(final SOC0205SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rmId"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0205SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getRmName_like())){			
			c.add(Expression.like("rmName","%"+cond.getRmName_like()+"%"));
		}
		if(!StringUtils.isEmpty(cond.getRtdatetype_eq())){			
			c.add(Expression.eq("rmDateType",cond.getRtdatetype_eq()));
		}
		if(!StringUtils.isEmpty(cond.getDateFrom())){
			c.add(Expression.ge("rmLastDay",cond.getDateFrom()));
		}
		if(!StringUtils.isEmpty(cond.getDateTo())){
			c.add(Expression.le("rmLastDay",cond.getDateTo()));
		}
		return c;
	}

}