/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefTB;

/**
  * 概述: 监控对象阀值信息表DAO实现
  * 功能描述: 监控对象阀值信息表DAO实现
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class MonitorObjectDefDAOImpl extends
		BaseHibernateDAOImpl<MonitorObjectDefInfo> implements MonitorObjectDefDAO {

	/**
	 * 构造函数
	 */
	public MonitorObjectDefDAOImpl(){
		super(MonitorObjectDefTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorObjectDefInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorObjectDefInfo findByPK(Serializable pk) {
		MonitorObjectDefInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MonitorObjectDefSearchCond cond){
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
	public List<MonitorObjectDefInfo> findByCond(final MonitorObjectDefSearchCond cond, final int start, final int count){
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
	protected DetachedCriteria getCriteria(MonitorObjectDefSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getMoId())){
			c.add(Expression.eq("moId", Integer.valueOf(cond.getMoId())));
		}
		return c;
	}

}