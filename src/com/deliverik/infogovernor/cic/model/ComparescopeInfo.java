/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �Ա���ӿ�
  * ��������: �Ա���ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface ComparescopeInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCsid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCsname();
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getCreatetime();

	/**
	 * �汾ȡ��
	 * @return
	 */
	public Integer getCsversion();
}