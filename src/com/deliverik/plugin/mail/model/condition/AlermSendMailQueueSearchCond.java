/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.mail.model.condition;

/**
  * 概述: 邮件队列表检索条件接口
  * 功能描述: 邮件队列表检索条件接口
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public interface AlermSendMailQueueSearchCond {
	/**
	 * inserttime_begin取得
	 *
	 * @return inserttime_begin inserttime_begin
	 */
	public String getInserttime_begin();
	/**
	 * inserttime_end取得
	 *
	 * @return inserttime_end inserttime_end
	 */
	public String getInserttime_end();
	/**
	 * senttime_begin取得
	 *
	 * @return senttime_begin senttime_begin
	 */
	public String getSenttime_begin();
	/**
	 * senttime_end取得
	 *
	 * @return senttime_end senttime_end
	 */
	public String getSenttime_end();
	/**
	 * sentstatus_eq取得
	 *
	 * @return sentstatus_eq sentstatus_eq
	 */
	public char getSentstatus_eq();
}