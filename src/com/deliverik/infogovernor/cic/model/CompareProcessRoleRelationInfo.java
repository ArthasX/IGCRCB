/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ϵ��ӿ�
  * ��������: ��ϵ��ӿ�
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public interface CompareProcessRoleRelationInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * �ȶ����������ȡ��
	 *
	 * @return �ȶ����������
	 */
	public Integer getCpid();

	/**
	 * �Աȹ��������ȡ��
	 *
	 * @return �Աȹ��������
	 */
	public Integer getCrid();

	/**
	 * �ȶԹ����汾ȡ��
	 *
	 * @return �ȶԹ����汾
	 */
	public Integer getCrversion();

}