/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����: ���Ŷ��б�ӿ� ��������: ���Ŷ��б�ӿ� ������¼: 2012/10/31 �޸ļ�¼:
 */
public interface SmsQueueInfo extends BaseModel {

	public Integer getQid();

	public String getAlertId();

	public String getTel();

	public String getUserId();

	public String getUserName();

	public String getSmsContext();

	public String getAlertTime();

}