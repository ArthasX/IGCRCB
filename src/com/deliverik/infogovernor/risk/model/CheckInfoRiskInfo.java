/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����Թ���������ӿ�
  * ��������: �����Թ���������ӿ�
  * ������¼: 2014/09/03
  * �޸ļ�¼: 
  */
public interface CheckInfoRiskInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCieid();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getCsid();

	/**
	 * �����idȡ��
	 *
	 * @return �����id
	 */
	public Integer getRcid();

}