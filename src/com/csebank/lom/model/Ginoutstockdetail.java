/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;



import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * ��Ʒ�������ϸ��Ϣʵ��ӿ�
 *
 */
public interface Ginoutstockdetail extends BaseModel {

	/**
	 * ��Ʒ�������ϸ��ϢIDȡ��
	 * @return ��Ʒ�������ϸ��ϢID
	 */
	public Integer getGiodid();


	/**
	 * �������ȡ��
	 * @return �������
	 */
	public Integer getGsnum();
	

	/**
	 * ���������(0:��� 1:���� 2:���� 3:����)ȡ��
	 * @return ���������(0:��� 1:���� 2:���� 3:����)
	 */
	public String getGiodtype();




	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGiodorg();




	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGiodcategory();




	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGiodname();




	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGiodcode();




	/**
	 * �����ʱ��ȡ��
	 * @return �����ʱ��
	 */
	public String getGiodtime();




	/**
	 * �ɹ����뵥����ȡ��
	 * @return �ɹ����뵥����
	 */
	public String getGiodreqnum();




	/**
	 * ��ⵥ��ȡ��
	 * @return ��ⵥ��
	 */
	public BigDecimal getGiodinprice();




//	/**
//	 * ���ⵥ��ȡ��
//	 * @return ���ⵥ��
//	 */
//	public BigDecimal getGiodoutprice();




	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public Integer getGiodinnum();



	/**
	 * ������λȡ��
	 * @return ������λ
	 */
	public String getGiodunit();




	/**
	 * ��Ӧ��ȡ��
	 * @return ��Ӧ��
	 */
	public String getGiodprovider();




	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getGiodpurchaser();




	/**
	 * �����۸�ȡ��
	 * @return �����۸�
	 */
	public BigDecimal getGiodreliefprice();




	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGiodreliefnum();




	/**
	 * �����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)ȡ��
	 * @return �����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)
	 */
	public String getGiodstatus();




	/**
	 * ���û���/�������������ȡ��
	 * @return ���û���/�������������
	 */
	public String getGiodreqorg();




	/**
	 * ������/������IDȡ��
	 * @return ������/������ID
	 */
	public String getGiodrequser();




	/**
	 * ������/����������ȡ��
	 * @return ������/����������
	 */
	public String getGiodrequsername();




	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getGioduser();




	/**
	 * �Ǽ�������ȡ��
	 * @return �Ǽ�������
	 */
	public String getGiodusername();



	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGiodchknum();




	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getGiodchkid();




	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getGiodchkkname();
	
	/**
	 * ��Ʒ������ϢIDȡ��
	 * @return ��Ʒ������ϢID
	 */
	public Integer getGoid();
	
	/**
	 * ��Ʒ����¼IDȡ��
	 * @return ��Ʒ����¼ID
	 */
	public Integer getGioid();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGiodoutnum();



	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGiodhavocnum();
}
