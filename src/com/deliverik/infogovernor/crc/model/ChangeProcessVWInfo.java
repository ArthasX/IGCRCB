/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������̽ӿ�
  * ��������: ������̽ӿ�
  * ������¼: 2015/01/04
  * �޸ļ�¼: 
  */
public interface ChangeProcessVWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPrid();

	/**
	 * ������ȡ��
	 * @return the prserialnum
	 */
	public String getPrserialnum();
	
	/**
	 * ����˵��ȡ��
	 * @return the prdesc
	 */
	public String getPrdesc();
	
	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPrstatus();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtitle();

	/**
	 * ���̿�ʼʱ��ȡ��
	 *
	 * @return ���̿�ʼʱ��
	 */
	public String getPropentime();

	/**
	 * ���̹ر�ʱ��ȡ��
	 *
	 * @return ���̹ر�ʱ��
	 */
	public String getPrclosetime();

	/**
	 * ���̷�����ȡ��
	 * @return the prusername
	 */
	public String getPrusername();
	
	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeclassify();

	/**
	 * ����ƽ̨ȡ��
	 *
	 * @return ����ƽ̨
	 */
	public String getUpdateplatform();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangetype();

	/**
	 * ���ԭ��ȡ��
	 *
	 * @return ���ԭ��
	 */
	public String getChangereason();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getChangecategory();

	/**
	 * ҵ��Ӱ�췶Χȡ��
	 *
	 * @return ҵ��Ӱ�췶Χ
	 */
	public String getBusinessscope();

	/**
	 * �Ƿ�Ӱ��ҵ��ȡ��
	 *
	 * @return �Ƿ�Ӱ��ҵ��
	 */
	public String getIsinfluence();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangecontent();

	/**
	 * ����״̬����ȡ��
	 *
	 * @return ����״̬����
	 */
	public String getOrderstatus();

}