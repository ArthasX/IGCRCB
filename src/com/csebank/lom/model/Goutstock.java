/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.csebank.lom.model.entity.RecptionTB;
import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * ��Ʒ������Ϣʵ��ӿ�
 *
 */
public interface Goutstock extends BaseModel {

	/**
	 *��Ʒ������ϢIDȡ��
	 * @return ��Ʒ������ϢID
	 */
	public Integer getGoid();
	
	/**
	 * �Ӵ�����IDȡ��
	 * @return �Ӵ�����ID
	 */
	public Integer getRid();
	
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
	 * ���ⵥ��ȡ��
	 * @return ���ⵥ��
	 */
	public BigDecimal getGooutprice();


	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGoinnum();


	/**
	 * ������λȡ��
	 * @return ������λ
	 */
	public String getGounit();


	/**
	 * ��Ӧ��ȡ��
	 * @return ��Ӧ��
	 */
	public String getGoprovider();



	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getGopurchaser();


	/**
	 * �����۸�ȡ��
	 * @return �����۸�
	 */
	public BigDecimal getGoreliefprice();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGoreliefnum();


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
	 * ������/������IDȡ��
	 * @return ������/������ID
	 */
	public String getGorequser();



	/**
	 * ������/����������ȡ��
	 * @return ������/����������
	 */
	public String getGorequsername();


	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getGouser();


	/**
	 * �Ǽ�������ȡ��
	 * @return �Ǽ�������
	 */
	public String getGousername();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGochknum();


	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getGochkid();



	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getGochkkname();
	
	
	public OrganizationTB getOrganizationTB();

	public RecptionTB getRecptionTB();
	
	/**
	 * ˵��ȡ��
	 * @return ˵��
	 */
	public String getGoreason();
}
