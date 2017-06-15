/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���ղ��Ա�ӿ�
  * ��������: ���ղ��Ա�ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface RiskStrategyInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRsid();

	/**
	 * ���ղ�������ȡ��
	 *
	 * @return ���ղ�������
	 */
	public String getRsname();

	/**
	 * ���ղ�������ȡ��
	 *
	 * @return ���ղ�������
	 */
	public String getRsdesc();

	/**
	 * ���Կ�ʼʱ��ȡ��
	 *
	 * @return ���Կ�ʼʱ��
	 */
	public String getRsstartdate();

	/**
	 * ���Խ���ʱ��ȡ��
	 *
	 * @return ���Խ���ʱ��
	 */
	public String getRsenddate();

	/**
	 * ״̬(1.����2.ͣ��)ȡ��
	 *
	 * @return ״̬(1.����2.ͣ��)
	 */
	public String getRsstatus();

	/**
	 * ���ռ��Ƶ��ȡ��
	 *
	 * @return ���ռ��Ƶ��
	 */
	public String getRsfrequency();

	/**
	 * ���ռ��Ƶ������ȡ��
	 *
	 * @return ���ռ��Ƶ������
	 */
	public String getRsfrequencydesc();

	/**
	 * ���ղ���ָ���ϵ��idȡ��
	 *
	 * @return ���ղ���ָ���ϵ��id
	 */
	public Integer getSirid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRsattachkey();

}