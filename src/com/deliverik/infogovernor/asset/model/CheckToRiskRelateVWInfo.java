/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �������յ��ϵģ�ͽӿ�
  * ��������: �������յ��ϵģ�ͽӿ�
  * ������¼: 2014/07/23
  * �޸ļ�¼: 
  */
public interface CheckToRiskRelateVWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEiid();

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getEilabel();

	/**
	 * ���ռ���ȡ��
	 *
	 * @return ���ռ���
	 */
	public String getLevels();

	/**
	 * �������صȼ�ȡ��
	 *
	 * @return �������صȼ�
	 */
	public String getGrad();

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getEiname();

	/**
	 * ���յ��־ȡ��
	 *
	 * @return ���յ��־
	 */
	public String getRisksign();

	/**
	 * ���շ�������ȡ��
	 *
	 * @return ���շ�������
	 */
	public String getPoss();

	/**
	 * �����˵��ȡ��
	 *
	 * @return �����˵��
	 */
	public String getEidesc();

}