/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: vCloud����ģ��ӿ�
  * ��������: vCloud����ģ��ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD05Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getTemplateName();

	/**
	 * vCloudIdȡ��
	 *
	 * @return vCloudId
	 */
	public Integer getVcloudid();

	/**
	 * vapp����ȡ��
	 *
	 * @return vapp����
	 */
	public String getVappname();

}