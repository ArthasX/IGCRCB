/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeDefTB;

/**
  * 概述: 监控类型阀值信息DAO实现
  * 功能描述: 监控类型阀值信息DAO实现
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class MonitorTypeDefDAOImpl extends
		BaseHibernateDAOImpl<MonitorTypeDefInfo> implements MonitorTypeDefDAO {

	/**
	 * 构造函数
	 */
	public MonitorTypeDefDAOImpl(){
		super(MonitorTypeDefTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorTypeDefInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorTypeDefInfo findByPK(Serializable pk) {
		MonitorTypeDefInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MonitorTypeDefSearchCond cond){
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
	public List<MonitorTypeDefInfo> findByCond(final MonitorTypeDefSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("orderNumber"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(MonitorTypeDefSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getMtId()!=null){
			c.add(Expression.eq("mtId", Integer.valueOf(cond.getMtId())));
		}
		return c;
	}

}