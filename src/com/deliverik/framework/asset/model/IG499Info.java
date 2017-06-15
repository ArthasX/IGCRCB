/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import java.io.Serializable;

/**
  * ����: ��ͬ�ʲ���Ϣ��ͼ�ӿ�
  * ��������: ��ͬ�ʲ���Ϣ��ͼ�ӿ�
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public interface IG499Info extends Serializable{

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�����
	 */
	public String getEiname();

	/**
	 * �ʲ�˵��ȡ��
	 *
	 * @return �ʲ�˵��
	 */
	public String getEidesc();

	/**
	 * �ʲ����ȡ��
	 *
	 * @return �ʲ����
	 */
	public String getEilabel();

	/**
	 * �ʲ����ʱ��ȡ��
	 *
	 * @return �ʲ����ʱ��
	 */
	public String getEiupdtime();

	/**
	 * �ʲ�״̬ȡ��
	 *
	 * @return �ʲ�״̬
	 */
	public String getEistatus();

	/**
	 * �ʲ�ģ������ȡ��
	 *
	 * @return �ʲ�ģ������
	 */
	public String getEname();

	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 *
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel();

	/**
	 * �ʲ�ģ��˵��ȡ��
	 *
	 * @return �ʲ�ģ��˵��
	 */
	public String getEdesc();

	/**
	 * �ʲ�ģ��״̬ȡ��
	 *
	 * @return �ʲ�ģ��״̬
	 */
	public String getEstatus();

	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 *
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory();

	/**
	 * �ʲ�ģ��һ������ȡ��
	 *
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1();

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 *
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2();

	/**
	 * �ʲ�ģ����������ȡ��
	 *
	 * @return �ʲ�ģ����������
	 */
	public String getEkey3();

	/**
	 * �ʲ��汾��ȡ��
	 *
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion();

	/**
	 * �ʲ��Ǽ���ȡ��
	 *
	 * @return �ʲ��Ǽ���
	 */
	public String getEiinsdate();

	/**
	 * �ʲ���������ȡ��
	 *
	 * @return �ʲ���������
	 */
	public String getEiorgsyscoding();

	/**
	 * �ʲ�ģ��ȡ��
	 *
	 * @return �ʲ�ģ��
	 */
	public String getEsyscoding();

	/**
	 * �ʲ�������ȡ��
	 *
	 * @return �ʲ�������
	 */
	public String getEiuserid();

	/**
	 * �ʲ�����������ȡ��
	 *
	 * @return �ʲ�����������
	 */
	public String getEiusername();

	/**
	 * �ʲ�С�汾ȡ��
	 *
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion();

	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 *
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getFacilitator();

	/**
	 * ǩ��ʱ��ȡ��
	 *
	 * @return ǩ��ʱ��
	 */
	public String getCondudetime();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOperator();

	/**
	 * ��ͬ���ȡ��
	 *
	 * @return ��ͬ���
	 */
	public String getCompacttype();

	/**
	 * ��ͬ��ȡ��
	 *
	 * @return ��ͬ��
	 */
	public String getContractpayment();

	/**
	 * �Ѹ���ȡ��
	 *
	 * @return �Ѹ���
	 */
	public String getCountmoney();

	/**
	 * ��󸶿���ȡ��
	 *
	 * @return ��󸶿���
	 */
	public String getLastdatetime();
	
	/**
	 * ����Ԥ����ȡ��
	 * @return ����Ԥ����
	 */
	public String getImprest();

}