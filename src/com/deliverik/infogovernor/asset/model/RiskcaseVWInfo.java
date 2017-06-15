/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����¼��ӿ�
  * ��������: �����¼��ӿ�
  * ������¼: 2014/07/18
  * �޸ļ�¼: 
  */
public interface RiskcaseVWInfo extends BaseModel {

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEIID();

	/**
	 * �����¼�����ȡ��
	 *
	 * @return �����¼�����
	 */
	public String getFcname();

	/**
	 * �����¼�����ȡ��
	 *
	 * @return �����¼�����
	 */
	public String getFcdesc();

	/**
	 * �����¼�״̬ȡ��
	 *
	 * @return �����¼�״̬
	 */
	public String getEISTATUS();

	/**
	 * ���յ�����ȡ��
	 *
	 * @return ���յ�����
	 */
	public String getFcriskname();

	/**
	 * ���յ�ID ȡ��
	 *
	 * @return ���յ�ID 
	 */
	public String getRiskid();

	/**
	 * �����¼���Դȡ��
	 *
	 * @return �����¼���Դ
	 */
	public String getFcorigin();

	/**
	 * �����¼���������ȡ��
	 *
	 * @return �����¼���������
	 */
	public String getFccategory();

	/**
	 * �����������ID ȡ��
	 *
	 * @return �����������ID 
	 */
	public String getRiskjobid();

	/**
	 * ���յ����IDȡ��
	 *
	 * @return ���յ����ID
	 */
	public String getRisktype();

	/**
	 * �������ؼ�������ȡ��
	 *
	 * @return �������ؼ�������
	 */
	public String getFcseveritylevel();

	/**
	 * ���շ�������������ȡ��
	 *
	 * @return ���շ�������������
	 */
	public String getFcpossibility();

	/**
	 * ���ռ�������ȡ��
	 *
	 * @return ���ռ�������
	 */
	public String getFclevel();

	/**
	 * ����ʶ��ʱ��ȡ��
	 *
	 * @return ����ʶ��ʱ��
	 */
	public String getRiskcatchtime();

	/**
	 * Ӧ����������ȡ��
	 *
	 * @return Ӧ����������
	 */
	public String getFcrisktask();

	/**
	 * Ӧ����������ȡ��
	 *
	 * @return Ӧ����������
	 */
	public String getFcrisktaskdesc();

	/**
	 * Ӧ�Բ���ȡ��
	 *
	 * @return Ӧ�Բ���
	 */
	public String getFcpolicy();

	/**
	 * Ӧ��Ŀ�� ȡ��
	 *
	 * @return Ӧ��Ŀ�� 
	 */
	public String getFcoperatoraim();

	/**
	 * Ӧ�Բ���IDȡ��
	 *
	 * @return Ӧ�Բ���ID
	 */
	public String getRiskoperatordept();

	/**
	 * Ӧ�Բ���ȡ��
	 *
	 * @return Ӧ�Բ���
	 */
	public String getFcoperatordept();

	/**
	 * Ӧ�Ը�����IDȡ��
	 *
	 * @return Ӧ�Ը�����ID
	 */
	public String getRiskoperator();

	/**
	 * Ӧ�Ը�����ȡ��
	 *
	 * @return Ӧ�Ը�����
	 */
	public String getFcoperator();

	/**
	 * ���ͷ����ԱIDȡ��
	 *
	 * @return ���ͷ����ԱID
	 */
	public String getRiskccoperator();

	/**
	 * ���ͷ����Աȡ��
	 *
	 * @return ���ͷ����Ա
	 */
	public String getFcccoperator();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRiskreviewresult();
	
	/**
	 * �����������ID
	 *
	 * @return �����������ID
	 */
	public String getRiskdealid();
	
	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public String getVersion();

}