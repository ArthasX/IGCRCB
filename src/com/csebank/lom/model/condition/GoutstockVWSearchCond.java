/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;

/**
 * 
 * ��Ʒ������Ϣ��ͼ��ѯ�ӿ�
 *
 */
public interface GoutstockVWSearchCond {
	

	/**
	 *��Ʒ������ϢIDȡ��
	 * @return ��Ʒ������ϢID
	 */
	public Integer getGoid();

	/**
	 * ��������(0:��� 1:���� 2:���� 3:����)ȡ��
	 * @return ��������(0:��� 1:���� 2:���� 3:����)
	 */
	public String getGotype();
	

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGoorg();


	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGocategory();

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGoname();
	

	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGocode();
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getGotime();
	
	/**
	 * �ɹ����뵥����ȡ��
	 * @return �ɹ����뵥����
	 */
	public String getGoreqnum();
	
	/**
	 * ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)ȡ��
	 * @return ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)
	 */
	public String getGostatus();
	/**
	 * ���û���/�������������ȡ��
	 * @return ���û���/�������������
	 */
	public String getGoreqorg();
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getGsid();
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public Integer getGsnum();
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGsorg();
	/**
	 * �ɹ�ƽ����ȡ��
	 * @return �ɹ�ƽ����
	 */
	public BigDecimal getGsavgprice();
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGsfreezenum();
	
}
