package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * �ʲ���Ϣ��ͼ
 * 
 */
public interface SOC0605Info {

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname();
	
	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel();

	/**
	 * �ʲ�˵��ȡ��
	 * @return �ʲ�˵��
	 */
	public String getEidesc();

	/**
	 * �ʲ�����ʱ��ȡ��
	 * @return �ʲ�����ʱ��
	 */
	public String getEiupdtime();

	/**
	 * �ʲ�״̬ȡ��
	 * @return �ʲ�״̬
	 */
	public String getEistatus();

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname();
	
	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel();

	/**
	 * �ʲ�ģ��˵��ȡ��
	 * @return �ʲ�ģ��˵��
	 */
	public String getEdesc();

	/**
	 * �ʲ�ģ��״̬ȡ��
	 * @return �ʲ�ģ��״̬
	 */
	public String getEstatus();

	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory();

	/**
	 * �ʲ�ģ��һ������ȡ��
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1();

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2();

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getEkey3();

	/**
	 * �ʲ��汾��ȡ��
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion();

	/**
	 * �ʲ��Ǽ���ȡ��
	 * @return �ʲ��Ǽ���
	 */
	public String getEiinsdate();
	
	/**
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public String getEiorgsyscoding();
	/**
	 * �ʲ�ģ��ȡ��
	 * @return �ʲ�ģ��
	 */
	public String getEsyscoding();
	
	/**
	 * �ʲ��ѽ�����ϵ����ȡ��
	 * @return �ʲ��ѽ�����ϵ����
	 */
	public String getEircount();
	
	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiuserid();
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername();
	
	/**
	 * �ʲ�����������Ϣʵ��ȡ��
	 * @return �ʲ�����������Ϣʵ��
	 */
	public OrganizationTB getOrganizationTB();
	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getSerial();
	/**
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public String getBuytime();
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion();
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark();
	
	/**
	 * �ʲ�ģ�����ȡ��
	 * @return �ʲ�ģ�����
	 */
	public String getEmodeltype();
	
}