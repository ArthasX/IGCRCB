/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �澯�����ӿ�
  * ��������: �澯�����ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00002Info extends BaseModel {

	public Integer getRelationid();

	public Integer getDeviceid();

	public Integer getMaxalarmnum();

	public Integer getMaxalarmtime();

	public Integer getRuletempid();

	public String getCreatetime();

}