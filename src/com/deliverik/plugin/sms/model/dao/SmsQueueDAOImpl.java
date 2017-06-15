/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.sms.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.plugin.sms.model.SmsQueueInfo;
import com.deliverik.plugin.sms.model.condition.SmsQueueSearchCond;
import com.deliverik.plugin.sms.model.entity.SmsQueueTB;

/**
  * 概述: 短信队列表DAO实现
  * 功能描述: 短信队列表DAO实现
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public class SmsQueueDAOImpl extends
		BaseHibernateDAOImpl<SmsQueueInfo> implements SmsQueueDAO {

	/**
	 * 构造函数
	 */
	public SmsQueueDAOImpl(){
		super(SmsQueueTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SmsQueueInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("qid"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SmsQueueInfo findByPK(Serializable pk) {
		SmsQueueInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SmsQueueSearchCond cond){
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
	public List<SmsQueueInfo> findByCond(final SmsQueueSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SmsQueueSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}