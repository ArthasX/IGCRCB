/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������ʱ�豸��Ϣ��ӿ�
  * ��������: ������ʱ�豸��Ϣ��ӿ�
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
public interface EntityItemTempInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEitid();

	/**
	 * ��Ӧ�Ĳɹ����ȡ��
	 *
	 * @return ��Ӧ�Ĳɹ����
	 */
	public String getEitConNum();
	
	/**
	 * ��Ӧ�ķ�����Eiidȡ��
	 *
	 * @return eitSupEiid ��Ӧ�ķ�����Eiid
	 */
	public String getEitSupEiid();
	
	/**
	 * ��Ӧ�ķ����̱��ȡ��
	 *
	 * @return eitSupNum ��Ӧ�ķ����̱��
	 */
	public String getEitSupNum();
	
	/**
	 * ��Ӧ�Ĳɹ�Eiidȡ��
	 *
	 * @return eitConEiid ��Ӧ�Ĳɹ�Eiid
	 */
	public String getEitConEiid();

	/**
	 * �豸�����Ǹ�ȡ��
	 *
	 * @return �豸����
	 */
	public String getEitBClass();

	/**
	 * �豸С��ȡ��
	 *
	 * @return �豸С��
	 */
	public String getEitSClass();

	/**
	 * �豸Ʒ��ȡ��
	 *
	 * @return �豸Ʒ��
	 */
	public String getEitBrand();

	/**
	 * �豸�ͺ�ȡ��
	 *
	 * @return �豸�ͺ�
	 */
	public String getEitModelNum();

	/**
	 * �豸��Ȩ����ȡ��
	 *
	 * @return �豸��Ȩ����
	 */
	public String getEitSyscoding();

	/**
	 * ԭʼ�۸�ȡ��
	 *
	 * @return ԭʼ�۸�
	 */
	public String getEitPrice();

	/**
	 * ά������ȡ��
	 *
	 * @return ά������
	 */
	public String getEitFYear();

	/**
	 * �豸����ȡ��
	 *
	 * @return �豸����
	 */
	public Integer getEitNum();

	/**
	 * ���޿�ʼ����ȡ��
	 *
	 * @return ���޿�ʼ����
	 */
	public String getEitWarFrom();

	/**
	 * ���޽�������ȡ��
	 *
	 * @return ���޽�������
	 */
	public String getEitWarTo();

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getEitDesc();

	/**
	 * δ�����豸����ȡ��
	 *
	 * @return δ�����豸����
	 */
	public Integer getEitUncheckNum();

	/**
	 * �������豸����ȡ��
	 *
	 * @return �������豸����
	 */
	public Integer getEitCheckedNum();
	
	/**
	 * �ɹ�ʱ��ȡ��
	 *
	 * @return eitPurchaseDate �ɹ�ʱ��
	 */
	public String getEitPurchaseDate();

	/**
	 * ����idȡ��
	 *
	 * @return prid ����id
	 */
	public Integer getPrid();
	/** ��� */
	public String getType();
}