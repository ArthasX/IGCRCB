/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���Ŷ��б�ӿ�
  * ��������: ���Ŷ��б�ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface SendSmsLogInfo extends BaseModel {
	public Integer getId();

	public String getSmsContext();

	public String getAlertTime();

	public String getSendTime();

	public String getSendStatus();

	public String getTel();

	public String getUserId();

}