/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����������ӿ�
  * ��������: �����������ӿ�
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public interface SOC0304Info extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getMtId();

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getMtSsn();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getMtCname();
	
	/**
	 * ���������ַ���ȡ��
	 *
	 * @return mtObjNames ���������ַ���
	 */
	public String getMtObjNames() ;
	/**
	 * kpiȡ��
	 *
	 * @return kpi
	 */
	public String getMtKpi();

	/**
	 * �ɼ����ȡ��
	 *
	 * @return �ɼ����
	 */
	public Integer getMtInterval();

	/**
	 * �ɼ�����ȡ��
	 *
	 * @return �ɼ�����
	 */
	public Integer getMtNum();

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getMtStartTime();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getMtStopTime();

	/**
	 * Ԥ�ƽ���ʱ��ȡ��
	 *
	 * @return Ԥ�ƽ���ʱ��
	 */
	public String getMtPStopTime();

	/**
	 * ����״̬ȡ�� 0Ϊ���� 1Ϊ�ر�
	 *
	 * @return ����״̬
	 */
	public String getMtStatus();

	/**
	 * ��¼ʱ��ȡ��
	 *
	 * @return ��¼ʱ��
	 */
	public String getMtRecordTime();

	/**
	 * ��¼�û�idȡ��
	 *
	 * @return ��¼�û�id
	 */
	public String getMtUserId();

	/**
	 * �û�����IDȡ��
	 *
	 * @return �û�����ID
	 */
	public String getMtOrgId();

}