/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.condition.EventssSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EventssTB;

/**
  * 概述: 事件级别表DAO实现
  * 功能描述: 事件级别表DAO实现
  * 创建记录: 2015/03/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class EventssDAOImpl extends
		BaseHibernateDAOImpl<EventssInfo> implements EventssDAO {

	/**
	 * 构造函数
	 */
	public EventssDAOImpl(){
		super(EventssTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EventssInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eventid"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EventssInfo findByPK(Serializable pk) {
		EventssInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EventssSearchCond cond){
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
	public List<EventssInfo> findByCond(final EventssSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		 c.addOrder(Order.asc("labels"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EventssSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getEventssid()!=null&&cond.getEventssid()!=0){
			c.add(Expression.eq("eventid", cond.getEventssid()));
		}
		if(cond.getEventssname() != null && !"".equals(cond.getEventssname())){
			//c.add(Expression.eq("eventname", cond.getEventssname()));
			c.add(Restrictions.like("eventname", "%"+cond.getEventssname()+"%"));
		}
		if(cond.getEventDes() != null && !"".equals(cond.getEventDes())){
			//c.add(Expression.eq("eventname", cond.getEventssname()));
			c.add(Restrictions.like("eventdes", "%"+cond.getEventDes()+"%"));
		}
		if(cond.getLabels()!=null&&cond.getLabels()!=0){
		    c.add(Expression.eq("labels", cond.getLabels()));			
		}	
		if(StringUtils.isNotEmpty(cond.getOrder())&&StringUtils.isNotEmpty(cond.getOrderBy())){
			if("asc".equals(cond.getOrder())){
				
				c.addOrder(Order.asc(cond.getOrderBy()));
			}else if("desc".equals(cond.getOrder())){
				
				c.addOrder(Order.desc(cond.getOrderBy()));
			}
		}
		return c;
	}

}