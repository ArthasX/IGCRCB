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
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * 概述: 报告模板DAO实现
  * 功能描述: 报告模板DAO实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportTemplateDAOImpl表名修改为SOC0207DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0207DAOImpl extends
		BaseHibernateDAOImpl<SOC0207Info> implements SOC0207DAO {

	/**
	 * 构造函数
	 */
	public SOC0207DAOImpl(){
		super(SOC0207TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0207Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0207Info findByPK(Serializable pk) {
		SOC0207Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0207SearchCond cond){
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
	public List<SOC0207Info> findByCond(final SOC0207SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rtId"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0207SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getRtname_like())) {
			c.add(Expression.like("rtName", "%"+cond.getRtname_like()+"%"));			
		}
		if (!StringUtils.isEmpty(cond.getRtdatetype_eq())) {
			c.add(Expression.eq("rtDateType", cond.getRtdatetype_eq()));
		}
		return c;
	}

}