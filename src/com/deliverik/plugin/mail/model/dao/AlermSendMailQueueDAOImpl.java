/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.mail.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.plugin.mail.model.AlermSendMailQueueInfo;
import com.deliverik.plugin.mail.model.condition.AlermSendMailQueueSearchCond;
import com.deliverik.plugin.mail.model.entity.AlermSendMailQueueTB;

/**
  * 概述: 邮件队列表DAO实现
  * 功能描述: 邮件队列表DAO实现
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public class AlermSendMailQueueDAOImpl extends
		BaseHibernateDAOImpl<AlermSendMailQueueInfo> implements AlermSendMailQueueDAO {

	/**
	 * 构造函数
	 */
	public AlermSendMailQueueDAOImpl(){
		super(AlermSendMailQueueTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AlermSendMailQueueInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("inserttime"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AlermSendMailQueueInfo findByPK(Serializable pk) {
		AlermSendMailQueueInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AlermSendMailQueueSearchCond cond){
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
	public List<AlermSendMailQueueInfo> findByCond(final AlermSendMailQueueSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AlermSendMailQueueSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond==null){return c;}
		if(Character.isDigit( cond.getSentstatus_eq() )){
			c.add(Expression.eq("sentstatus", cond.getSentstatus_eq()));
		}
		return c;
	}

}