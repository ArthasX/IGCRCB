/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �������ϸ��ӿ�
  * ��������: �������ϸ��ӿ�
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public interface RegulatoryReportDetailInfo extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getDetailID();

	/**
	 * �ʵ��IDȡ��
	 *
	 * @return �ʵ��ID
	 */
	public Integer getInstanceID();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid();
	

}