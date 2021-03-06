/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.sms.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.plugin.sms.model.SendSmsLogInfo;
import com.deliverik.plugin.sms.model.condition.SendSmsLogSearchCond;

/**
  * 概述: 短信队列表DAO接口
  * 功能描述: 短信队列表DAO接口
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public interface SendSmsLogDAO extends BaseHibernateDAO<SendSmsLogInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SendSmsLogInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SendSmsLogInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SendSmsLogSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SendSmsLogInfo> findByCond(
			final SendSmsLogSearchCond cond, final int start,
			final int count);

}