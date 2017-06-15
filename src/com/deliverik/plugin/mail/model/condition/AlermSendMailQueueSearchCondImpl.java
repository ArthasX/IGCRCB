/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.mail.model.condition;


/**
  * 概述: 邮件队列表检索条件实现
  * 功能描述: 邮件队列表检索条件实现
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public class AlermSendMailQueueSearchCondImpl implements AlermSendMailQueueSearchCond {
	/** 插入记录时间 */
	protected String inserttime_begin;
	protected String inserttime_end;
	/** 发送告警时间 */
	protected String senttime_begin;
	protected String senttime_end;
	/** 发送告警状态 0 未发送or失败 ;1发送成功 */
	protected char sentstatus_eq;
	/**
	 * inserttime_begin取得
	 *
	 * @return inserttime_begin inserttime_begin
	 */
	public String getInserttime_begin() {
		return inserttime_begin;
	}
	/**
	 * inserttime_end取得
	 *
	 * @return inserttime_end inserttime_end
	 */
	public String getInserttime_end() {
		return inserttime_end;
	}
	/**
	 * senttime_begin取得
	 *
	 * @return senttime_begin senttime_begin
	 */
	public String getSenttime_begin() {
		return senttime_begin;
	}
	/**
	 * senttime_end取得
	 *
	 * @return senttime_end senttime_end
	 */
	public String getSenttime_end() {
		return senttime_end;
	}
	/**
	 * sentstatus_eq取得
	 *
	 * @return sentstatus_eq sentstatus_eq
	 */
	public char getSentstatus_eq() {
		return sentstatus_eq;
	}
	/**
	 * inserttime_begin设定
	 *
	 * @param inserttime_begin inserttime_begin
	 */
	public void setInserttime_begin(String inserttime_begin) {
		this.inserttime_begin = inserttime_begin;
	}
	/**
	 * inserttime_end设定
	 *
	 * @param inserttime_end inserttime_end
	 */
	public void setInserttime_end(String inserttime_end) {
		this.inserttime_end = inserttime_end;
	}
	/**
	 * senttime_begin设定
	 *
	 * @param senttime_begin senttime_begin
	 */
	public void setSenttime_begin(String senttime_begin) {
		this.senttime_begin = senttime_begin;
	}
	/**
	 * senttime_end设定
	 *
	 * @param senttime_end senttime_end
	 */
	public void setSenttime_end(String senttime_end) {
		this.senttime_end = senttime_end;
	}
	/**
	 * sentstatus_eq设定
	 *
	 * @param sentstatus_eq sentstatus_eq
	 */
	public void setSentstatus_eq(char sentstatus_eq) {
		this.sentstatus_eq = sentstatus_eq;
	}
}