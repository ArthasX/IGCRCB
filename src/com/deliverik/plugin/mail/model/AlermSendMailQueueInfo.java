/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.mail.model;

import java.io.Serializable;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM04TB;

/**
 * ����: ���Ŷ��б�ӿ� ��������: ���Ŷ��б�ӿ� ������¼: 2012/10/31 �޸ļ�¼:
 */
public interface AlermSendMailQueueInfo extends BaseModel {
	/**
	 * midȡ��
	 *
	 * @return mid mid
	 */
	public Integer getMid();



	/**
	 * crm04fkȡ��
	 *
	 * @return crm04fk crm04fk
	 */
	public Integer getCrm04fk();



	/**
	 * inserttimeȡ��
	 *
	 * @return inserttime inserttime
	 */
	public String getInserttime();



	/**
	 * senttimeȡ��
	 *
	 * @return senttime senttime
	 */
	public String getSenttime();



	/**
	 * sentstatusȡ��
	 *
	 * @return sentstatus sentstatus
	 */
	public char getSentstatus();

	public Serializable getPK();
	
	/**
	 * crm04TBȡ��
	 *
	 * @return crm04TB crm04TB
	 */
	public CRM04TB getCrm04TB();
}