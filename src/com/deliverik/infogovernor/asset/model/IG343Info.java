/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;


/**
  * ����: IG343Info�ӿ�
  * ��������: IG343Info�ӿ�
  * ������¼: 2012/07/12
  * �޸ļ�¼: 
  */
public interface IG343Info {

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getEiid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getEiname();

	/**
	 * �豸�ʲ�ȡ��
	 *
	 * @return �豸�ʲ�
	 */
	public Integer getCivalue();

	/**
	 * �豸�ʲ�����ȡ��
	 *
	 * @return �豸�ʲ�����
	 */
	public Double getCivalue1();

	/**
	 * Ӧ���ʲ�ȡ��
	 *
	 * @return Ӧ���ʲ�
	 */
	public Integer getCivalue2();

	/**
	 * Ӧ���ʲ�����ȡ��
	 *
	 * @return Ӧ���ʲ�����
	 */
	public Double getCivalue3();

	/**
	 * ��ѵ��¼ȡ��
	 *
	 * @return ��ѵ��¼
	 */
	public Integer getEiname3();

	/**
	 * ��ѵ��¼����ȡ��
	 *
	 * @return ��ѵ��¼����
	 */
	public Double getCivalue4();

	/**
	 * ��ȡ�ϼƴ���
	 * @return �ϼƴ���
	 */
	public Integer getSumcount();
	
	/**
	 * ��ȡ�ϼ�ƽ����
	 * @return �ϼ�ƽ����
	 */
	public Double getSumstore();
}