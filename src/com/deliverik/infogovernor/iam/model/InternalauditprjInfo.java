/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������Ŀ�ӿ�
  * ��������: ������Ŀ�ӿ�
  * ������¼: 2012/07/19
  * �޸ļ�¼: 
  */
public interface InternalauditprjInfo extends BaseModel {

	/**
	 * ��������������ȡ��
	 *
	 * @return ��������������
	 */
	public Integer getIapId();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getIapYear();

	/**
	 * �����Ŀ����ȡ��
	 *
	 * @return �����Ŀ����
	 */
	public String getIapName();

	/**
	 * �����Ŀ״̬ȡ��
	 *
	 * @return �����Ŀ״̬
	 */
	public String getIapStatus();

	/**
	 * ��ƶ���ȡ��
	 *
	 * @return ��ƶ���
	 */
	public String getIapObject();

	/**
	 * ��Ʒ�ʽȡ��
	 *
	 * @return ��Ʒ�ʽ
	 */
	public String getIapWay();

	/**
	 * �����Աȡ��
	 *
	 * @return �����Ա
	 */
	public String getIapUserName();

	/**
	 * ��ƿ�ʼ����ȡ��
	 *
	 * @return ��ƿ�ʼ����
	 */
	public String getIapOpenTime();

	/**
	 * ��ƽ�������ȡ��
	 *
	 * @return ��ƽ�������
	 */
	public String getIapCloseTime();

	/**
	 * ���Ŀ��ȡ��
	 *
	 * @return ���Ŀ��
	 */
	public String getIapObjective();

	/**
	 * ��Ʒ�Χȡ��
	 *
	 * @return ��Ʒ�Χ
	 */
	public String getIapScope();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getIapBasis ();

	/**
	 * ������ݼ�Ҫ��ȡ��
	 *
	 * @return ������ݼ�Ҫ��
	 */
	public String getIapDesc();

	/**
	 * ��������Աȡ��
	 *
	 * @return ��������Ա
	 */
	public String getIapCooperator();

	/**
	 * ��ƽ���ȡ��
	 *
	 * @return ��ƽ���
	 */
	public String getIapSuggestion();

	/**
	 * �����Ŀ������IDȡ��
	 *
	 * @return �����Ŀ������ID
	 */
	public String getIapCreateUserId();

	/**
	 * �����Ŀ����ʱ��ȡ��
	 *
	 * @return �����Ŀ����ʱ��
	 */
	public String getIapCreateTime();

	/**
	 * �����Ŀȷ����IDȡ��
	 *
	 * @return �����Ŀȷ����ID
	 */
	public String getIapConfirmUserId();

	/**
	 * �����Ŀȷ��ʱ��ȡ��
	 *
	 * @return �����Ŀȷ��ʱ��
	 */
	public String getIapConfirmTime();

	/**
	 * ��Ƹ���Keyȡ��
	 *
	 * @return ��Ƹ���Key
	 */
	public String getIapAttKey();

	/**
	 * �������ȡ��
	 * 
	 * @return �������
	 */
	public String getIapType();
	
	/**
	 * ��Ƽ����Դ
	 * 
	 * @return ��Ƽ����Դ
	 */
	public String getIapSource();
}