/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.mail.model;

import java.io.Serializable;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM04TB;

/**
 * 概述: 短信队列表接口 功能描述: 短信队列表接口 创建记录: 2012/10/31 修改记录:
 */
public interface AlermSendMailQueueInfo extends BaseModel {
	/**
	 * mid取得
	 *
	 * @return mid mid
	 */
	public Integer getMid();



	/**
	 * crm04fk取得
	 *
	 * @return crm04fk crm04fk
	 */
	public Integer getCrm04fk();



	/**
	 * inserttime取得
	 *
	 * @return inserttime inserttime
	 */
	public String getInserttime();



	/**
	 * senttime取得
	 *
	 * @return senttime senttime
	 */
	public String getSenttime();



	/**
	 * sentstatus取得
	 *
	 * @return sentstatus sentstatus
	 */
	public char getSentstatus();

	public Serializable getPK();
	
	/**
	 * crm04TB取得
	 *
	 * @return crm04TB crm04TB
	 */
	public CRM04TB getCrm04TB();
}